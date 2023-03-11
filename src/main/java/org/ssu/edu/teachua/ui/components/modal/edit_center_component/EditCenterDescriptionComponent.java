package org.ssu.edu.teachua.ui.components.modal.edit_center_component;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterDescriptionComponent;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;

public class EditCenterDescriptionComponent extends AddCenterDescriptionComponent {
    @FindBy(how = How.XPATH, using = ".//span[@class='add-club-upload']")
    private WebElement centerLogo;
    @FindBy(how = How.XPATH, using = "(.//span[@class='add-club-upload'])[2]")
    private WebElement centerPhoto;
    @FindBy(how = How.XPATH, using = ".//textarea[@id='basic_description']")
    private WebElement centerDescription;

    @FindBy(how = How.XPATH, using = ".//span[contains(@class, 'success')]")
    protected WebElement descriptionFieldSuccess;

    @FindBy(how = How.XPATH, using = ".//div[@id='basic_description_help']")
    protected WebElement descriptionErrorMsg;
    @FindBy(how = How.XPATH, using = ".//button[@class='finish-btn']")
    private WebElement finishButton;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'prev-btn')]")
    private WebElement backButton;

    public EditCenterDescriptionComponent(WebDriver driver) {
        super(driver);
    }

    public EditCenterDescriptionComponent editCenterLogo(String centerLogoPath) {
        centerLogo.sendKeys(centerLogoPath);
        return this;
    }

    public EditCenterDescriptionComponent editCenterPhoto(String photo) {
        centerPhoto.sendKeys(photo);
        return this;
    }

    public boolean getDescriptionSuccess() {
        return waitForElementToAppear(descriptionFieldSuccess).isDisplayed();
    }

    public String getDescriptionErrorMessage() {
        return waitForElementToAppear(descriptionErrorMsg).getText();
    }

    public EditCenterDescriptionComponent editCenterDescription(String description) {
        centerDescription.click();
        centerDescription.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        centerDescription.sendKeys(description);
        return this;
    }

    public ProfilePage pressFinishButton() {
        finishButton.click();
        return new ProfilePage(driver);
    }

    public EditCenterContactsComponent pressBackButton() {
        this.backButton.click();
        return new EditCenterContactsComponent(driver);
    }

}
