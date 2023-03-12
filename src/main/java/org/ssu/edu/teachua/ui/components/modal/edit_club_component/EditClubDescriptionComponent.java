package org.ssu.edu.teachua.ui.components.modal.edit_club_component;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubDescriptionComponent;

public class EditClubDescriptionComponent extends AddClubDescriptionComponent {

    @FindBy(how = How.XPATH, using = ".//textarea[@id='basic_descriptionText']")
    protected WebElement editDescriptionField; //min 40 max 1500 characters

    public EditClubDescriptionComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Edit logo")
    public EditClubDescriptionComponent editUploadNewLogo(String logoPath) {
        waitForElementToAppear(uploadLogo);
        this.uploadLogo.sendKeys(logoPath);
        return this;
    }

    @Step("Edit background picture")
    public EditClubDescriptionComponent editUploadNewBackgroundPicture(String picturePath) {
        waitForElementToAppear(uploadBackgroundPicture);
        this.uploadBackgroundPicture.sendKeys(picturePath);
        return this;
    }

    @Step("Edit gallery")
    public EditClubDescriptionComponent editUploadNewGallery(String galleryPath) {
        waitForElementToAppear(uploadGallery);
        this.uploadGallery.sendKeys(galleryPath);
        return this;
    }

    @Step("Edit club description")
    public EditClubDescriptionComponent editEnterDescription(String description) {
        waitForElementToBeClickable(editDescriptionField);
        this.editDescriptionField.click();
        this.editDescriptionField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.editDescriptionField.sendKeys(description);
        return this;
    }

    @Step("Click on the 'End' button")
    public EditClubDescriptionComponent clickEditEndButton() {
        waitForElementToBeClickable(nextStepButton);
        nextStepButton.click();
        return null;
    }

    @Step("Click on the 'Back' button")
    public EditClubContactsComponent clickEditPreviousPageButton() {
        previousPageButton.click();
        return new EditClubContactsComponent(driver);
    }
}
