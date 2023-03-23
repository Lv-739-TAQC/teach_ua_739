package org.ssu.edu.teachua.ui.pages.view;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;

/**
 * This class represents the page for viewing a task. It extends the BasePage class and provides methods to retrieve
 * the task name and content.
 */
public class ViewTaskPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@class='task-header']")
    private WebElement taskName;
    @FindBy(how = How.XPATH, using = "//div[@class='task-content']")
    private WebElement taskContent;

    /**
     * Constructs a new ViewTaskPage object.
     *
     * @param driver the WebDriver instance to use
     */
    public ViewTaskPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Returns the text of the task name.
     *
     * @return a String containing the task name
     */
    @Step("Get task name")
    public String getTaskName() {
        return waitForElementToAppear(taskName).getText();
    }

    /**
     * Returns the text of the task content.
     *
     * @return a String containing the task content
     */
    @Step("Get task content")
    public String getTaskContent() {
        return taskContent.getText();
    }
}
