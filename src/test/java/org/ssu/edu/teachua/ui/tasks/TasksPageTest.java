package org.ssu.edu.teachua.ui.tasks;

import io.qameta.allure.Issue;
import org.ssu.edu.teachua.db.entities.Task;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.TaskService;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.tasks.AddTaskPage;
import org.ssu.edu.teachua.utils.StringGenerator;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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


    private static final String NAME = StringGenerator.generateRandomString(20);
    private static final String TITLE = StringGenerator.generateRandomString(50);
    private static final String DESCRIPTION = StringGenerator.generateRandomString(200);
    private static final String CHALLENGE = "Ukrainian";
    private static final String PHOTO_PATH = "D:\\Projects\\teach_ua_739\\src\\test\\resources\\photos\\heart.png";

    private TaskService taskService;

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

        try {
            taskService = new TaskService(valueProvider.getDbUrl(), valueProvider.getDbUserName(), valueProvider.getUDbUserPassword());
            List<Task> tasks = taskService.getTasksByName(NAME);
            softAssert.assertEquals(tasks.size(), 0);
        } catch (DBException | EntityException e) {
            throw new RuntimeException(e);
        }
        softAssert.assertAll();
    }

    @Issue(value = "TUA-520")
    @Test(description = "[Завдання] Verify that admin can create a task with valid data on 'Додайте завдання' page")
    public void verifyThatAdminCanCreateTaskWithValidData() {
        Calendar now = Calendar.getInstance();
        String title = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openContentMenu()
                .openChallengesMenu()
                .clickTasks()
                .openAddTaskPage()
                .selectStartDate(now.get(Calendar.DATE), now.get(Calendar.MONTH), now.get(Calendar.YEAR) + 1)
                .uploadPhoto(PHOTO_PATH)
                .typeName(NAME)
                .typeTitle(TITLE)
                .typeDescription(DESCRIPTION)
                .selectChallenge(CHALLENGE)
                .clickSuccessSaveButton()
                .getChallengeTitle();

        softAssert.assertEquals(title, TITLE);

        try {
            taskService = new TaskService(valueProvider.getDbUrl(), valueProvider.getDbUserName(), valueProvider.getUDbUserPassword());
            List<Task> tasks = taskService.getTasksByName(NAME);
            softAssert.assertEquals(tasks.size(), 1);
        } catch (DBException | EntityException e) {
            throw new RuntimeException(e);
        }
        softAssert.assertAll();
    }

}
