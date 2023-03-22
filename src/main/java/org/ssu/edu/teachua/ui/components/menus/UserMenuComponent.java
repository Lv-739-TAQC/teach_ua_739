package org.ssu.edu.teachua.ui.components.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.components.modal.SignUpComponent;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterMainInfoComponent;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubMainInfoComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;

import io.qameta.allure.Step;

/**
 * This class contains methods and elements that describe the menu components for 'User' role
 */
public class UserMenuComponent extends BaseComponent {

    /**
     * This element is finds by xPath the 'Add club' element in the menu dropdown list
     */
    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'add_club')]")
    private WebElement addClubButton;

    /**
     * This element is finds by xPath the 'Add centre' element in the menu dropdown list
     */
    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'add_centre')]")
    private WebElement addCentreButton;

    /**
     * This element is finds by xPath the 'Search certificates' element in the menu dropdown list
     */
    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'search_certificates')]")
    private WebElement searchCertificates;

    /**
     * This element is finds by xPath the 'Profile page' element in the menu dropdown list
     */
    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'profile')]")
    private WebElement profilePage;

    /**
     * This element is finds by xPath the 'Log out' element in the menu dropdown list
     */
    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'logout')]")
    private WebElement logOut;

    public UserMenuComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    /**
     * This method is clicking on 'Add club' element in the menu dropdown
     * which opens Add Club pop-up
     * @return new instance of {@link AddClubMainInfoComponent}
     */
    @Step("Click add club button. Open the main form for add club.")
    public AddClubMainInfoComponent openAddClubForm() {
        waitForElementToBeClickable(addClubButton).click();
        return new AddClubMainInfoComponent(driver);
    }

    /**
     * This method is clicking on 'Add center' element in the menu dropdown
     * which opens Add Center pop-up
     * @return new instance of {@link AddCenterMainInfoComponent}
     */
    @Step("Click add center button. Open the main form for add center.")
    public AddCenterMainInfoComponent openAddCentreForm() {
        waitForElementToBeClickable(addCentreButton).click();
        return new AddCenterMainInfoComponent(driver);
    }
    
    
    public void openSearchCertificates() {
        waitForElementToBeClickable(searchCertificates).click();
    }

    /**
     * This method is clicking on 'Profile page' element in the menu dropdown
     * which opens Profile page
     * @return new instance of {@link ProfilePage}
     */
    @Step("Click personal cabinet button. Open person page.")
    public ProfilePage openProfilePage() {
        waitForElementToBeClickable(profilePage).click();
        return new ProfilePage(driver);
    }

    /**
     * This method is clicking on 'Log out' element in the menu dropdown
     * which logs out user out of the system
     * @return new instance of {@link HomePage}
     */
    @Step("Click log out button. The user logs out of the system. Open home page.")
    public HomePage clickLogOut() {
        waitForElementToBeClickable(logOut).click();
        return new HomePage(driver);
    }
}

