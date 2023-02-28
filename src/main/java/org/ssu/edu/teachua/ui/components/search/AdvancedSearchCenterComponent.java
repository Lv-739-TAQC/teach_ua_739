package org.ssu.edu.teachua.ui.components.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;

public class AdvancedSearchCenterComponent extends BaseComponent {

    private final String XPATH = "//div[@class='ant-select-item ant-select-item-option' and @title='%s']";

    @FindBy(how = How.XPATH, using = ".//input[@type='radio']")
    private WebElement clubRadio;

    @FindBy(how = How.XPATH, using = ".//input[@type='radio']//following::input[1]")
    private WebElement centerRadio;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_cityName']")
    private WebElement citySelector;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_districtName']")
    private WebElement districtSelector;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_stationName']")
    private WebElement stationSelector;

    @FindBy(how = How.XPATH, using = ".//span[@class='control-sort-option'][1]")
    private WebElement sortByName;

    @FindBy(how = How.XPATH, using = ".//span[@class='control-sort-option'][2]")
    private WebElement sortByRating;

    @FindBy(how = How.XPATH, using = ".//span[@aria-label='arrow-down']")
    private WebElement sortTypeAsc;

    @FindBy(how = How.XPATH, using = ".//span[@aria-label='arrow-up']")
    private WebElement sortTypeDes;

    @FindBy(how = How.XPATH, using = ".//input[@value='LIST']")
    private WebElement showTypeList;

    @FindBy(how = How.XPATH, using = ".//input[@value='BLOCK']")
    private WebElement showTypeBlock;

    @FindBy(how = How.XPATH, using = ".//button[@class='ant-btn ant-btn-default mobile-button use-button']")
    private WebElement applyButton;

    @FindBy(how = How.XPATH, using = ".//button[@class='ant-btn ant-btn-default mobile-button clear-button']")
    private WebElement clearButton;

    public AdvancedSearchCenterComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public AdvancedSearchClubComponent chooseClub() {
        clubRadio.click();
        return new AdvancedSearchClubComponent(driver, componentRoot);
    }

    public AdvancedSearchCenterComponent chooseCenter() {
        centerRadio.click();
        return new AdvancedSearchCenterComponent(driver, componentRoot);
    }

    public AdvancedSearchCenterComponent selectCity(String city) {
        citySelector.click();
        driver.findElement(By.xpath(String.format(XPATH, city))).click();
        return this;
    }

    public boolean isCityParameterActivated() {
        return waitForElementToAppear(citySelector).isDisplayed();
    }

    public AdvancedSearchCenterComponent selectDistrict(String district) {
        districtSelector.click();
        driver.findElement(By.xpath(String.format(XPATH, district))).click();
        return this;
    }

    public boolean isDistrictParameterActivated() {
        return waitForElementToAppear(districtSelector).isDisplayed();
    }

    public AdvancedSearchCenterComponent selectStation(String station) {
        stationSelector.click();
        driver.findElement(By.xpath(String.format(XPATH, station))).click();
        return this;
    }

    public boolean isStationParameterActivated() {
        return waitForElementToAppear(stationSelector).isDisplayed();
    }

    public boolean isOnlineParameterDeactivated() {
        return driver.findElements(By.xpath(".//div[@id='basic_isOnline']")).size() == 0;
    }

    public boolean isCategoriesParameterDeactivated() {
        return driver.findElements(By.xpath(".//div[@id='basic_categoriesName']")).size() == 0;
    }

    public boolean isChildAgeParameterDeactivated() {
        return driver.findElements(By.xpath(".//span[@id='basic_age']")).size() == 0;
    }

    public void chooseSortByName() {
        sortByName.click();
    }

    public void chooseSortByRating() {
        sortByRating.click();
    }

    public void chooseSortTypeAsc() {
        sortTypeAsc.click();
    }

    public void chooseSortTypeDes() {
        sortTypeDes.click();
    }

    public void chooseShowTypeList() {
        showTypeList.click();
    }

    public void chooseShowTypeBlock() {
        showTypeBlock.click();
    }

    public void clear() {
        clearButton.click();
    }

    public void apply() {
        applyButton.click();
    }
}
