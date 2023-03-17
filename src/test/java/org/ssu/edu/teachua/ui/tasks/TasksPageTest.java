package org.ssu.edu.teachua.ui.tasks;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.tasks.AddTaskPage;
import org.ssu.edu.teachua.utils.providers.DataProviderTask;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    @Test(dataProvider = "dpTestAddTaskInvalid", dataProviderClass = DataProviderTask.class)
    public void testAddTaskInvalid(int day, int month, int year, String photoPath, String name,
                                   String title, String description, String challenge, String expectedErrorMsg) {
        softAssert.assertTrue(addTaskPage.areWebElementsEmpty());

        String actualErrorMsg = addTaskPage
                .selectStartDate(day, month, year)
                .uploadPhoto(valueProvider.getFilePath(photoPath))
                .typeName(name)
                .typeTitle(title)
                .typeDescription(description)
                .selectChallenge(challenge)
                .clickSaveButton()
                .getErrorMsg();

        softAssert.assertEquals(actualErrorMsg, expectedErrorMsg);
        softAssert.assertEquals(entityService.getTaskService().getTasksByName(name).size(), 0);
        softAssert.assertAll();
    }
}
