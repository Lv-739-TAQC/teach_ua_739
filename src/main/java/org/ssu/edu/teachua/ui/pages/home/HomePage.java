package org.ssu.edu.teachua.ui.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.search.AdvancedSearchClubComponent;

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = ".//span[@title='Розширений пошук']")
    private WebElement advancedSearchIcon;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public AdvancedSearchClubComponent clickAdvancedSearchIcon() {
        waitForElementToAppear(advancedSearchIcon).click();
        WebElement advancedSearchNode = waitForElementToAppear(driver.findElement(By.xpath("//aside[contains(@class, 'club-list-sider')]")));
        return new AdvancedSearchClubComponent(driver, advancedSearchNode);
    }
}
