package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCenterDescriptionComponent extends BaseAddCenterComponent {
    public AddCenterDescriptionComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    @FindBy(how = How.XPATH, using = ".//span[@class='add-club-upload']")
    private WebElement centerLogo;
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_urlBackground']")
    private WebElement centerPhoto;
    @FindBy(how = How.XPATH, using = ".//textarea[@id='basic_description']")
    private WebElement centerDescription;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'next-btn')]")
    private WebElement nextStepButton;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'prev-btn')]")
    private WebElement backButton;


    // @Step("Description: add center logo")
    public AddCenterDescriptionComponent addCenterLogo(String centerLogoPath) {
        centerLogo.sendKeys(centerLogoPath);
        return this;
    }

    // @Step("Description: add center photo")
    public AddCenterDescriptionComponent addCenterPhoto(String photo) {
        centerPhoto.click();
        centerPhoto.clear();
        centerPhoto.sendKeys(photo);
        return this;
    }

    // @Step("Description: add center description")
    public AddCenterDescriptionComponent addCenterDescription(String description) {
        centerDescription.click();
        centerDescription.clear();
        centerDescription.sendKeys(description);
        return this;
    }

    // @Step("Description: Press Next step button")
    public AddCenterClubsComponent pressNextButton() {
        this.nextStepButton.click();
        return new AddCenterClubsComponent(driver, addCenterContainer);
    }

    // @Step("Description: Press Back button")
    public AddCenterContactsComponent pressBackButton() {
        this.backButton.click();
        return new AddCenterContactsComponent(driver, addCenterContainer);
    }

}