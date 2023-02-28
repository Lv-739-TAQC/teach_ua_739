package org.ssu.edu.teachua.ui.components.modal.edit_club_component;

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
        waitForElementToBeClickable(editDescriptionField);
        this.editDescriptionField.click();
        this.editDescriptionField.clear();
        this.editDescriptionField.sendKeys(description);
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
