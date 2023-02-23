package org.ssu.edu.teachua.ui.pages.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.pages.challenges.ChallengesPage;

public class TasksPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[contains(@class, 'back-btn')]/button")
    private WebElement challengesBtn;

    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'add-btn')]")
    private WebElement addTaskBtn;

    public TasksPage(WebDriver driver) {
        super(driver);
    }

    public ChallengesPage openChallengesPage() {
        waitForElementToAppear(challengesBtn).click();
        return new ChallengesPage(driver);
    }

    public AddTaskPage openAddTaskPage() {
        waitForElementToAppear(addTaskBtn).click();
        return new AddTaskPage(driver);
    }
}
