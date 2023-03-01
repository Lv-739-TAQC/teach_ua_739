package org.ssu.edu.teachua.ui.pages.view;

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

    public ViewCenterPage clickEnrollCenter() {
        enrollButton.click();
        return this;
    }

    public ViewCenterPage downloadFile() {
        downloadButton.click();
        return this;
    }

    public void clickOnMap() {
        mapButton.click();
    }

    public String getCenterName() {
        return centerName.getText();
    }

    public String getDescription() {
        return description.getText();
    }

}
