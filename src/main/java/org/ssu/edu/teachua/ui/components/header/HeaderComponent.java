package org.ssu.edu.teachua.ui.components.header;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.components.menus.AdminMenuComponent;
import org.ssu.edu.teachua.ui.components.menus.GuestMenuComponent;
import org.ssu.edu.teachua.ui.components.menus.UserMenuComponent;
import org.ssu.edu.teachua.ui.pages.about.AboutPage;
import org.ssu.edu.teachua.ui.pages.clubs.ClubsPage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.news.NewsPage;
import org.ssu.edu.teachua.ui.pages.view.ViewChallengePage;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class contains elements and classes
 * that describe the Header components of the speak-ukrainian.org.ua
 */
public class HeaderComponent extends BaseComponent {

    /**
     * This element is finds by xPath the logo of site in the header
     */
    @FindBy(how = How.XPATH, using = ".//div[@class='logo']")
    private WebElement logo;

    /**
     * This element is finds by xPath the 'Clubs' button in the header
     * which open the {@link ClubsPage} after clicking
     */
    @FindBy(how = How.XPATH, using = ".//span/a[@href='/dev/clubs']")
    private WebElement clubsButton;

    /**
     * This element is finds by xPath the 'Challenges' button in the header
     * which open the dropdown with challenges
     */
    @FindBy(how = How.XPATH, using = ".//*[@id='challenge_ONE']")
    private WebElement challengesButton;

    /**
     * This element is finds by xPath the 'News' button in the header
     * which open the {@link NewsPage} after clicking
     */
    @FindBy(how = How.XPATH, using = ".//div[@class='center-side']//a[@href='/dev/news']")
    private WebElement newsButton;

    /**
     * This element is finds by xPath the 'About us' button in the header
     * which open the {@link AboutPage} after clicking
     */
    @FindBy(how = How.XPATH, using = ".//div[@class='center-side']//a[@href='/dev/about']")
    private WebElement aboutButton;

    /**
     * This element is finds by xPath the 'Location' button in the header
     * which open the dropdown with locations
     */
    @FindBy(how = How.XPATH, using = ".//div[@class='ant-dropdown-trigger city']")
    private WebElement locationButton;

    /**
     * This list of elements is finds by xPath the location dropdown elements
     */
    @FindBy(how = How.XPATH, using =
            "(.//div[contains(@Class, 'ant-dropdown-show-arrow') and not(contains(@Class, 'ant-dropdown-hidden'))])//ul//li"
    )
    private List<WebElement> locationsList;

    /**
     * This element is finds by xPath the user-icon for user not login
     */
    @FindBy(how = How.XPATH, using = ".//span[contains(@class, 'avatarIfNotLogin')]")
    private WebElement userIconNotLogin;

    /**
     * This element is finds by xPath the user-icon for user login as one of roles
     */
    @FindBy(how = How.XPATH, using = ".//span[contains(@class, 'avatarIfLogin')]")
    private WebElement userIconLogin;

    /**
     * This element is finds by xPath the profile menu node
     */
    @FindBy(how = How.XPATH, using = ".//ul[contains(@class, 'ant-dropdown-menu')]")
    private WebElement profileMenuNode;

    /**
     * This list of elements is finds by xPath the challenge dropdown elements
     */
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'submenu-placement-rightTop')]/ul/li/span/a")
    private List<WebElement> dropdownChallengeElements;

    public HeaderComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    /**
     * This method is clicking on the logo in the header
     * @return {@link HomePage}
     */
    @Step("Click logo in header. Open the home page")
    public HomePage clickLogo() {
        waitForElementToBeClickable(logo).click();
        return new HomePage(driver);
    }

    /**
     * This method is clicking on the 'Clubs' button in the header
     * @return {@link ClubsPage}
     */
    @Step("Click clubs in header. Open the club page")
    public ClubsPage clickClubsButton() {
        waitForElementToBeClickable(clubsButton).click();
        return new ClubsPage(driver);
    }

    /**
     * This method is clicking on the 'Challenges' button in the header
     * @return the instance of HeaderComponent
     */
    @Step("Click challenges in header. Open drop-down menu with all challenges.")
    public HeaderComponent clickChallengesButton() {
        waitForElementToBeClickable(challengesButton).click();
        return this;
    }

    /**
     * This method is clicking on the one of challenge dropdown elements
     * @param id index of challenge in the list
     * @return {@link ViewChallengePage}
     */
    @Step("Click #'{id}' challenge in drop-down menu. Open challenge page.")
    public ViewChallengePage clickChallengeButton(int id) {
        WebElement challenge = getChallenges().get(id);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", challenge);
        challenge.click();
        return new ViewChallengePage(driver);
    }

    @Step("Click challenges in header. Get list web-element challenges")
    public List<WebElement> getChallenges() {
        By challenges = By.xpath("//span/a[contains(@href, 'dev/challenges')]");
        return driver.findElements(challenges);
    }

    /**
     * This method is clicking on the 'News' button in the header
     * @return {@link NewsPage}
     */
    @Step("Click news in header. Open the news page")
    public NewsPage clickNewsButton() {
        waitForElementToBeClickable(newsButton).click();
        return new NewsPage(driver);
    }

    /**
     * This method is clicking on the 'About us' button in the header
     * @return {@link AboutPage}
     */
    @Step("Click about us in header. Open the about page")
    public AboutPage clickAboutButton() {
        waitForElementToBeClickable(aboutButton).click();
        return new AboutPage(driver);
    }

    /**
     * This method is clicking on the 'Location' button in the header
     * @return the instance of HeaderComponent
     */
    @Step("Click locations in header. Open drop-down menu with all locations.")
    public HeaderComponent clickLocationButton() {
        waitForElementToBeClickable(locationButton).click();
        return this;
    }

    /**
     * This method is extracting current location from header
     * @return name of the current location
     */
    @Step("Get location from header")
    public String getLocation() {
        return waitForElementToAppear(locationButton).getText();
    }

    /**
     * This method is creating list with names of locations from dropdown
     * @return list with names of locations
     */
    public List<String> parseList() {
        return waitForElementsToAppear(locationsList).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    /**
     * This method is clicking on the location in the location list
     * @param location name of location
     * @return the instance of HeaderComponent
     */
    @Step("Click '{location}' in drop-down menu.")
    public HeaderComponent chooseLocation(String location) {
        locationsList.get(parseList().indexOf(location)).click();
        return this;
    }

    /**
     * This method clicking on the 'Menu' button in the header
     * which open the admins navigation menu
     * @return {@link AdminMenuComponent}
     */
    @Step("Click menu in header. Open admin`s navigation menu component")
    public AdminMenuComponent openAdminProfileMenu() {
        waitForElementToBeClickable(userIconLogin).click();
        return new AdminMenuComponent(driver, profileMenuNode);
    }

    /**
     * This method clicking on the 'Menu' button in the header
     * which open the users navigation menu
     * @return {@link UserMenuComponent}
     */
    @Step("Click menu in header. Open user`s navigation menu component")
    public UserMenuComponent openUserProfileMenu() {
        waitForElementToBeClickable(userIconLogin).click();
        return new UserMenuComponent(driver, profileMenuNode);
    }

    /**
     * This method clicking on the 'Menu' button in the header
     * which open the guests navigation menu
     * @return {@link GuestMenuComponent}
     */
    @Step("Click menu in header. Open guest`s navigation menu component")
    public GuestMenuComponent openGuestProfileMenu() {
        waitForElementToBeClickable(userIconNotLogin).click();
        return new GuestMenuComponent(driver, profileMenuNode);
    }

    /**
     * This method is extracting challenge url from challenges list
     * @param id index of challenge in challenges list
     * @return challenge url
     */
    @Step("Get #'{id}' challenge Url")
    public String getChallengeUrl(int id) {
        WebElement challenge = getChallenges().get(id);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", challenge);
        return challenge.getAttribute("href");
    }
}

