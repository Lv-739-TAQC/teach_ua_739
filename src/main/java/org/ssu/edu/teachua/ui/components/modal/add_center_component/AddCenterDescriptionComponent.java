package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCenterDescriptionComponent extends BaseAddCenterComponent {
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_urlLogo']")
    private WebElement centerLogo;
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_urlBackground']")
    private WebElement centerPhoto;
    @FindBy(how = How.XPATH, using = ".//textarea[@id='basic_description']")
    private WebElement centerDescription;
    @FindBy(how = How.XPATH, using = ".//span[contains(@class, 'success')]")
    protected WebElement descriptionFieldSuccess;
    @FindBy(how = How.XPATH, using = ".//div[@id='basic_description_help']")
    protected WebElement descriptionErrorMsg;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'next-btn')]")
    private WebElement nextStepButton;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'prev-btn')]")
    private WebElement backButton;

    public AddCenterDescriptionComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Add a logo {logo}")
    public AddCenterDescriptionComponent addCenterLogo(String centerLogoPath) {
        centerLogo.sendKeys(centerLogoPath);
        return this;
    }

    @Step("Add a photo {photo}")
    public AddCenterDescriptionComponent addCenterPhoto(String photo) {
        centerPhoto.sendKeys(photo);
        return this;
    }

    @Step("Fill in 'Опис' {description} field")
    public AddCenterDescriptionComponent addCenterDescription(String description) {
        centerDescription.click();
        centerDescription.clear();
        centerDescription.sendKeys(description);
        return this;
    }

    @Step("Validate description field for no error appearance")
    public boolean getDescriptionSuccess() {
        return waitForElementToAppear(descriptionFieldSuccess).isDisplayed();
    }

    @Step("Validate description field for error appearance")
    public String getDescriptionErrorMessage() {
        return waitForElementToAppear(descriptionErrorMsg).getText();
    }

    @Step("Press 'Наступний крок' button")
    public AddCenterClubsComponent pressNextButton() {
        this.nextStepButton.click();
        return new AddCenterClubsComponent(driver);
    }

    @Step("Press 'Назад' button")
    public AddCenterContactsComponent pressBackButton() {
        this.backButton.click();
        return new AddCenterContactsComponent(driver);
    }

}