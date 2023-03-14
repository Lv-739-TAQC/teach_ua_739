package org.ssu.edu.teachua.ui.components.search;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.components.card.ClubCardComponent;

import java.util.List;
import java.util.stream.Collectors;

public class AdvancedSearchCenterComponent extends BaseComponent {

    private final String XPATH = "//div[@class='ant-select-item ant-select-item-option' and @title='%s']";

    @FindBy(how = How.XPATH, using = ".//input[@type='radio']")
    private WebElement clubRadio;

    @FindBy(how = How.XPATH, using = ".//input[@type='radio']//following::input[1]")
    private WebElement centerRadio;

    @FindBy(how = How.XPATH, using = ".//span[text()='Доступний онлайн']/parent::label//input")
    private WebElement remote;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_cityName']")
    private WebElement citySelector;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_districtName']")
    private WebElement districtSelector;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_stationName']")
    private WebElement stationSelector;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'за алфавітом')]")
    private WebElement sortByName;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'за рейтингом')]")
    private WebElement sortByRating;

    @FindBy(how = How.XPATH, using = "//span[contains(@aria-label, 'arrow-down')]")
    private WebElement sortTypeAsc;

    @FindBy(how = How.XPATH, using = "//span[contains(@aria-label, 'arrow-up')]")
    private WebElement sortTypeDesc;

    @FindBy(how = How.XPATH, using = "//input[@value='LIST']")
    private WebElement showTypeList;

    @FindBy(how = How.XPATH, using = "//input[@value='BLOCK']")
    private WebElement showTypeBlock;

    @FindBy(how = How.XPATH, using = "//li[@title='Previous Page']")
    private WebElement buttonPreviousPage;

    @FindBy(how = How.XPATH, using = "//li[@title='Next Page']")
    private WebElement buttonNextPage;

    @FindBy(how = How.XPATH, using = ".//button[@class='ant-btn ant-btn-default mobile-button use-button']")
    private WebElement applyButton;

    @FindBy(how = How.XPATH, using = ".//button[@class='ant-btn ant-btn-default mobile-button clear-button']")
    private WebElement clearButton;

    @FindBy(how = How.XPATH, using = "//div[text()='Розширений пошук']/parent::div")
    private List<WebElement> advancedSearchModal;

    @FindBy(how = How.XPATH, using = "//label[text()='Категорії']/ancestor::div[contains(@class,'club-list-row')]//input")
    private List<WebElement> categoriesCheckboxes;

    @FindBy(how = How.XPATH, using = ".//input[@role='spinbutton']")
    private WebElement ageField;

    @FindBy(how = How.XPATH, using = ".//span[@title='Розширений пошук']")
    private WebElement advancedSearchIcon;

    public AdvancedSearchCenterComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Click on club radio")
    public AdvancedSearchClubComponent chooseClub() {
        clubRadio.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
        return new AdvancedSearchClubComponent(driver);
    }

    @Step("Click on center radio")
    public AdvancedSearchCenterComponent chooseCenter() {
        centerRadio.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
        return new AdvancedSearchCenterComponent(driver);
    }

    @Step("Select {city} city from drop-down list")
    public AdvancedSearchCenterComponent selectCity(String city) {
        citySelector.click();
        driver.findElement(By.xpath(String.format(XPATH, city))).click();
        return this;
    }

    @Step("Check that city parameter is activated")
    public boolean isCityParameterActivated() {
        return citySelector.isEnabled();
    }

    @Step("Select {district} district from drop-down list")
    public AdvancedSearchCenterComponent selectDistrict(String district) {
        districtSelector.click();
        driver.findElement(By.xpath(String.format(XPATH, district))).click();
        return this;
    }

    @Step("Check that district parameter is activated")
    public boolean isDistrictParameterActivated() {
        return citySelector.isEnabled();
    }

    @Step("Select {station} station from drop-down list")
    public AdvancedSearchCenterComponent selectStation(String station) {
        stationSelector.click();
        driver.findElement(By.xpath(String.format(XPATH, station))).click();
        return this;
    }

    public boolean isAdvancedSearchModalDisplayed() {
        return advancedSearchModal.size() > 0;
    }

    public boolean isStationParameterActivated() {
         return clubRadio.isSelected();
    }

    @Step("Check that remote parameter is deactivated")
    public boolean isOnlineParameterDeactivated() {
        return driver.findElements(By.xpath(".//div[@id='basic_isOnline']")).size() == 0;
    }

    @Step("Check that categories parameter is deactivated")
    public boolean isCategoriesParameterDeactivated() {
        return driver.findElements(By.xpath(".//div[@id='basic_categoriesName']")).size() == 0;
    }

    @Step("Check that age parameter is deactivated")
    public boolean isChildAgeParameterDeactivated() {
        return driver.findElements(By.xpath(".//span[@id='basic_age']")).size() == 0;
    }

    @Step("Choose sort by name")
    public void chooseSortByName() {
        sortByName.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
    }

    @Step("Choose sort by rating")
    public void chooseSortByRating() {
        sortByRating.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
    }

    @Step("Choose ascending sort type")
    public void chooseSortTypeAsc() {
        sortTypeAsc.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
    }

    @Step("Choose descending sort type")
    public void chooseSortTypeDesc() {
        sortTypeDesc.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
    }

    @Step("Choose list show type")
    public void chooseShowTypeList() {
        showTypeList.click();
    }

    @Step("Choose block show type")
    public void chooseShowTypeBlock() {
        showTypeBlock.click();
    }

    @Step("Click clear button")
    public void clear() {
        clearButton.click();
    }

    @Step("Click apply button")
    public void apply() {
        applyButton.click();
    }

    public List<ClubCardComponent> getListCardsOnPage() {
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(5);
        List<WebElement> listClubCard = waitForElementsToAppear(driver.findElements(By.className("ant-card-body")));
        return listClubCard.stream().map(wb -> new ClubCardComponent(driver, wb)).collect(Collectors.toList());
    }

    @Step("Click previous page button")
    public void clickButtonPreviousPage() {
        buttonPreviousPage.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
    }

    @Step("Click next page button")
    public void clickButtonNextPage() {
        buttonNextPage.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
    }

    @Step("Check that club radio button is selected")
    public boolean isClubRadioButtonSelected() {
        return clubRadio.isSelected();
    }

    @Step("Check that remote is activated")
    public boolean isOnlineParameterActivated() {
        return remote.isEnabled();
    }

    @Step("Check that categories checkboxes is activated")
    public boolean isCategoriesCheckboxesActivated() {
        for (WebElement category : categoriesCheckboxes) {
            if (!category.isEnabled()) {
                return false;
            }
        }
        return true;
    }

    @Step("Check that age field is activated")
    public boolean isAgeFieldActivated() {
        return ageField.isEnabled();
    }
}
