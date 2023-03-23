/**
 * package contains classes
 * related to new center creation functionality
 */

package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * class contains attributes and methods
 * related to adding logo, photo and description while creating a center,
 * navigation to the next and previous pages
 */
public class AddCenterDescriptionComponent extends BaseAddCenterComponent {

    /**
     * locator for the center logo field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_urlLogo']")
    private WebElement centerLogo;

    /**
     * locator for the center photo field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_urlBackground']")
    private WebElement centerPhoto;

    /**
     * locator for the center description field
     */
    @FindBy(how = How.XPATH, using = ".//textarea[@id='basic_description']")
    private WebElement centerDescription;

    /**
     * locator for the description field successful validation sign
     */
    @FindBy(how = How.XPATH, using = ".//span[contains(@class, 'success')]")
    protected WebElement descriptionFieldSuccess;

    /**
     * locator for the description field validation failure message
     */
    @FindBy(how = How.XPATH, using = ".//div[@id='basic_description_help']")
    protected WebElement descriptionErrorMsg;

    /**
     * locator for the next page button
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'next-btn')]")
    private WebElement nextStepButton;

    /**
     * locator for the previous page button
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'prev-btn')]")
    private WebElement backButton;

    /**
     * creation constructor matching super
     */
    public AddCenterDescriptionComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * enter center logo
     *
     * @param centerLogoPath - path to center logo file location
     */
    @Step("Add a logo {logo}")
    public AddCenterDescriptionComponent addCenterLogo(String centerLogoPath) {
        centerLogo.sendKeys(centerLogoPath);
        return this;
    }

    /**
     * enter center photo
     *
     * @param photo - path to center photo file location
     */
    @Step("Add a photo {photo}")
    public AddCenterDescriptionComponent addCenterPhoto(String photo) {
        centerPhoto.sendKeys(photo);
        return this;
    }

    /**
     * enter center description
     *
     * @param description - description of the center,
     *                    should contain from 40 to 3000 symbols
     */
    @Step("Fill in 'Опис' {description} field")
    public AddCenterDescriptionComponent addCenterDescription(String description) {
        centerDescription.click();
        centerDescription.clear();
        centerDescription.sendKeys(description);
        return this;
    }

    /**
     * successful validation of the description field
     *
     * @return boolean value
     */
    @Step("Validate description field for no error appearance")
    public boolean getDescriptionSuccess() {
        return waitForElementToAppear(descriptionFieldSuccess).isDisplayed();
    }

    /**
     * error message validation of the description field
     *
     * @return error message text
     */
    @Step("Validate description field for error appearance")
    public String getDescriptionErrorMessage() {
        return waitForElementToAppear(descriptionErrorMsg).getText();
    }

    /**
     * click navigation to the next page button
     *
     * @return opened {@link AddCenterClubsComponent}
     */
    @Step("Press 'Наступний крок' button")
    public AddCenterClubsComponent pressNextButton() {
        this.nextStepButton.click();
        return new AddCenterClubsComponent(driver);
    }

    /**
     * click navigation to the previous page button
     *
     * @return opened {@link AddCenterContactsComponent}
     */
    @Step("Press 'Назад' button")
    public AddCenterContactsComponent pressBackButton() {
        this.backButton.click();
        return new AddCenterContactsComponent(driver);
    }

}