package org.ssu.edu.teachua.ui.components.menus.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;

import io.qameta.allure.Step;
import org.ssu.edu.teachua.ui.pages.news.AdminNewsPage;

public class PageSection extends BaseComponent {

    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id,'2-news')]")
    private WebElement newsMenuItem;


    public PageSection(WebDriver driver, WebElement node) {
        super(driver, node);
    }


    @Step("Click news button. Open the main news page.")
    public AdminNewsPage clickNews() {
        waitForElementToBeClickable(newsMenuItem).click();
        return new AdminNewsPage(driver);
    }
}
