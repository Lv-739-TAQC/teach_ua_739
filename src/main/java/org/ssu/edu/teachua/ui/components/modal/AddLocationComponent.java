/**
 * package contains classes
 * related to new location creation functionality
 */

package org.ssu.edu.teachua.ui.components.modal;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterMainInfoComponent;

import java.util.List;
import java.util.stream.Collectors;

/**
 * class contains attributes and methods
 * related to new location creation including location name, city, district,
 * subway or locality, address, GPS coordinates and contact phone number
 * attributes and methods dedicated for the appropriate fields filling in
 */
public class AddLocationComponent extends BaseComponent {

    /**
     * locator for closing Add location window button
     */
    @FindBy(how = How.XPATH, using = "(//button[@class='ant-modal-close'])[3]")
    private WebElement closeAddLocationWindowButton;

    /**
     * locator for the location name field
     */
    @FindBy(how = How.XPATH, using = ".//*[@id='name']")
    private WebElement locationName;

    /**
     * locator for the location city field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='cityName']")
    private WebElement locationCity;

    /**
     * locator for the location district field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='districtName']")
    private WebElement locationDistrict;

    /**
     * locator for the location subway (or locality in case no subway exists) field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='stationName']")
    private WebElement locationSubway;

    /**
     * locator for the location address field
     */
    @FindBy(how = How.XPATH, using = ".//*[@id='address']")
    private WebElement locationAddress;

    /**
     * locator for the location GPS coordinates field
     */
    @FindBy(how = How.XPATH, using = ".//*[@id='coordinates']")
    private WebElement locationGC;

    /**
     * locator for the location contact phone field
     */
    @FindBy(how = How.XPATH, using = ".//*[@id='phone']")
    private WebElement locationPhone;

    /**
     * locator for the Add location to the list button
     */
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'add-location-button')]//button")
    private WebElement addLocationToListButton;

    /**
     * locator for the message shown in case of invalid input to the fields
     * when creating new location
     */
    @FindBy(how = How.XPATH, using =
            ".//div[contains(@class, 'add-club-locations')]//div[contains(@class, 'explain-error')]"
    )
    private List<WebElement> warningConditionAllFields;

    /**
     * locator for the selection from a drop-down list
     */
    private final String xPathSelectOption = "//div[@class='ant-select-item ant-select-item-option' and @title='%s']";

    /**
     * creation constructor matching super with two parameters
     */
    public AddLocationComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    /**
     * creation constructor matching super with one parameter
     */
    public AddLocationComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * click close Add location window button
     *
     * @return opened {@link AddCenterMainInfoComponent}
     */
    @Step("Close 'Додати локацію' window")
    public AddCenterMainInfoComponent pressCloseAddLocationWindow() {
        waitForElementToBeClickable(closeAddLocationWindowButton).click();
        return new AddCenterMainInfoComponent(driver);
    }

    /**
     * enter location name
     *
     * @param locationName - location name
     */
    @Step("Enter location name {locationName}")
    public AddLocationComponent enterLocationName(String locationName) {
        waitForElementToBeClickable(this.locationName).click();
        this.locationName.clear();
        this.locationName.sendKeys(locationName);
        return this;
    }

    /**
     * choose a location city from a drop-down list
     *
     * @param city - location city
     */
    @Step("Select a city {city} from a drop-down list")
    public AddLocationComponent selectLocationCity(String city) {
        locationCity.click();
        driver.findElement(By.xpath(String.format(xPathSelectOption, city))).click();
        return this;
    }

    /**
     * choose a location district from a drop-down list
     *
     * @param district - location district
     */
    @Step("Select a district {district} from a drop-down list")
    public AddLocationComponent selectLocationDistrict(String district) {
        locationDistrict.click();
        driver.findElement(By.xpath(String.format(xPathSelectOption, district))).click();
        return this;
    }

    /**
     * choose a location subway or locality from a drop-down list
     *
     * @param subwayLocality - location subway station or locality
     */
    @Step("Select a subway/locality {subwayLocality} from a drop-down list")
    public AddLocationComponent selectLocationSubway(String subwayLocality) {
        locationSubway.click();
        driver.findElement(By.xpath(String.format(xPathSelectOption, subwayLocality))).click();
        return this;
    }

    /**
     * enter location address to the field
     *
     * @param locationAddress - location address
     */
    @Step("Enter location address {locationAddress}")
    public AddLocationComponent enterLocationAddress(String locationAddress) {
        waitForElementToBeClickable(this.locationAddress).click();
        this.locationAddress.clear();
        this.locationAddress.sendKeys(locationAddress);
        return this;
    }

    /**
     * enter location GPS coordinates
     *
     * @param locationGC - location GPS coordinates
     */
    @Step("Enter location latitude and longitude {locationLatitudeLongitude}")
    public AddLocationComponent enterLocationGC(String locationGC) {
        waitForElementToBeClickable(this.locationGC).click();
        this.locationGC.clear();
        this.locationGC.sendKeys(locationGC);
        return this;
    }

    /**
     * enter a location phone number to the field
     *
     * @param locationPhone - location contact phone number
     */
    @Step("Enter location phone {locationPhone}")
    public AddLocationComponent enterLocationPhone(String locationPhone) {
        waitForElementToBeClickable(this.locationPhone).click();
        this.locationPhone.clear();
        this.locationPhone.sendKeys(locationPhone);
        return this;
    }

    /**
     * click Add location to the locations list button
     *
     * @return opened {@link AddCenterMainInfoComponent}
     */
    @Step("Press 'Додати' button")
    public AddCenterMainInfoComponent pressAddLocationToListButton() {
        waitForElementToBeClickable(this.addLocationToListButton).click();
        return new AddCenterMainInfoComponent(driver);
    }

    /**
     * click Add location to the locations list button in case of invalid fields input
     */
    public AddLocationComponent pressAddLocationInvalidInput() {
        waitForElementToBeClickable(this.addLocationToListButton).click();
        return this;
    }

    /**
     * get all error messages to the list when have invalid field input
     *
     * @return opened AddCenterMainInfo  component
     */
    public List<String> getWarningConditionAllFields() {
        return waitForElementsToAppear(warningConditionAllFields)
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

}