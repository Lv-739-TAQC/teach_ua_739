package org.ssu.edu.teachua.ui.components.modal.add_club_component;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.BaseClubComponent;

/**
 * This class contains elements and classes
 * that describe the Description page of Add Club pop-up
 */
public class AddClubDescriptionComponent extends BaseClubComponent {

    /**
     * This element is finds by xPath the "Upload new logo" input
     */
    @FindBy(how = How.XPATH, using = ".//input[@id = 'basic_urlLogo']")
    protected WebElement uploadLogo;

    /**
     * This element is finds by xPath the "Upload new background picture" input
     */
    @FindBy(how = How.XPATH, using = ".//input[@id = 'basic_urlBackground']")
    protected WebElement uploadBackgroundPicture;

    /**
     * This element is finds by xPath the "Upload gallery" input
     */
    @FindBy(how = How.XPATH, using = "(.//input[@type='file'])[3]")
    protected WebElement uploadGallery;

    /**
     * This element is finds by xPath the "Description" field
     */
    @FindBy(how = How.XPATH, using = ".//textarea[@id='basic_description']")
    protected WebElement descriptionField;

    /**
     * This element is finds by xPath the green check-circle
     * which appears next to the area-text-field with valid data entered
     */
    @FindBy(how = How.XPATH, using = ".//span[contains(@class, 'success')]")
    protected WebElement descriptionFieldSuccess;

    /**
     * This element is finds by xPath the error message
     * which appears next to the field with invalid data entered
     */
    @FindBy(how = How.XPATH, using = ".//div[@id='basic_description_help']")
    protected WebElement descriptionErrorMsg;

    public AddClubDescriptionComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * This method uploading new club logo
     * @param logoPath
     * @return instance of AddClubDescriptionComponent
     */
    @Step("Upload new logo {logoPath}")
    public AddClubDescriptionComponent uploadNewLogo(String logoPath) {
        waitForElementToAppear(uploadLogo);
        this.uploadLogo.sendKeys(logoPath);
        return this;
    }

    /**
     * This method uploading new club background picture
     * @param picturePath
     * @return instance of AddClubDescriptionComponent
     */
    @Step("Upload new background picture {picturePath}")
    public AddClubDescriptionComponent uploadNewBackgroundPicture(String picturePath) {
        waitForElementToAppear(uploadBackgroundPicture);
        this.uploadBackgroundPicture.sendKeys(picturePath);
        return this;
    }

    /**
     * This method uploading new club gallery
     * @param galleryPath
     * @return instance of AddClubDescriptionComponent
     */
    @Step("Upload new gallery {galleryPath}")
    public AddClubDescriptionComponent uploadNewGallery(String galleryPath) {
        waitForElementToAppear(uploadGallery);
        this.uploadGallery.sendKeys(galleryPath);
        return this;
    }

    /**
     * This method entering description to club
     * @param description
     * @return instance of AddClubDescriptionComponent
     */
    @Step("Enter description {description} to club")
    public AddClubDescriptionComponent enterDescription(String description) {
        waitForElementToBeClickable(descriptionField);
        this.descriptionField.click();
        this.descriptionField.clear();
        this.descriptionField.sendKeys(description);
        sleep(2);
        return this;
    }

    /**
     * This method checks the green check-circle is appeared near the text-area-field with valid data in it
     * @return element that method was applied to
     */
    @Step("Check the description success")
    public boolean getDescriptionSuccess() {
        return waitForElementToAppear(descriptionFieldSuccess).isDisplayed();
    }

    /**
     * This method checks the error message is appeared near the field with invalid data in it
     * @return element that method was applied to
     */
    @Step("Check the error message is appear")
    public String getDescriptionErrorMessage() {
        return waitForElementToAppear(descriptionErrorMsg).getText();
    }

    /**
     * This method click on the 'End' button
     */
    @Step("Click on the 'End' button")
    public void clickEndButton() {
        waitForElementToBeClickable(nextStepButton);
        nextStepButton.click();
    }

    /**
     * This method click on the 'Back' button
     * @return new instance of AddClubContactsComponent
     */
    @Step("Click on the 'Back' button")
    public AddClubContactsComponent clickPreviousPageButton() {
        waitForElementToBeClickable(previousPageButton);
        previousPageButton.click();
        return new AddClubContactsComponent(driver);
    }
}
