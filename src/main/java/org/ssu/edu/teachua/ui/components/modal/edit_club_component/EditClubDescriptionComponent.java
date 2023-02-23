package org.ssu.edu.teachua.ui.components.modal.edit_club_component;

import org.openqa.selenium.WebDriver;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubDescriptionComponent;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;

public class EditClubDescriptionComponent extends AddClubDescriptionComponent {

    public EditClubDescriptionComponent(WebDriver driver) {
        super(driver);
    }

    public EditClubDescriptionComponent editUploadNewLogo(String logoPath) {
        this.uploadLogo.sendKeys(logoPath);
        return this;
    }

    public EditClubDescriptionComponent editUploadNewBackgroundPicture(String picturePath) {
        this.uploadBackgroundPicture.sendKeys(picturePath);
        return this;
    }

    public EditClubDescriptionComponent editUploadNewGallery(String galleryPath) {
        this.uploadGallery.sendKeys(galleryPath);
        return this;
    }

    public EditClubDescriptionComponent editEnterDescription(String description) {
        this.descriptionField.click();
        this.descriptionField.clear();
        this.descriptionField.sendKeys(description);
        return this;
    }

    public BasePage clickNextStepButton() {
        nextStepButton.click();
        return new ProfilePage(driver);
    }

    public EditClubContactsComponent clickPreviousPageButton() {
        previousPageButton.click();
        return new EditClubContactsComponent(driver);
    }
}
