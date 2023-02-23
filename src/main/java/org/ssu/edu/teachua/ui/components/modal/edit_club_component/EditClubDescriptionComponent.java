package org.ssu.edu.teachua.ui.components.modal.edit_club_component;

import org.openqa.selenium.WebDriver;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubDescriptionComponent;

public class EditClubDescriptionComponent extends AddClubDescriptionComponent {

    public EditClubDescriptionComponent(WebDriver driver) {
        super(driver);
    }

    public EditClubDescriptionComponent editUploadNewLogo(String logoPath) {
        waitForElementToAppear(uploadLogo);
        this.uploadLogo.sendKeys(logoPath);
        return this;
    }

    public EditClubDescriptionComponent editUploadNewBackgroundPicture(String picturePath) {
        waitForElementToAppear(uploadBackgroundPicture);
        this.uploadBackgroundPicture.sendKeys(picturePath);
        return this;
    }

    public EditClubDescriptionComponent editUploadNewGallery(String galleryPath) {
        waitForElementToAppear(uploadGallery);
        this.uploadGallery.sendKeys(galleryPath);
        return this;
    }

    public EditClubDescriptionComponent editEnterDescription(String description) {
        waitForElementToBeClickable(descriptionField);
        this.descriptionField.click();
        this.descriptionField.clear();
        this.descriptionField.sendKeys(description);
        return this;
    }

    public void clickEditEndButton() {
        waitForElementToBeClickable(nextStepButton);
        nextStepButton.click();
    }

    public EditClubContactsComponent clickEditPreviousPageButton() {
        previousPageButton.click();
        return new EditClubContactsComponent(driver);
    }
}
