/**
 * package contains classes
 * related to edit center functionality
 */

package org.ssu.edu.teachua.ui.components.modal.edit_center_component;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterDescriptionComponent;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;

/**
 * class contains attributes and methods
 * related to editing logo, photo and description field,
 * navigation to the next and previous pages
 */
public class EditCenterDescriptionComponent extends AddCenterDescriptionComponent {

    /**
     * locator for the center logo field
     */
    @FindBy(how = How.XPATH, using = ".//span[@class='add-club-upload']")
    private WebElement centerLogo;

    /**
     * locator for the center photo field
     */
    @FindBy(how = How.XPATH, using = "(.//span[@class='add-club-upload'])[2]")
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
     * locator for the finish button
     */
    @FindBy(how = How.XPATH, using = ".//button[@class='finish-btn']")
    private WebElement finishButton;

    /**
     * locator for the previous page button
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'prev-btn')]")
    private WebElement backButton;

    /**
     * creation constructor matching super
     */
    public EditCenterDescriptionComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * edit center logo
     *
     * @param centerLogoPath - path to center logo file location
     */
    @Step("Edit a logo {logo}")
    public EditCenterDescriptionComponent editCenterLogo(String centerLogoPath) {
        centerLogo.sendKeys(centerLogoPath);
        return this;
    }

    /**
     * edit center photo
     *
     * @param photo - path to center photo file location
     */
    @Step("Edit a photo {photo}")
    public EditCenterDescriptionComponent editCenterPhoto(String photo) {
        centerPhoto.sendKeys(photo);
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
     * enter center description
     *
     * @param description - description of the center,
     *                    should contain from 40 to 3000 symbols
     */
    @Step("Edit 'Опис' {description} field")
    public EditCenterDescriptionComponent editCenterDescription(String description) {
        centerDescription.click();
        centerDescription.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        centerDescription.sendKeys(description);
        return this;
    }

    /**
     * click finish center editing button
     *
     * @return opened {@link ProfilePage}
     */
    @Step("Press 'Завершити' button")
    public ProfilePage pressFinishButton() {
        finishButton.click();
        return new ProfilePage(driver);
    }

    /**
     * click navigation to the previous page button
     *
     * @return opened {@link EditCenterContactsComponent}
     */
    @Step("Press 'Назад' button")
    public EditCenterContactsComponent pressBackButton() {
        this.backButton.click();
        return new EditCenterContactsComponent(driver);
    }

}
