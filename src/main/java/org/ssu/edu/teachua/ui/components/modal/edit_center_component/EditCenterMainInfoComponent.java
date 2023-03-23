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
import org.ssu.edu.teachua.ui.components.modal.AddLocationComponent;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterContactsComponent;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterMainInfoComponent;

/**
 * class contains attributes and methods
 * related to editing a center name, location and
 * navigation to the next page
 */
public class EditCenterMainInfoComponent extends AddCenterMainInfoComponent {

    /**
     * locator for the center name field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_name']")
    private WebElement centerName;

    /**
     * locator for the add location button
     */
    @FindBy(how = How.XPATH, using = ".//span[@class='add-club-location']")
    private WebElement addLocationButton;

    /**
     * locator for the edit location button
     */
    @FindBy(how = How.XPATH, using = ".//span[@aria-label='edit']")
    private WebElement editLocation;

    /**
     * locator for the delete location button
     */
    @FindBy(how = How.XPATH, using = ".//span[@aria-label='delete']")
    private WebElement deleteLocation;

    /**
     * locator for the delete location pop-up
     */
    @FindBy(how = How.XPATH, using = ".//div[@class='ant-popover-message']")
    private WebElement deleteLocationPopUp;

    /**
     * locator for the next page button
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'next-btn')]")
    private WebElement nextStepButton;

    /**
     * creation constructor matching super
     */
    public EditCenterMainInfoComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * edit center name
     *
     * @param centerName - center name
     */
    @Step("Press edit center name {centerName}")
    public EditCenterMainInfoComponent editCenterName(String centerName) {
        this.centerName.click();
        this.centerName.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.centerName.sendKeys(centerName);
        return this;
    }

    /**
     * click Add location button
     *
     * @return opened {@link AddLocationComponent}
     */
    @Step("Click 'Додати локацію' button")
    public AddLocationComponent pressAddLocationButton() {
        addLocationButton.click();
        return new AddLocationComponent(driver, addLocationContainer);
    }

    /**
     * click Edit location button
     *
     * @return opened {@link AddLocationComponent}
     */
    @Step("Press edit location button")
    public AddLocationComponent pressEditLocation() {
        editLocation.click();
        return new AddLocationComponent(driver, addLocationContainer);
    }

    /**
     * click Delete location button
     *
     * @return opened {@link DeleteLocationComponent}
     */
    @Step("Press delete location button")
    public DeleteLocationComponent pressDeleteLocation() {
        deleteLocation.click();
        return new DeleteLocationComponent(driver, deleteLocationPopUp);
    }

    /**
     * click navigation to the next page button
     *
     * @return opened {@link AddCenterContactsComponent}
     */
    @Step("Press 'Наступний крок' button")
    public AddCenterContactsComponent pressNextButton() {
        this.nextStepButton.click();
        return new AddCenterContactsComponent(driver);
    }

}
