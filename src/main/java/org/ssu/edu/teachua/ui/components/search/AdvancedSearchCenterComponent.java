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

/**
 * This class contains elements and classes
 * that describe advanced search page when chosen Center
 */
public class AdvancedSearchCenterComponent extends BaseComponent {

    /**
     * This String used for choosing elements from selectors
     */
    private final String XPATH = "//div[@class='ant-select-item ant-select-item-option' and @title='%s']";

    /**
     * WebElement for Club radio-button
     */
    @FindBy(how = How.XPATH, using = ".//input[@type='radio']")
    private WebElement clubRadio;

    /**
     * WebElement for Center radio-button
     */
    @FindBy(how = How.XPATH, using = ".//input[@type='radio']//following::input[1]")
    private WebElement centerRadio;

    /**
     * WebElement for Remote checkbox
     */
    @FindBy(how = How.XPATH, using = ".//span[text()='Доступний онлайн']/parent::label//input")
    private WebElement remote;

    /**
     * WebElement for City selector
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_cityName']")
    private WebElement citySelector;

    /**
     * WebElement for button that clear City field
     */
    @FindBy(how = How.XPATH, using = ".//*[@class='ant-select-clear']")
    private WebElement clearCity;

    /**
     * WebElement for District selector
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_districtName']")
    private WebElement districtSelector;

    /**
     * WebElement for Station selector
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_stationName']")
    private WebElement stationSelector;

    /**
     * WebElement for sort by name button
     */
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'за алфавітом')]")
    private WebElement sortByName;

    /**
     * WebElement for sort by rating button
     */
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'за рейтингом')]")
    private WebElement sortByRating;

    /**
     * WebElement for ascending sorting button
     */
    @FindBy(how = How.XPATH, using = "//span[contains(@aria-label, 'arrow-down')]")
    private WebElement sortTypeAsc;

    /**
     * WebElement for descending sorting button
     */
    @FindBy(how = How.XPATH, using = "//span[contains(@aria-label, 'arrow-up')]")
    private WebElement sortTypeDesc;

    /**
     * WebElement for list show type button
     */
    @FindBy(how = How.XPATH, using = "//input[@value='LIST']")
    private WebElement showTypeList;

    /**
     * WebElement for block show type button
     */
    @FindBy(how = How.XPATH, using = "//input[@value='BLOCK']")
    private WebElement showTypeBlock;

    /**
     * WebElement for previous page button
     */
    @FindBy(how = How.XPATH, using = "//li[@title='Previous Page']")
    private WebElement buttonPreviousPage;

    /**
     * WebElement for next page button
     */
    @FindBy(how = How.XPATH, using = "//li[@title='Next Page']")
    private WebElement buttonNextPage;

    /**
     * WebElement for apply button
     */
    @FindBy(how = How.XPATH, using = ".//button[@class='ant-btn ant-btn-default mobile-button use-button']")
    private WebElement applyButton;

    /**
     * WebElement for clear button
     */
    @FindBy(how = How.XPATH, using = ".//button[@class='ant-btn ant-btn-default mobile-button clear-button']")
    private WebElement clearButton;

    /**
     * WebElement for advanced search modal
     */
    @FindBy(how = How.XPATH, using = "//div[text()='Розширений пошук']/parent::div")
    private List<WebElement> advancedSearchModal;

    /**
     * WebElement for categories checkboxes
     */
    @FindBy(how = How.XPATH, using = "//label[text()='Категорії']/ancestor::div[contains(@class,'club-list-row')]//input")
    private List<WebElement> categoriesCheckboxes;

    /**
     * WebElement for ageField
     */
    @FindBy(how = How.XPATH, using = ".//input[@role='spinbutton']")
    private WebElement ageField;

    /**
     * WebElement for advanced search button
     */
    @FindBy(how = How.XPATH, using = ".//span[@title='Розширений пошук']")
    private WebElement advancedSearchIcon;

    /**
     * Constructs a new AdvancedSearchCenterComponent with the specified WebDriver.
     * @param driver the WebDriver object used to interact with the web browser
     */
    public AdvancedSearchCenterComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * Choosing Club radio-button
     * @return AdvancedSearchClubComponent with driver
     */
    @Step("Click on club radio")
    public AdvancedSearchClubComponent chooseClub() {
        clubRadio.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
        return new AdvancedSearchClubComponent(driver);
    }

    /**
     * Choosing Center radio-button
     * @return AdvancedSearchCenterComponent with driver
     */
    @Step("Click on center radio")
    public AdvancedSearchCenterComponent chooseCenter() {
        centerRadio.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
        return new AdvancedSearchCenterComponent(driver);
    }

    /**
     * Choosing city from drop-down list
     * @param city
     * @return advanced search component with selected city
     */
    @Step("Select {city} city from drop-down list")
    public AdvancedSearchCenterComponent selectCity(String city) {
        citySelector.click();
        driver.findElement(By.xpath(String.format(XPATH, city))).click();
        return this;
    }

    /**
     * Clear city field
     * @return advanced search component without selected city
     */
    @Step("Clear city selector in advanced search panel")
    public AdvancedSearchCenterComponent clearCity() {
        actions.moveToElement(citySelector).build().perform();
        waitForElementToAppear(clearCity).click();
        return new AdvancedSearchClubComponent(driver);
    }

    /**
     * Checks that city selector is activated
     * @return true if city selector is activated
     */
    @Step("Check that city parameter is activated")
    public boolean isCityParameterActivated() {
        return citySelector.isEnabled();
    }

    /**
     * Choosing district from drop-down list
     * @param district
     * @return advanced search component with selected district
     */
    @Step("Select {district} district from drop-down list")
    public AdvancedSearchCenterComponent selectDistrict(String district) {
        districtSelector.click();
        driver.findElement(By.xpath(String.format(XPATH, district))).click();
        return this;
    }

    /**
     * Checks that district selector is activated
     * @return true if district selector is activated
     */
    @Step("Check that district parameter is activated")
    public boolean isDistrictParameterActivated() {
        return citySelector.isEnabled();
    }

    /**
     * Choosing station from drop-down list
     * @param station
     * @return advanced search component with selected station
     */
    @Step("Select {station} station from drop-down list")
    public AdvancedSearchCenterComponent selectStation(String station) {
        stationSelector.click();
        driver.findElement(By.xpath(String.format(XPATH, station))).click();
        return this;
    }

    /**
     * Checks that station selector is activated
     * @return true if station selector is activated
     */
    public boolean isStationParameterActivated() {
        return clubRadio.isSelected();
    }

    /**
     * Checks that advanced search is displayed on the page
     * @return true if advanced search is displayed on the page
     */
    public boolean isAdvancedSearchModalDisplayed() {
        return advancedSearchModal.size() > 0;
    }

    /**
     * Checks that remote parameter is deactivated
     * @return true if remote parameter is deactivated
     */
    @Step("Check that remote parameter is deactivated")
    public boolean isOnlineParameterDeactivated() {
        return driver.findElements(By.xpath(".//div[@id='basic_isOnline']")).size() == 0;
    }

    /**
     * Checks that categories parameters is deactivated
     * @return true if all categories parameters is deactivated
     */
    @Step("Check that categories parameter is deactivated")
    public boolean isCategoriesParameterDeactivated() {
        return driver.findElements(By.xpath(".//div[@id='basic_categoriesName']")).size() == 0;
    }

    /**
     * Checks that age field is deactivated
     * @return true if age field is deactivated
     */
    @Step("Check that age parameter is deactivated")
    public boolean isChildAgeParameterDeactivated() {
        return driver.findElements(By.xpath(".//span[@id='basic_age']")).size() == 0;
    }

    /**
     * Click on button for sorting by name
     */
    @Step("Choose sort by name")
    public void chooseSortByName() {
        sortByName.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
    }

    /**
     * Click on button for sorting by rating
     */
    @Step("Choose sort by rating")
    public AdvancedSearchCenterComponent chooseSortByRating() {
        sortByRating.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
        return new AdvancedSearchCenterComponent(driver);
    }

    /**
     * Click on button for ascending sort type
     */
    @Step("Choose ascending sort type")
    public AdvancedSearchCenterComponent chooseSortTypeAsc() {
        sortTypeAsc.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
        return new AdvancedSearchCenterComponent(driver);
    }

    /**
     * Click on button for descending sort type
     */
    @Step("Choose descending sort type")
    public AdvancedSearchCenterComponent chooseSortTypeDesc() {
        sortTypeDesc.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
        return new AdvancedSearchCenterComponent(driver);
    }

    /**
     * Click on button for list show type
     */
    @Step("Choose list show type")
    public void chooseShowTypeList() {
        showTypeList.click();
    }

    /**
     * Click on button for block show type
     */
    @Step("Choose block show type")
    public void chooseShowTypeBlock() {
        showTypeBlock.click();
    }

    /**
     * Click on clear button
     */
    @Step("Click clear button")
    public void clear() {
        clearButton.click();
    }

    /**
     * Click on apply button
     */
    @Step("Click apply button")
    public void apply() {
        applyButton.click();
    }

    /**
     * @return List of all cards on page
     */
    public List<ClubCardComponent> getListCardsOnPage() {
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(5);
        List<WebElement> listClubCard = waitForElementsToAppear(driver.findElements(By.className("ant-card-body")));
        return listClubCard.stream().map(wb -> new ClubCardComponent(driver, wb)).collect(Collectors.toList());
    }

    /**
     * @return int number of cards on page
     */
    @Step("Count cards in the page")
    public int getCountCards() {
        return getListCardsOnPage().size();
    }

    /**
     * Method that collect all cards with their rating and put them in array
     * @return array of ratings and club cards
     */
    @Step("Get names and ratings of club cards")
    public String[][] getNamesAndRatingsOfCards() {
        int clubIndex = 0;
        String[][] cardNamesAndRatings = new String[getCountCards()][2];
        for (ClubCardComponent card : getListCardsOnPage()) {
            cardNamesAndRatings[clubIndex][0] = card.getClubTitle();
            cardNamesAndRatings[clubIndex][1] = String.valueOf((double) card.getRating());
            clubIndex++;
        }
        return cardNamesAndRatings;
    }

    /**
     * Click on previous page button
     */
    @Step("Click previous page button")
    public void clickButtonPreviousPage() {
        buttonPreviousPage.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
    }

    /**
     * Click on next page button
     */
    @Step("Click next page button")
    public void clickButtonNextPage() {
        buttonNextPage.click();
        //Club`s or Center`s forms (cards)  are loaded from BD and displayed on the page within 2-3 seconds. Some bug.
        sleep(3);
    }

    /**
     * Checks that club radio-button is selected
     * @return true if club radio-button selected
     */
    @Step("Check that club radio button is selected")
    public boolean isClubRadioButtonSelected() {
        return clubRadio.isSelected();
    }

    /**
     * Checks that remote checkbox is activated
     * @return true if remote checkbox activated
     */
    @Step("Check that remote is activated")
    public boolean isOnlineParameterActivated() {
        return remote.isEnabled();
    }

    /**
     * Checks that categories checkboxes is activated
     * @return true if one of categories checkboxes is activated
     */
    @Step("Check that categories checkboxes is activated")
    public boolean isCategoriesCheckboxesActivated() {
        for (WebElement category : categoriesCheckboxes) {
            if (!category.isEnabled()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks that age field is activated
     * @return true if age field activated
     */
    @Step("Check that age field is activated")
    public boolean isAgeFieldActivated() {
        return ageField.isEnabled();
    }
}
