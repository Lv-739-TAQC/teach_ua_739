/**
 * package contains classes
 * related to new center creation functionality
 */

package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.AddLocationComponent;

import java.util.List;

/**
 * class contains attributes and methods
 * related to adding a center name, choosing location and
 * navigation to the next page
 */
public class AddCenterMainInfoComponent extends BaseAddCenterComponent {

    /**
     * locator for the locations list field
     */
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'location-list')]")
    protected WebElement locationList;

    /**
     * locator for the locations names list
     */
    @FindBy(how = How.XPATH, using = ".//div[@id='basic_locations']//label")
    protected List<WebElement> locationsName;

    /**
     * locator for the add location container
     */
    @FindBy(how = How.XPATH, using = "//div[@class='ant-modal modal-add-club']")
    protected WebElement addLocationContainer;

    /**
     * locator for the center name field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_name']")
    private WebElement centerName;

    /**
     * locator for the add location button
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'add-location-btn')]")
    private WebElement addLocationButton;

    /**
     * locator for the next page button
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'next-btn')]")
    private WebElement nextStepButton;

    /**
     * locator for the invalid center name error message
     */
    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'explain-error')]")
    private WebElement centerNameError;

    /**
     * creation constructor matching super
     *
     * @param driver instance
     */
    public AddCenterMainInfoComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * enter center name
     *
     * @param centerName - center name
     * @return current page
     */
    @Step("Enter center name {centerName}")
    public AddCenterMainInfoComponent enterCenterName(String centerName) {
        this.centerName.click();
        this.centerName.clear();
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
        waitForElementToBeClickable(addLocationButton).click();
        return new AddLocationComponent(driver, addLocationContainer);
    }

    /**
     * choose a location for the center by entering location ordinal number in the list
     *
     * @param numberLocation - location ordinal number in the list
     * @return current page
     */
    @Step("Tick a location {locationNumber}")
    public AddCenterMainInfoComponent checkLocation(int numberLocation) {
        WebElement checkBoxLocation = driver.findElement(By.xpath(
                String.format(".//div[@id='basic_locations']//div[@class='checkbox-item'][%d]/label", numberLocation)));
        checkBoxLocation.click();
        return this;
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

    /**
     * getting invalid center name error message text
     *
     * @return error message text
     */
    public String getCenterNameError() {
        return waitForElementToAppear(centerNameError).getText();
    }

    /**
     * locate the name of just created location in the location list
     *
     * @return the name of just created location
     */
    @Step("Locate a just created location in the list")
    public String getNameNewLocation() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locationList);
        int lengthList = waitForElementsToAppear(locationsName).size();
        return waitForElementsToAppear(locationsName).get(lengthList - 1).getText();
    }

}
