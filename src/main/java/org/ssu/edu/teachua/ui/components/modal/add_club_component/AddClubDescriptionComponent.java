package org.ssu.edu.teachua.ui.components.modal.add_club_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.BaseClubComponent;

public class AddClubDescriptionComponent extends BaseClubComponent {

    @FindBy(how = How.XPATH, using = "(.//span[@class='add-club-upload'])[1]")
    protected WebElement uploadLogo;

    @FindBy(how = How.XPATH, using = "(.//span[@class='add-club-upload'])[2]")
    protected WebElement uploadBackgroundPicture;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'ant-upload')]//span[@aria-label='plus']")
    protected WebElement uploadGallery;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'ant-input-textarea')]//textarea")
    protected WebElement descriptionField; //min 40 max 1500 characters

    public AddClubDescriptionComponent(WebDriver driver) {
        super(driver);
    }

    public AddClubDescriptionComponent uploadNewLogo(String logoPath) {
        this.uploadLogo.sendKeys(logoPath);
        return this;
    }

    public AddClubDescriptionComponent uploadNewBackgroundPicture(String picturePath) {
        this.uploadBackgroundPicture.sendKeys(picturePath);
        return this;
    }

    public AddClubDescriptionComponent uploadNewGallery(String galleryPath) {
        this.uploadGallery.sendKeys(galleryPath);
        return this;
    }

    public AddClubDescriptionComponent enterDescription(String description) {
        waitForElementToBeClickable(this.descriptionField).click();
        this.descriptionField.sendKeys(description);
        return this;
    }

    public void clickEndButton() {
        nextStepButton.click();
    }

    public AddClubContactsComponent clickPreviousPageButton() {
        previousPageButton.click();
        return new AddClubContactsComponent(driver);
    }
}
