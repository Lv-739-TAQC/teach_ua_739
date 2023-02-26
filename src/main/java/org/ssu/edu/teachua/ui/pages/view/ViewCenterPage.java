package org.ssu.edu.teachua.ui.pages.view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;

public class ViewCenterPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'apply-button')]")
    private WebElement enrollCenterButton;
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'details-button')]")
    private WebElement downloadButton;
    @FindBy(how = How.XPATH, using = "//a[contains(@href,'https://maps.google.com/maps')]")
    private WebElement mapButton;


    public ViewCenterPage(WebDriver driver) {
        super(driver);
    }

    public ViewCenterPage clickEnrollClub() {
        enrollCenterButton.click();
        return this;
    }

    public ViewCenterPage downloadFile() {
        downloadButton.click();
        return this;
    }

    public void clickOnMap() {
        mapButton.click();
    }
}
