package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Description extends BaseAddCenterComponent {
    public Description(WebDriver driver, WebElement node) {
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
    public Description addCenterLogo(String centerLogoPath) {
        centerLogo.sendKeys(centerLogoPath);
        return this;
    }

    // @Step("Description: add center photo")
    public Description addCenterPhoto(String photo) {
        centerPhoto.click();
        centerPhoto.clear();
        centerPhoto.sendKeys(photo);
        return this;
    }

    // @Step("Description: add center description")
    public Description addCenterDescription(String description) {
        centerDescription.click();
        centerDescription.clear();
        centerDescription.sendKeys(description);
        return this;
    }

    // @Step("Description: Press Next step button")
    public Clubs pressNextButton() {
        this.nextStepButton.click();
        return new Clubs(driver, addCenterContainer);
    }

    // @Step("Description: Press Back button")
    public Contacts pressBackButton() {
        this.backButton.click();
        return new Contacts(driver, addCenterContainer);
    }

}