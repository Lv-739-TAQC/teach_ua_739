package org.ssu.edu.teachua.ui.components.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.menus.sections.ContentSection;

import io.qameta.allure.Step;

/**
 * This class contains methods and elements that describe the menu components for 'Admin' role
 */
public class AdminMenuComponent extends UserMenuComponent {

    /**
     * This element finds by xPath the 'Content' element in the menu dropdown list
     */
    @FindBy(how = How.XPATH, using = ".//div[contains(@aria-controls, 'content-popup')]")
    private WebElement contentMenu;

    /**
     * This element finds by xPath the Content sub-menu in the menu dropdown list
     */
    @FindBy(how = How.XPATH, using = "//ul[contains(@id, 'content-popup')]")
    private WebElement contentNode;

    public AdminMenuComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    /**
     * This method is clicking on 'Content' element in the menu dropdown list
     * which open menus content section
     * @return new instance of {@link ContentSection}
     */
    @Step("Click content button. Open menu`s content section.")
    public ContentSection openContentMenu() {
        waitForElementToBeClickable(contentMenu).click();
        return new ContentSection(driver, contentNode);
    }
}

