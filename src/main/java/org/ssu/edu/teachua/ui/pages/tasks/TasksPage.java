package org.ssu.edu.teachua.ui.pages.tasks;

import io.qameta.allure.Step;
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

    /**
     * click challenges button and open ChallengesPage
     * @return opened ChallengesPage
     */
    @Step("Open challenges page")
    public ChallengesPage openChallengesPage() {
        waitForElementToAppear(challengesBtn).click();
        return new ChallengesPage(driver);
    }

    /**
     * click add task button and open AddTaskPage
     * @return opened AddTaskPage
     */
    @Step("Open add task page")
    public AddTaskPage openAddTaskPage() {
        waitForElementToAppear(addTaskBtn).click();
        return new AddTaskPage(driver);
    }
}
