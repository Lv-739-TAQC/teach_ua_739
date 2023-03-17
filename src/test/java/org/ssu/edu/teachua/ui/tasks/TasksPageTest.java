package org.ssu.edu.teachua.ui.tasks;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.tasks.AddTaskPage;
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

}
