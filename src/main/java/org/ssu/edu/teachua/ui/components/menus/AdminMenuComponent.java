package org.ssu.edu.teachua.ui.components.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.menus.sections.ContentSection;

import io.qameta.allure.Step;
import org.ssu.edu.teachua.ui.components.menus.sections.PageSection;

public class AdminMenuComponent extends UserMenuComponent {

    @FindBy(how = How.XPATH, using = ".//div[contains(@aria-controls, 'content-popup')]")
    private WebElement contentMenu;

    @FindBy(how = How.XPATH, using = "//ul[contains(@id, 'content-popup')]")
    private WebElement contentNode;
    @FindBy(how = How.XPATH, using = ".//div[contains(@aria-controls, 'website-popup')]")
    private WebElement pageMenu;

    @FindBy(how = How.XPATH, using = "//ul[contains(@id, 'website-popup')]")
    private WebElement pageNode;

    public AdminMenuComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    @Step("Click content button. Open menu`s content section.")
    public ContentSection openContentMenu() {
        waitForElementToBeClickable(contentMenu).click();
        return new ContentSection(driver, contentNode);
    }

    @Step("Click page button. Open menu`s page section.")
    public PageSection openPageMenu() {
        waitForElementToBeClickable(pageMenu).click();
        return new PageSection(driver, pageNode);
    }
}

