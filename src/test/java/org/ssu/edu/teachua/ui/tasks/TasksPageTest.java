package org.ssu.edu.teachua.ui.tasks;

import io.qameta.allure.Issue;
import org.ssu.edu.teachua.db.entities.Task;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.tasks.AddTaskPage;
import org.ssu.edu.teachua.utils.StringGenerator;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.ssu.edu.teachua.utils.providers.DataProviderTask;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Calendar;
import java.util.List;

public class TasksPageTest extends LoginWithAdminRunner {

    private AddTaskPage addTaskPage;

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

    @Test
    public void testDescriptionFieldInvalid() {
        System.out.println("Result is: " + addTaskPage.areWebElementsEmpty());
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
    public void testAddClubWithInvalidDate(String photoPath, String name, String title,
                                           String description, String challenge, int day, int month, int year,
                                           String expectedErrorMsg) {
        softAssert.assertTrue(addTaskPage.areWebElementsEmpty());

        String actualErrorMsg = addTaskPage
                .uploadPhoto(valueProvider.getFilePath(photoPath))
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


    private static final String NAME = StringGenerator.generateRandomString(20);
    private static final String TITLE = StringGenerator.generateRandomString(50);
    private static final String DESCRIPTION = StringGenerator.generateRandomString(200);
    private static final String CHALLENGE = "Ukrainian";
    private final String PHOTO_PATH = valueProvider.getFilePath("photos\\heart.png");

    @Issue(value = "TUA-526")
    @Test(description = "[Завдання] Verify that admin can't create a task without choosing any challenge in dropdown list on the 'Челендж' field")
    public void verifyThatAdminCantCreateTaskWithoutChoosingAnyChallengeInDropdownList() {
        Calendar now = Calendar.getInstance();
        String errorMessage = addTaskPage
                .selectStartDate(now.get(Calendar.DATE), now.get(Calendar.MONTH), now.get(Calendar.YEAR) + 1)
                .uploadPhoto(PHOTO_PATH)
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
    @Test(description = "[Завдання] Verify that admin can create a task with valid data on 'Додайте завдання' page")
    public void verifyThatAdminCanCreateTaskWithValidData() {
        Calendar now = Calendar.getInstance();
        String title = addTaskPage
                .selectStartDate(now.get(Calendar.DATE), now.get(Calendar.MONTH), now.get(Calendar.YEAR) + 1)
                .uploadPhoto(PHOTO_PATH)
                .typeName(NAME)
                .typeTitle(TITLE)
                .typeDescription(DESCRIPTION)
                .selectChallenge(CHALLENGE)
                .clickSuccessSaveButton()
                .getChallengeTitle();

        softAssert.assertEquals(title, TITLE);


        List<Task> tasks = entityService.getTaskService().getTasksByName(NAME);
        softAssert.assertEquals(tasks.size(), 1);
        softAssert.assertAll();
    }

}
