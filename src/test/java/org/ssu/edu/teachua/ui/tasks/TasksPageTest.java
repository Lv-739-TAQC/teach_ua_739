package org.ssu.edu.teachua.ui.tasks;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.ssu.edu.teachua.db.entities.Task;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.TaskService;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.tasks.AddTaskPage;
import org.ssu.edu.teachua.utils.providers.DataProviderTask;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
                .clickSaveButton()
                .getErrorMsg();

        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);

        try {
            TaskService taskService = new TaskService(valueProvider.getDbUrl(), valueProvider.getDbUserName(),
                    valueProvider.getUDbUserPassword());
            List<Task> list = taskService.getTasksByName(name);
            softAssert.assertEquals(list, 0);
        } catch (DBException | EntityException e) {
            e.printStackTrace();
        }

        softAssert.assertAll();
    }

}
