package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;

public class Description extends BaseComponent {
    public Description(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    @FindBy(how = How.XPATH, using = ".//span[@class='add-club-upload']")
    private WebElement centerLogo;

    @FindBy(how = How.XPATH, using = ".//*[@id='basic_urlBackground']")
    private WebElement centerPhoto;

    @FindBy(how = How.XPATH, using = ".//*[@id='basic_description']")
    private WebElement centerDescription;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'prev-btn')]")
    private WebElement backButton;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'next-btn')]")
    private WebElement nextButton;


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

    // @Step("Description: press back button")
    public Description pressBackButton() {
        backButton.click();
        return this;
    }

    // @Step("Contacts: press Next step button")
    public Description pressNextButton() {
        nextButton.click();
        return this;
    }

}