package org.ssu.edu.teachua.ui.components.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.menus.sections.ContentSection;

import io.qameta.allure.Step;

public class AdminMenuComponent extends UserMenuComponent {

    @FindBy(how = How.XPATH, using = ".//div[contains(@aria-controls, 'content-popup')]")
    private WebElement contentMenu;

    @FindBy(how = How.XPATH, using = "//ul[contains(@id, 'content-popup')]")
    private WebElement contentNode;

    public AdminMenuComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }
    
    @Step("Click content button. Open menu`s content section.")
    public ContentSection openContentMenu() {
        waitForElementToBeClickable(contentMenu).click();
        return new ContentSection(driver, contentNode);
    }
}

