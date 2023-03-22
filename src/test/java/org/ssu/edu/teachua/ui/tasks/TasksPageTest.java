package org.ssu.edu.teachua.ui.tasks;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.db.entities.Task;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.service.TaskService;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.tasks.AddTaskPage;
import org.ssu.edu.teachua.utils.StringGenerator;
import org.ssu.edu.teachua.utils.providers.DataProviderTask;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Calendar;
import java.util.List;

public class TasksPageTest extends LoginWithAdminRunner {

    private static final String NAME = StringGenerator.generateRandomString(20);
    private static final String TITLE = StringGenerator.generateRandomString(50);
    private static final String DESCRIPTION = StringGenerator.generateRandomString(200);
    private static final String CHALLENGE = "Ukrainian";

    private AddTaskPage addTaskPage;

    @Test
    public void testDescriptionFieldInvalid() {
        System.out.println("Result is: " + addTaskPage.areWebElementsEmpty());
    }

    @BeforeMethod
    void openAddTaskPage() {
        driver.navigate().refresh();
        addTaskPage = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openContentMenu()
                .openChallengesMenu()
                .clickTasks()
                .openAddTaskPage();
    }

    @Issue("TUA-524")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that admin can't create task with invalid data" +
                 "\n in 'Заголовок' field on 'Додайте завдання' page")
    @Test(dataProvider = "dpTestAddTaskInvalidTitle", dataProviderClass = DataProviderTask.class)
    public void testAddTaskInvalidTitle(int day, int month, int year, String photoPath, String name,
                                        String title, String description, String challenge, String expectedErrorMsg) {
        SoftAssert dpSoftAssert = new SoftAssert();
        dpSoftAssert.assertTrue(addTaskPage.areWebElementsEmpty());

        String actualErrorMsg = addTaskPage
                .selectStartDate(day, month, year)
                .uploadPhoto(valueProvider.getFilePath(photoPath))
                .typeName(name)
                .typeTitle(title)
                .typeDescription(description)
                .selectChallenge(challenge)
                .clickFailSaveButton()
                .getErrorMsg();

        dpSoftAssert.assertEquals(actualErrorMsg, expectedErrorMsg);
        dpSoftAssert.assertEquals(entityService.getTaskService().getTasksByName(name).size(), 0);
        dpSoftAssert.assertAll();
    }

    @Issue("TUA-521")
    @Description("Verify that admin can't create a task with invalid date on 'Додайте завдання' page")
    @Test(dataProvider = "dpTestAddClubWithInvalidDate", dataProviderClass = DataProviderTask.class)
    public void testAddClubWithInvalidDate(String photoPath, String name, String title, String description,
                                           String challenge, int day, int month, int year, String expectedErrorMsg) {
        softAssert.assertTrue(addTaskPage.areWebElementsEmpty());

        String actualErrorMsg = addTaskPage.
                uploadPhoto(valueProvider.getFilePath(photoPath))
                .typeName(name)
                .typeTitle(title)
                .typeDescription(description)
                .selectChallenge(challenge)
                .selectStartDate(day, month, year)
                .clickFailSaveButton()
                .getErrorMsg();

        softAssert.assertEquals(actualErrorMsg, expectedErrorMsg);
        softAssert.assertEquals(entityService.getTaskService().getTasksByName(name).size(), 0);
        softAssert.assertAll();
    }

    @Issue("TUA-522")
    @Description("Verify that admin can't create a task without image on 'Додайте завдання' page")
    @Test
    public void testVerifyCreateNewTaskWithOutLoadPicture() {
        String name = "TestName";
        String title = "TestTitleTestTitleTestTitleTestTitleTestTitleTestTitle";
        String description = "TestDescriptionTestDescriptionTestDescriptionTestDescriptionTestDescription";
        String challenge = "Ukrainian";
        addTaskPage.typeName(name)
                .typeTitle(title)
                .typeDescription(description)
                .selectStartDate(25, 03, 2023)
                .selectChallenge(challenge)
                .clickSuccessSaveButton();

        try {
            TaskService taskService = new TaskService(valueProvider.getDbUrl(), valueProvider.getDbUserName(), valueProvider.getUDbUserPassword());
            List<Task> listTasksByName = taskService.getTasksByName(name);
            Assert.assertEquals(listTasksByName.size(), 0);
        } catch ( DBException e) {
            e.printStackTrace();
        }
    }

    @Issue(value = "TUA-526")
    @Description(value = "[Завдання] Verify that admin can't create a task without choosing any challenge in dropdown list on the 'Челендж' field")
    @Test
    public void verifyThatAdminCantCreateTaskWithoutChoosingAnyChallengeInDropdownList() {
        Calendar now = Calendar.getInstance();
        String errorMessage = addTaskPage
                .selectStartDate(21, 3, now.get(Calendar.YEAR) + 1)
                .uploadPhoto(valueProvider.getFilePath("photos\\heart.png"))
                .typeName(NAME)
                .typeTitle(TITLE)
                .typeDescription(DESCRIPTION)
                .clickFailSaveButton()
                .checkErrorMessage();

        softAssert.assertEquals(errorMessage, "Please, select challenge");

        List<Task> tasks = entityService.getTaskService().getTasksByName(NAME);
        softAssert.assertEquals(tasks.size(), 0);
        softAssert.assertAll();
    }

    @Issue(value = "TUA-520")
    @Description(value = "[Завдання] Verify that admin can create a task with valid data on 'Додайте завдання' page")
    @Test
    public void verifyThatAdminCanCreateTaskWithValidData() {
        Calendar now = Calendar.getInstance();
        String name = addTaskPage
                .selectStartDate(21, 3, now.get(Calendar.YEAR) + 1)
                .uploadPhoto(valueProvider.getFilePath("photos\\heart.png"))
                .typeName(NAME)
                .typeTitle(TITLE)
                .typeDescription(DESCRIPTION)
                .selectChallenge(CHALLENGE)
                .clickSuccessSaveButton()
                .getTaskName();

        softAssert.assertEquals(name, NAME);

        List<Task> tasks = entityService.getTaskService().getTasksByName(NAME);
        softAssert.assertEquals(tasks.size(), 1);
        softAssert.assertEquals(tasks.get(0).getName(), NAME);
        softAssert.assertAll();
    }

    @Issue("TUA-525")
    @Description("This test-case covers negative scenario when introducing changes" +
            "\n to the task's 'Опис' field results in error message shown")
    @Test(dataProvider = "dpTestAddTaskInvalidDescription", dataProviderClass = DataProviderTask.class)
    public void testAddTaskInvalidDescription(int day, int month, int year, String photoPath, String name,
                                              String title, String description, String challenge,
                                              String expectedErrorMessage) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(addTaskPage.areWebElementsEmpty());

        String actualErrorMessage = addTaskPage
                .selectStartDate(day, month, year)
                .uploadPhoto(valueProvider.getFilePath(photoPath))
                .typeName(name)
                .typeTitle(title)
                .typeDescription(description)
                .selectChallenge(challenge)
                .clickFailSaveButton()
                .getErrorMsg();

        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
        softAssert.assertEquals(entityService.getTaskService().getTasksByName(name).size(), 0);
        softAssert.assertAll();
    }
}
