package org.ssu.edu.teachua.ui.components.modal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterMainInfoComponent;

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
    @FindBy(how = How.XPATH, using = ".//*[@type='submit' and contains(@class, 'flooded-button')]")
    private WebElement addLocationToListButton;

    private final String xPathSelectOption = "//div[@class='ant-select-item ant-select-item-option' and @title='%s']";

    public AddLocationComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public AddLocationComponent(WebDriver driver) {
        super(driver);
    }

    public AddCenterMainInfoComponent pressCloseAddLocationWindow() {
        closeAddLocationWindowButton.click();
        return new AddCenterMainInfoComponent(driver);
    }

    public AddLocationComponent enterLocationName(String locationName) {
        this.locationName.click();
        this.locationName.clear();
        this.locationName.sendKeys(locationName);
        return this;
    }

    public AddLocationComponent selectLocationCity(String city) {
        locationCity.click();
        driver.findElement(By.xpath(String.format(xPathSelectOption, city))).click();
        return this;
    }

    public AddLocationComponent selectLocationDistrict(String district) {
        locationDistrict.click();
        driver.findElement(By.xpath(String.format(xPathSelectOption, district))).click();
        return this;
    }

    public AddLocationComponent selectLocationSubway(String subwayLocality) {
        locationSubway.click();
        driver.findElement(By.xpath(String.format(xPathSelectOption, subwayLocality))).click();
        return this;
    }

    public AddLocationComponent enterLocationAddress(String locationAddress) {
        this.locationAddress.click();
        this.locationAddress.clear();
        this.locationAddress.sendKeys(locationAddress);
        return this;
    }

    public AddLocationComponent enterLocationGC(String locationGC) {
        this.locationGC.click();
        this.locationGC.clear();
        this.locationGC.sendKeys(locationGC);
        return this;
    }

    public AddLocationComponent enterLocationPhone(String locationPhone) {
        this.locationPhone.click();
        this.locationPhone.clear();
        this.locationPhone.sendKeys(locationPhone);
        return this;
    }

    public AddCenterMainInfoComponent pressAddLocationToListButton() {
        this.addLocationToListButton.click();
        return new AddCenterMainInfoComponent(driver);
    }

}