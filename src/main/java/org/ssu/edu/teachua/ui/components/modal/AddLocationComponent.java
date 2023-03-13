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

public class AddLocationComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = "(//button[@class='ant-modal-close'])[3]")
    private WebElement closeAddLocationWindowButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='name']")
    private WebElement locationName;

    @FindBy(how = How.XPATH, using = ".//input[@id='cityName']")
    private WebElement locationCity;

    @FindBy(how = How.XPATH, using = ".//input[@id='districtName']")
    private WebElement locationDistrict;

    @FindBy(how = How.XPATH, using = ".//input[@id='stationName']")
    private WebElement locationSubway;

    @FindBy(how = How.XPATH, using = ".//*[@id='address']")
    private WebElement locationAddress;

    @FindBy(how = How.XPATH, using = ".//*[@id='coordinates']")
    private WebElement locationGC;

    @FindBy(how = How.XPATH, using = ".//*[@id='phone']")
    private WebElement locationPhone;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'add-location-button')]//button")
    private WebElement addLocationToListButton;

    @FindBy(how = How.XPATH, using =
            ".//div[contains(@class, 'add-club-locations')]//div[contains(@class, 'explain-error')]"
    )
    private List<WebElement> warningConditionAllFields;

    private final String xPathSelectOption = "//div[@class='ant-select-item ant-select-item-option' and @title='%s']";

    public AddLocationComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public AddLocationComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Close 'Додати локацію' window")
    public AddCenterMainInfoComponent pressCloseAddLocationWindow() {
        waitForElementToBeClickable(closeAddLocationWindowButton).click();
        return new AddCenterMainInfoComponent(driver);
    }

    @Step("Enter location name {locationName}")
    public AddLocationComponent enterLocationName(String locationName) {
        waitForElementToBeClickable(this.locationName).click();
        this.locationName.clear();
        this.locationName.sendKeys(locationName);
        return this;
    }

    @Step("Select a city {city} from a drop-down list")
    public AddLocationComponent selectLocationCity(String city) {
        locationCity.click();
        driver.findElement(By.xpath(String.format(xPathSelectOption, city))).click();
        return this;
    }

    @Step("Select a district {district} from a drop-down list")
    public AddLocationComponent selectLocationDistrict(String district) {
        locationDistrict.click();
        driver.findElement(By.xpath(String.format(xPathSelectOption, district))).click();
        return this;
    }

    @Step("Select a subway/locality {subwayLocality} from a drop-down list")
    public AddLocationComponent selectLocationSubway(String subwayLocality) {
        locationSubway.click();
        driver.findElement(By.xpath(String.format(xPathSelectOption, subwayLocality))).click();
        return this;
    }

    @Step("Enter location address {locationAddress}")
    public AddLocationComponent enterLocationAddress(String locationAddress) {
        waitForElementToBeClickable(this.locationAddress).click();
        this.locationAddress.clear();
        this.locationAddress.sendKeys(locationAddress);
        return this;
    }

    @Step("Enter location latitude and longitude {locationLatitudeLongitude}")
    public AddLocationComponent enterLocationGC(String locationGC) {
        waitForElementToBeClickable(this.locationGC).click();
        this.locationGC.clear();
        this.locationGC.sendKeys(locationGC);
        return this;
    }

    @Step("Enter location phone {locationPhone}")
    public AddLocationComponent enterLocationPhone(String locationPhone) {
        waitForElementToBeClickable(this.locationPhone).click();
        this.locationPhone.clear();
        this.locationPhone.sendKeys(locationPhone);
        return this;
    }

    @Step("Press 'Додати' button")
    public AddCenterMainInfoComponent pressAddLocationToListButton() {
        waitForElementToBeClickable(this.addLocationToListButton).click();
        return new AddCenterMainInfoComponent(driver);
    }

    public AddLocationComponent pressAddLocationInvalidInput() {
        waitForElementToBeClickable(this.addLocationToListButton).click();
        return this;
    }

    public List<String> getWarningConditionAllFields() {
        return waitForElementsToAppear(warningConditionAllFields)
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }
}