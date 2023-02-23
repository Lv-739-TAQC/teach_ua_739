package org.ssu.edu.teachua.ui.components.modal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.ssu.edu.teachua.ui.base.BaseComponent;

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

    //    @Step("Add new location pop-up: enter location name")
    public AddLocationComponent enterLocationName(String locationName) {
        this.locationName.click();
        this.locationName.clear();
        this.locationName.sendKeys(locationName);
        return this;
    }

    //    @Step("Add new location pop-up: select location city")
    public AddLocationComponent selectLocationCity(String city) {
        Select selectFromCityList = new Select(locationCity);
        selectFromCityList.selectByVisibleText(city);
        return this;
    }

    //     @Step("Add new location pop-up: select location district")
    public AddLocationComponent selectLocationDistrict(String district) {
        Select selectFromDistrictList = new Select(locationDistrict);
        selectFromDistrictList.selectByVisibleText(district);
        return this;
    }

    //     @Step("Add new location pop-up: select subway or locality")
    public AddLocationComponent selectLocationSubway(String subwayLocality) {
        Select selectFromSubwayLocalityList = new Select(locationSubway);
        selectFromSubwayLocalityList.selectByVisibleText(subwayLocality);
        return this;
    }

    //     @Step("Add new location pop-up: enter location address")
    public AddLocationComponent enterLocationAddress(String locationAddress) {
        this.locationAddress.click();
        this.locationAddress.clear();
        this.locationAddress.sendKeys(locationAddress);
        return this;
    }

    //     @Step("Add new location pop-up: enter location geographic coordinates")
    public AddLocationComponent enterLocationGC(String locationGC) {
        this.locationGC.click();
        this.locationGC.clear();
        this.locationGC.sendKeys(locationGC);
        return this;
    }

    //     @Step("Add new location pop-up: enter location phone number")
    public AddLocationComponent enterLocationPhone(String locationPhone) {
        this.locationPhone.click();
        this.locationPhone.clear();
        this.locationPhone.sendKeys(locationPhone);
        return this;
    }

    //     @Step("Add new location pop-up: press add new location button to add it to the list of existing locations")
    public void pressAddLocationToListButton() {
        this.addLocationToListButton.click();
    }

}