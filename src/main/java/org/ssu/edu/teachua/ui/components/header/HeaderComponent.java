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

public class HeaderComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = ".//div[@class='logo']")
    private WebElement logo;

    @FindBy(how = How.XPATH, using = ".//span/a[@href='/dev/clubs']")
    private WebElement clubsButton;

    @FindBy(how = How.XPATH, using = ".//*[@id='challenge_ONE']")
    private WebElement challengesButton;

    @FindBy(how = How.XPATH, using = ".//div[@class='center-side']//a[@href='/dev/news']")
    private WebElement newsButton;

    @FindBy(how = How.XPATH, using = ".//div[@class='center-side']//a[@href='/dev/about']")
    private WebElement aboutButton;

    @FindBy(how = How.XPATH, using = ".//div[@class='ant-dropdown-trigger city']")
    private WebElement locationButton;

    @FindBy(how = How.XPATH, using =
            "(.//div[contains(@Class, 'ant-dropdown-show-arrow') and not(contains(@Class, 'ant-dropdown-hidden'))])//ul//li"
    )
    private List<WebElement> locationsList;

    @FindBy(how = How.XPATH, using = ".//span[contains(@class, 'avatarIfNotLogin')]")
    private WebElement userIconNotLogin;

    @FindBy(how = How.XPATH, using = ".//span[contains(@class, 'avatarIfLogin')]")
    private WebElement userIconLogin;

    @FindBy(how = How.XPATH, using = ".//ul[contains(@class, 'ant-dropdown-menu')]")
    private WebElement profileMenuNode;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'submenu-placement-rightTop')]/ul/li/span/a")
    private List<WebElement> dropdownChallengeElements;

    public HeaderComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }
    
    @Step("Click logo in header. Open the home page")
    public HomePage clickLogo() {
        waitForElementToBeClickable(logo).click();
        return new HomePage(driver);
    }
    
    @Step("Click clubs in header. Open the club page")
    public ClubsPage clickClubsButton() {
        waitForElementToBeClickable(clubsButton).click();
        return new ClubsPage(driver);
    }

    @Step("Click challenges in header. Open drop-down menu with all challenges.")
    public HeaderComponent clickChallengesButton() {
        waitForElementToBeClickable(challengesButton).click();
        return this;
    }
    
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
    
    @Step("Click news in header. Open the news page")
    public NewsPage clickNewsButton() {
        waitForElementToBeClickable(newsButton).click();
        return new NewsPage(driver);
    }
    
    @Step("Click about us in header. Open the about page")
    public AboutPage clickAboutButton() {
        waitForElementToBeClickable(aboutButton).click();
        return new AboutPage(driver);
    }
    
    @Step("Click locations in header. Open drop-down menu with all locations.")
    public HeaderComponent clickLocationButton() {
        waitForElementToBeClickable(locationButton).click();
        return this;
    }

    @Step("Get location from header")
    public String getLocation() {
        return waitForElementToAppear(locationButton).getText();
    }

    public List<String> parseList() {
        return waitForElementsToAppear(locationsList).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    
    @Step("Click '{location}' in drop-down menu.")
    public HeaderComponent chooseLocation(String location) {
        locationsList.get(parseList().indexOf(location)).click();
        return this;
    }
    
    @Step("Click menu in header. Open admin`s navigation menu component")
    public AdminMenuComponent openAdminProfileMenu() {
        waitForElementToBeClickable(userIconLogin).click();
        return new AdminMenuComponent(driver, profileMenuNode);
    }
    @Step("Click menu in header. Open user`s navigation menu component")
    public UserMenuComponent openUserProfileMenu() {
        waitForElementToBeClickable(userIconLogin).click();
        return new UserMenuComponent(driver, profileMenuNode);
    }
    
    @Step("Click menu in header. Open guest`s navigation menu component")
    public GuestMenuComponent openGuestProfileMenu() {
        waitForElementToBeClickable(userIconNotLogin).click();
        return new GuestMenuComponent(driver, profileMenuNode);
    }
    
    @Step("Get #'{id}' challenge Url")
    public String getChallengeUrl(int id) {
        WebElement challenge = getChallenges().get(id);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", challenge);
        return challenge.getAttribute("href");
    }
}

