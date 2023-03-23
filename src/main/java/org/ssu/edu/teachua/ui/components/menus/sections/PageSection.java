package org.ssu.edu.teachua.ui.components.menus.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;

import io.qameta.allure.Step;
import org.ssu.edu.teachua.ui.pages.news.AdminNewsPage;

/**
 * A PageSection class represents a section of a webpage that contains specific elements and actions related to that section.
 * It extends the BaseComponent class and contains a web element for the news menu item and a constructor to initialize the driver and web element node.
 */
public class PageSection extends BaseComponent {

    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id,'2-news')]")
    private WebElement newsMenuItem;

    /**
     * Constructs a PageSection object with the specified WebDriver and web element node.
     *
     * @param driver the WebDriver instance to use
     * @param node   the web element node representing the section
     */
    public PageSection(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    /**
     * Clicks the news menu item and opens the main news page.
     *
     * @return an AdminNewsPage object representing the main news page
     */
    @Step("Click news button. Open the main news page.")
    public AdminNewsPage clickNews() {
        waitForElementToBeClickable(newsMenuItem).click();
        return new AdminNewsPage(driver);
    }
}
