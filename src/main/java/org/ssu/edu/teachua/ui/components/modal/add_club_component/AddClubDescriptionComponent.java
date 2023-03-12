package org.ssu.edu.teachua.ui.components.modal.add_club_component;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.BaseClubComponent;

public class AddClubDescriptionComponent extends BaseClubComponent {

    @FindBy(how = How.XPATH, using = ".//input[@id = 'basic_urlLogo']")
    protected WebElement uploadLogo;

    @FindBy(how = How.XPATH, using = ".//input[@id = 'basic_urlBackground']")
    protected WebElement uploadBackgroundPicture;

    @FindBy(how = How.XPATH, using = "(.//input[@type='file'])[3]")
    protected WebElement uploadGallery;

    @FindBy(how = How.XPATH, using = ".//textarea[@id='basic_description']")
    protected WebElement descriptionField;

    @FindBy(how = How.XPATH, using = ".//span[contains(@class, 'success')]")
    protected WebElement descriptionFieldSuccess;

    @FindBy(how = How.XPATH, using = ".//div[@id='basic_description_help']")
    protected WebElement descriptionErrorMsg;

    public AddClubDescriptionComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Upload new logo")
    public AddClubDescriptionComponent uploadNewLogo(String logoPath) {
        waitForElementToAppear(uploadLogo);
        this.uploadLogo.sendKeys(logoPath);
        return this;
    }

    @Step("Upload new background picture")
    public AddClubDescriptionComponent uploadNewBackgroundPicture(String picturePath) {
        waitForElementToAppear(uploadBackgroundPicture);
        this.uploadBackgroundPicture.sendKeys(picturePath);
        return this;
    }

    @Step("Upload new gallery")
    public AddClubDescriptionComponent uploadNewGallery(String galleryPath) {
        waitForElementToAppear(uploadGallery);
        this.uploadGallery.sendKeys(galleryPath);
        return this;
    }

    @Step("Enter description to club")
    public AddClubDescriptionComponent enterDescription(String description) {
        waitForElementToBeClickable(descriptionField);
        this.descriptionField.click();
        this.descriptionField.clear();
        this.descriptionField.sendKeys(description);
        sleep(2);
        return this;
    }

    @Step("Check the description success")
    public boolean getDescriptionSuccess() {
        return waitForElementToAppear(descriptionFieldSuccess).isDisplayed();
    }

    @Step("Check the error message is appear")
    public String getDescriptionErrorMessage() {
        return waitForElementToAppear(descriptionErrorMsg).getText();
    }

    @Step("Click on the 'End' button")
    public void clickEndButton() {
        waitForElementToBeClickable(nextStepButton);
        nextStepButton.click();
    }

    @Step("Click on the 'Back' button")
    public AddClubContactsComponent clickPreviousPageButton() {
        waitForElementToBeClickable(previousPageButton);
        previousPageButton.click();
        return new AddClubContactsComponent(driver);
    }
}
