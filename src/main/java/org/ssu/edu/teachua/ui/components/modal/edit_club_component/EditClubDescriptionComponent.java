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

    /**
     * This method uploading new club logo
     * @param logoPath
     * @return instance of EditClubDescriptionComponent
     */
    @Step("Edit logo {logoPath}")
    public EditClubDescriptionComponent editUploadNewLogo(String logoPath) {
        waitForElementToAppear(uploadLogo);
        this.uploadLogo.sendKeys(logoPath);
        return this;
    }

    /**
     * This method uploading new club background picture
     * @param picturePath
     * @return instance of EditClubDescriptionComponent
     */
    @Step("Edit background picture {picturePath}")
    public EditClubDescriptionComponent editUploadNewBackgroundPicture(String picturePath) {
        waitForElementToAppear(uploadBackgroundPicture);
        this.uploadBackgroundPicture.sendKeys(picturePath);
        return this;
    }

    /**
     * This method uploading new club gallery
     * @param galleryPath
     * @return instance of EditClubDescriptionComponent
     */
    @Step("Edit gallery {galleryPath}")
    public EditClubDescriptionComponent editUploadNewGallery(String galleryPath) {
        waitForElementToAppear(uploadGallery);
        this.uploadGallery.sendKeys(galleryPath);
        return this;
    }

    /**
     * This method deleting old description to club and entering new description to club
     * @param description
     * @return instance of EditClubDescriptionComponent
     */
    @Step("Edit club description {description}")
    public EditClubDescriptionComponent editEnterDescription(String description) {
        waitForElementToBeClickable(editDescriptionField);
        this.editDescriptionField.click();
        this.editDescriptionField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.editDescriptionField.sendKeys(description);
        return this;
    }

    /**
     * This method click on the 'End' button
     * @return null
     */
    @Step("Click on the 'End' button")
    public EditClubDescriptionComponent clickEditEndButton() {
        waitForElementToBeClickable(nextStepButton);
        nextStepButton.click();
        return null;
    }

    /**
     * This method click on the 'Back' button
     * @return new instance of EditClubContactsComponent
     */
    @Step("Click on the 'Back' button")
    public EditClubContactsComponent clickEditPreviousPageButton() {
        previousPageButton.click();
        return new EditClubContactsComponent(driver);
    }
}
