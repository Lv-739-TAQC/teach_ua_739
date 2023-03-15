package org.ssu.edu.teachua.ui.pages.view;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;

public class ViewCenterPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@class='name-box']/span[@class='center-name']")
    private WebElement centerName;
    @FindBy(how = How.XPATH, using = "//div[@class='content']")
    protected WebElement description;
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'apply-button')]")
    protected WebElement enrollButton;
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'details-button')]")
    protected WebElement downloadButton;
    @FindBy(how = How.XPATH, using = "//a[contains(@href,'https://maps.google.com/maps')]")
    protected WebElement mapButton;

    public ViewCenterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click to enroll the center")
    public ViewCenterPage clickEnrollCenter() {
        enrollButton.click();
        return this;
    }

    @Step("Click to download a file with information about the center")
    public ViewCenterPage downloadFile() {
        downloadButton.click();
        return this;
    }

    @Step("Click to redirect on map")
    public void clickOnMap() {
        mapButton.click();
    }

   @Step("Get name of the center")
    public String getCenterName() {
        return centerName.getText();
    }

   @Step("Get description of the center")
    public String getDescription() {
        return description.getText();
    }

}
