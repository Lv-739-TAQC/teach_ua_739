package org.ssu.edu.teachua.ui.components.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.components.menus.AdminMenuComponent;
import org.ssu.edu.teachua.ui.components.menus.GuestMenuComponent;
import org.ssu.edu.teachua.ui.components.menus.MenuComponent;
import org.ssu.edu.teachua.ui.components.menus.UserMenuComponent;
import org.ssu.edu.teachua.ui.pages.about.AboutPage;
import org.ssu.edu.teachua.ui.pages.clubs.ClubsPage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.news.NewsPage;

public class HeaderComponent extends BaseComponent {
    @FindBy(how = How.XPATH, using = "//header")
    private WebElement profileMenuNode;
    @FindBy(how = How.XPATH, using = ".//div[@class='logo']")
    private WebElement logo;
    @FindBy(how = How.XPATH, using = ".//span/a[@href='/dev/clubs']")
    private WebElement clubsButton;
    @FindBy(how = How.XPATH, using = ".//div[@class='center-side']//a[@href='/dev/news']")
    private WebElement newsButton;
    @FindBy(how = How.XPATH, using = ".//div[@class='center-side']//a[@href='/dev/about']")
    private WebElement aboutButton;
    @FindBy(how = How.XPATH, using = ".//span[@aria-label='user']")
    private WebElement userProfileButton;
    
    @FindBy(how = How.XPATH, using = ".//span[@class='ant-avatar ant-avatar-lg ant-avatar-circle ant-avatar-image ant-avatar-icon avatarIfLogin']")
    private WebElement adminProfileButton;
    
    
    
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

    public AdminMenuComponent openAdminProfileMenu() {
    	adminProfileButton.click();
        return new AdminMenuComponent(driver, profileMenuNode);
    }

    public UserMenuComponent openUserProfileMenu() {
    	userProfileButton.click();
        return new UserMenuComponent(driver, profileMenuNode);
    }

    public GuestMenuComponent openGuestProfileMenu() {
    	userProfileButton.click();
        return new GuestMenuComponent(driver, profileMenuNode);
    }

    public MenuComponent openProfileMenu() {
        userProfileButton.click();
        String role = localStorage.getItem("role");
        if (role.equals("ROLE_ADMIN") || role.equals("ROLE_MANAGER")) {
            return new AdminMenuComponent(driver, profileMenuNode);
        } else if (role.equals("ROLE_USER")) {
            return new UserMenuComponent(driver, profileMenuNode);
        }
        return new GuestMenuComponent(driver, profileMenuNode);
    }
}
