package org.ssu.edu.teachua.ui.pages.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.modal.AddCenterComponent;
import org.ssu.edu.teachua.ui.components.modal.AddClubComponent;
import org.ssu.edu.teachua.ui.components.modal.EditProfileComponent;

import java.util.List;

public class ProfilePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@class='menu-title']")
    private WebElement profileTitle;

    @FindBy(how = How.XPATH, using = "//div[@class='user-name']")
    private WebElement usernameField;

    @FindBy(how = How.XPATH, using = "//div[@class='user-role']")
    private WebElement userRoleField;

    @FindBy(how = How.XPATH, using = "//div[@class='user-phone-data']")
    private WebElement userPhoneField;

    @FindBy(how = How.XPATH, using = "//div[@class='user-email-data']")
    private WebElement userEmailField;

    @FindBy(how = How.XPATH, using = "//div[@class='edit-button']//button")
    private WebElement editProfileButton;

    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'add-button')]")
    private WebElement addButton;

    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id, 'tmp_key-0')]")
    private WebElement addClubButton;

    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id, 'tmp_key-1')]")
    private WebElement addCenterButton;

    @FindBy(how = How.XPATH, using = "//div[@class='update-club-dropdown']")
    private List<WebElement> clubDots;

    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id, 'edit_club')]")
    private WebElement editClubButton;

    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id, 'delete_club')]")
    private WebElement deleteClubButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getProfileTitle() {
        return waitForElementToAppear(profileTitle).getText();
    }

    public String getUsernameField() {
        return waitForElementToAppear(usernameField).getText();
    }

    public String getUserRoleField() {
        return waitForElementToAppear(userRoleField).getText();
    }

    public String getUserPhoneField() {
        return waitForElementToAppear(userPhoneField).getText();
    }

    public String getUserEmailField() {
        return waitForElementToAppear(userEmailField).getText();
    }

    public EditProfileComponent clickEditProfileButton() {
        waitForElementToBeClickable(editProfileButton).click();
        return new EditProfileComponent(driver, editProfileButton);
    }

    public ProfilePage clickAddButton() {
        waitForElementToBeClickable(addButton).click();
        return this;
    }

    public AddClubComponent clickAddClubButton() {
        waitForElementToBeClickable(addClubButton).click();
        return new AddClubComponent(driver, addClubButton);
    }

    public AddCenterComponent clickAddCenterButton() {
        waitForElementToBeClickable(addCenterButton).click();
        return new AddCenterComponent(driver, addCenterButton);
    }

    public ProfilePage clickClubDots(int clubIndex) {
        waitForElementsToAppear(clubDots).get(clubIndex).click();
        return this;
    }

    public AddClubComponent clickEditClubButton() {
        waitForElementToBeClickable(editClubButton).click();
        return new AddClubComponent(driver, editClubButton);
    }

    public ProfilePage clickDeleteClubButton() {
        waitForElementToBeClickable(deleteClubButton).click();
        return this;
    }
}
