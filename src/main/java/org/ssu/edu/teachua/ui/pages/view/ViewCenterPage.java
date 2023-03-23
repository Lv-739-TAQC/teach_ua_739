package org.ssu.edu.teachua.ui.pages.view;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;

/**
 * This class represents a page for viewing a specific center's information.
 * It extends the BasePage class and contains web elements for the center name, description,
 * enroll button, download button and map button. The class provides methods to interact with
 * these web elements, such as clicking on the enroll and download buttons, and getting the
 * center name and description.
 */
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

    /**
     * Constructor for the ViewCenterPage class.
     *
     * @param driver The WebDriver object used to interact with the web page.
     */
    public ViewCenterPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks on the enroll button for the center.
     *
     * @return The current instance of the ViewCenterPage class.
     */
    @Step("Click to enroll the center")
    public ViewCenterPage clickEnrollCenter() {
        enrollButton.click();
        return this;
    }

    /**
     * Clicks on the download button for the center.
     *
     * @return The current instance of the ViewCenterPage class.
     */
    @Step("Click to download a file with information about the center")
    public ViewCenterPage downloadFile() {
        downloadButton.click();
        return this;
    }

    /**
     * Clicks on the map button to redirect to Google Maps.
     */
    @Step("Click to redirect on map")
    public void clickOnMap() {
        mapButton.click();
    }

    /**
     * Gets the name of the center.
     *
     * @return A String representation of the center name.
     */
    @Step("Get name of the center")
    public String getCenterName() {
        return centerName.getText();
    }

    /**
     * Gets the description of the center.
     *
     * @return A String representation of the center description.
     */
    @Step("Get description of the center")
    public String getDescription() {
        return description.getText();
    }

}
