package org.ssu.edu.teachua.ui.tasks;


import java.util.List;
import org.ssu.edu.teachua.db.entities.Task;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.TaskService;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.tasks.AddTaskPage;
import org.ssu.edu.teachua.utils.providers.DataProviderTask;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;

public class TasksPageTest extends LoginWithAdminRunner {

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
                .clickSaveButton()
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
                .clickSaveButton()
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
		addTaskPage.typeName(name).typeTitle(title).typeDescription(description).selectStartDate(25, 03, 2023)
				.selectChallenge(challenge);
		addTaskPage.clickSaveButton();

		TaskService taskService;
		try {
			taskService = new TaskService(valueProvider.getDbUrl(), valueProvider.getDbUserName(),
					valueProvider.getUDbUserPassword());
			List<Task> listTasksByName = taskService.getTasksByName(name);
			Assert.assertEquals(listTasksByName.size(), 0);
		} catch (DBException | EntityException e) {
			e.printStackTrace();
		}
	}
}
