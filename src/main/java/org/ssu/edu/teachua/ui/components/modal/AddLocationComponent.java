package org.ssu.edu.teachua.ui.components.modal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterMainInfoComponent;

public class AddLocationComponent extends BaseComponent {
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

    public AddLocationComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public AddLocationComponent enterLocationName(String locationName) {
        this.locationName.click();
        this.locationName.clear();
        this.locationName.sendKeys(locationName);
        return this;
    }

    public AddLocationComponent selectLocationCity(String city) {
        Select selectFromCityList = new Select(locationCity);
        selectFromCityList.selectByVisibleText(city);
        return this;
    }

    public AddLocationComponent selectLocationDistrict(String district) {
        Select selectFromDistrictList = new Select(locationDistrict);
        selectFromDistrictList.selectByVisibleText(district);
        return this;
    }

    public AddLocationComponent selectLocationSubway(String subwayLocality) {
        Select selectFromSubwayLocalityList = new Select(locationSubway);
        selectFromSubwayLocalityList.selectByVisibleText(subwayLocality);
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