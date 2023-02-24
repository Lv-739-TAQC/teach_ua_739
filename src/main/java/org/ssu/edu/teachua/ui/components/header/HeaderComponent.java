package org.ssu.edu.teachua.ui.components.header;

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

    @FindBy(how = How.XPATH, using = ".//span[contains(@class, 'avatarIfNotLogin')]")
    private WebElement userIconNotLogin;

    @FindBy(how = How.XPATH, using = ".//span[contains(@class, 'avatarIfLogin')]")
    private WebElement userIconLogin;

    @FindBy(how = How.XPATH, using = ".//ul[contains(@class, 'ant-dropdown-menu')]")
    private WebElement profileMenuNode;

    public HeaderComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public HomePage clickLogo() {
        waitForElementToBeClickable(logo).click();
        return new HomePage(driver);
    }

    public ClubsPage clickClubsButton() {
        waitForElementToBeClickable(clubsButton).click();
        return new ClubsPage(driver);
    }

    public WebElement clickChallengesButton() {
        waitForElementToBeClickable(clickChallengesButton()).click();
        return null;
    }

    public NewsPage clickNewsButton() {
        waitForElementToBeClickable(newsButton).click();
        return new NewsPage(driver);
    }

    public AboutPage clickAboutButton() {
        waitForElementToBeClickable(aboutButton).click();
        return new AboutPage(driver);
    }

    public AdminMenuComponent openAdminProfileMenu() {
        waitForElementToBeClickable(userIconLogin).click();
        return new AdminMenuComponent(driver, profileMenuNode);
    }

    public UserMenuComponent openUserProfileMenu() {
        waitForElementToBeClickable(userIconLogin).click();
        return new UserMenuComponent(driver, profileMenuNode);
    }

    public GuestMenuComponent openGuestProfileMenu() {
        waitForElementToBeClickable(userIconNotLogin).click();
        return new GuestMenuComponent(driver, profileMenuNode);
    }
}
