package org.ssu.edu.teachua.ui.pages.home;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.search.AdvancedSearchClubComponent;

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'ant-message-success')]")
    private WebElement loginSuccessMsg;
    @FindBy(how = How.XPATH, using = ".//span[@title='Розширений пошук']")
    private WebElement advancedSearchIcon;
    @FindBy(how = How.XPATH, using = "//input[@type='search']")
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = "//aside[contains(@class, 'club-list-sider')]")
    private WebElement advancedSearchNode;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String loginIsSuccess() {
        return waitForElementToAppear(loginSuccessMsg).getText();
    }

    @Step("Go to advanced search page")
    public AdvancedSearchClubComponent clickAdvancedSearchIcon() {
        waitForElementToAppear(advancedSearchIcon).click();
        return new AdvancedSearchClubComponent(driver);
    }

    public String getSearchText() {
        return searchField.getText();
    }

    @Step("Enter data into search field")
    public void fillInSearchField(String symbols) {
        searchField.clear();
        searchField.sendKeys(symbols);
    }
}