package org.ssu.edu.teachua.ui.components.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterMainInfoComponent;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubMainInfoComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;

import io.qameta.allure.Step;

public class UserMenuComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'add_club')]")
    private WebElement addClubButton;

    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'add_centre')]")
    private WebElement addCentreButton;

    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'search_certificates')]")
    private WebElement searchCertificates;

    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'profile')]")
    private WebElement profilePage;

    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'logout')]")
    private WebElement logOut;

    public UserMenuComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }
    
    @Step("Click add club button. Open the main form for add club.")
    public AddClubMainInfoComponent openAddClubForm() {
        waitForElementToBeClickable(addClubButton).click();
        return new AddClubMainInfoComponent(driver);
    }
    
    @Step("Click add center button. Open the main form for add center.")
    public AddCenterMainInfoComponent openAddCentreForm() {
        waitForElementToBeClickable(addCentreButton).click();
        return new AddCenterMainInfoComponent(driver);
    }
    
    
    public void openSearchCertificates() {
        waitForElementToBeClickable(searchCertificates).click();
    }
    
    @Step("Click personal cabinet button. Open person page.")
    public ProfilePage openProfilePage() {
        waitForElementToBeClickable(profilePage).click();
        return new ProfilePage(driver);
    }

    @Step("Click log out button. The user logs out of the system. Open home page.")
    public HomePage clickLogOut() {
        waitForElementToBeClickable(logOut).click();
        return new HomePage(driver);
    }
}

