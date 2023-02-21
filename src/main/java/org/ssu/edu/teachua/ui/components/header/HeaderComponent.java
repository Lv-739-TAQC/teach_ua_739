package org.ssu.edu.teachua.ui.components.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.menus.AdminMenuComponent;
import org.ssu.edu.teachua.ui.components.menus.GuestMenuComponent;
import org.ssu.edu.teachua.ui.components.menus.UserMenuComponent;
import org.ssu.edu.teachua.ui.pages.about.AboutPage;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.clubs.ClubsPage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.news.NewsPage;

public class HeaderComponent extends BaseComponent {
    @FindBy(how = How.XPATH, using = "//div[@class='ant-dropdown ant-dropdown-show-arrow ant-dropdown-placement-bottom ']//ul[@class]")
    private WebElement profileMenuNode;
    @FindBy(how = How.XPATH, using = "//div[@class='logo']")
    private WebElement logo;
    @FindBy(how = How.XPATH, using = "//a[@href='/dev/clubs']")
    private WebElement clubsButton;
    @FindBy(how = How.XPATH, using = "//a[@href='/dev/news']")
    private WebElement newsButton;
    @FindBy(how = How.XPATH, using = "//a[@href='/dev/about']")
    private WebElement aboutButton;
    @FindBy(how = How.XPATH, using = "//div[@class='ant-dropdown-trigger user-profile']")
    private WebElement userProfileButton;


    public HeaderComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public HomePage clickLogo() {
        logo.click();
        return new HomePage(driver);
    }

    public ClubsPage clickClubsButton() {
        clubsButton.click();
        return new ClubsPage(driver);
    }

    public NewsPage clickNewsButton() {
        newsButton.click();
        return new NewsPage(driver);
    }

    public AboutPage clickAboutButton() {
        aboutButton.click();
        return new AboutPage(driver);
    }

    public GuestMenuComponent clickGuestMenuButton() {
        userProfileButton.click();
        return new GuestMenuComponent(driver, profileMenuNode);
    }

    public UserMenuComponent clickUserMenuButton() {
        userProfileButton.click();
        return new UserMenuComponent(driver, profileMenuNode);
    }

    public AdminMenuComponent clickAdminMenuButton() {
        userProfileButton.click();
        return new AdminMenuComponent(driver, profileMenuNode);
    }
}
