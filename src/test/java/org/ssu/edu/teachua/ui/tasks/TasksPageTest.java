package org.ssu.edu.teachua.ui.tasks;

import java.util.Date;
import java.util.List;

import org.ssu.edu.teachua.db.entities.Task;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.TaskService;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.tasks.AddTaskPage;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;

public class TasksPageTest extends LoginWithAdminRunner {
	private AddTaskPage addTaskPage;

	@BeforeMethod
	void openAddTaskPage() {
		driver.navigate().refresh();
		addTaskPage = new HomePage(driver).getHeader().openAdminProfileMenu().openContentMenu().openChallengesMenu()
				.clickTasks().openAddTaskPage();
	}

	@Test
	public void testDescriptionFieldInvalid() {
		System.out.println("Result is: " + addTaskPage.areWebElementsEmpty());
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
