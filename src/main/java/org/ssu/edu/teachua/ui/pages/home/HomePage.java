package org.ssu.edu.teachua.ui.pages.home;

import org.openqa.selenium.By;
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

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getLoginSuccessMsg() {
        return waitForElementToAppear(loginSuccessMsg).getText();
    }

    public AdvancedSearchClubComponent clickAdvancedSearchIcon() {
        waitForElementToAppear(advancedSearchIcon).click();
        WebElement advancedSearchNode = waitForElementToAppear(driver.findElement(By.xpath("//aside[contains(@class, 'club-list-sider')]")));
        return new AdvancedSearchClubComponent(driver, advancedSearchNode);
    }

    public String getSearchText() {
        return searchField.getText();
    }
    public void fillInSearchField(String symbols){
        searchField.clear();
        searchField.sendKeys(symbols);
    }
}