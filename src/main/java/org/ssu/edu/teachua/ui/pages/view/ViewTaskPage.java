package org.ssu.edu.teachua.ui.pages.view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;

public class ViewTaskPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@class='task-header']")
    private WebElement taskName;
    @FindBy(how = How.XPATH, using = "//div[@class='task-content']")
    private WebElement taskContent;

    public ViewTaskPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTaskName() {
        return taskName;
    }

    public WebElement getTaskContent() {
        return taskContent;
    }
}
