package org.ssu.edu.teachua.ui.components.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;

public class AdminMenuComponent extends UserMenuComponent implements MenuComponent {

    @FindBy(how = How.XPATH, using = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[4]")
    private WebElement contentFirstLevelButton;
    @FindBy(how = How.XPATH, using = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[5]")
    private WebElement locationFirstLevelPage;
    @FindBy(how = How.XPATH, using = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[6]")
    private WebElement groupFirstLevelButton;
    @FindBy(how = How.XPATH, using = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[7]")
    private WebElement pageFirstLevelButton;
    @FindBy(how = How.XPATH, using = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[8]")
    private WebElement profilePageFirstLevelButton;
    @FindBy(how = How.XPATH, using = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[9]")
    private WebElement logOutFirstLevelButton;
    
    @FindBy(how = How.XPATH, using = "//div[@class='ant-dropdown-menu-submenu ant-dropdown-menu-submenu-popup ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-submenu-placement-leftTop ']//ul//li[1]")
    private WebElement challengesSecondLevelButton;
    @FindBy(how = How.XPATH, using = "//div[@class='ant-dropdown-menu-submenu ant-dropdown-menu-submenu-popup ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-submenu-placement-leftTop ']//ul//li[2]")
    private WebElement сertificateSecondLevelButton;
    @FindBy(how = How.XPATH, using = "//div[@class='ant-dropdown-menu-submenu ant-dropdown-menu-submenu-popup ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-submenu-placement-leftTop ']//ul//li[3]")
    private WebElement testsSecondLevelButton;
    @FindBy(how = How.XPATH, using = "//div[@class='ant-dropdown-menu-submenu ant-dropdown-menu-submenu-popup ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-submenu-placement-leftTop ']//ul//li[4]")
    private WebElement logsSecondLevelButton;
    @FindBy(how = How.XPATH, using = "//div[@class='ant-dropdown-menu-submenu ant-dropdown-menu-submenu-popup ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-submenu-placement-leftTop ']//ul//li[5]")
    private WebElement metricsSecondLevelButton;
    @FindBy(how = How.XPATH, using = "//div[@class='ant-dropdown-menu-submenu ant-dropdown-menu-submenu-popup ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-submenu-placement-leftTop ']//ul//li[6]")
    private WebElement filesSecondLevelButton;
    @FindBy(how = How.XPATH, using = "//div[@class='ant-dropdown-menu-submenu ant-dropdown-menu-submenu-popup ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-submenu-placement-leftTop ']//ul//li[7]")
    private WebElement usesSecondLevelButton;
    												
    
    public AdminMenuComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }
    
    public ProfilePage openProfilePage() {
    	profilePageFirstLevelButton.click();
        return new ProfilePage(driver);
    }

    public HomePage logOut() {
    	logOutFirstLevelButton.click();
        return new HomePage(driver);
    }

}
