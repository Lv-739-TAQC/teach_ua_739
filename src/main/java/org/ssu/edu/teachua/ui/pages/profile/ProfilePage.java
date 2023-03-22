package org.ssu.edu.teachua.ui.pages.profile;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.modal.EditProfileComponent;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterMainInfoComponent;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubMainInfoComponent;
import org.ssu.edu.teachua.ui.components.modal.edit_center_component.EditCenterMainInfoComponent;
import org.ssu.edu.teachua.ui.components.modal.edit_club_component.EditClubMainInfoComponent;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
* This class contains elements and methods that
* represent the profile page functionality
*/
public class ProfilePage extends BasePage {

    /**
     * locator for getting title in the top of the page
     */
    @FindBy(how = How.XPATH, using = "//div[@class='menu-title']")
    private WebElement profileTitle;

    /**
     * locator represents text of 'userName' field
     */
    @FindBy(how = How.XPATH, using = "//div[@class='user-name']")
    private WebElement userNameField;

    /**
     * locator represents text of 'userRole' field
     */
    @FindBy(how = How.XPATH, using = "//div[@class='user-role']")
    private WebElement userRoleField;

    /**
     * locator represents text of 'userPhone' field
     */
    @FindBy(how = How.XPATH, using = "//div[@class='user-phone-data']")
    private WebElement userPhoneField;

    /**
     * locator represents text of 'userEmail' field
     */
    @FindBy(how = How.XPATH, using = "//div[@class='user-email-data']")
    private WebElement userEmailField;

    /**
     * locator represents a node of EditProfile component
     */
    @FindBy(how = How.XPATH, using =
            "//div[@class='ant-modal user-edit']//div[@class='ant-modal-content']"
    )
    private WebElement editProfileNode;

    /**
     * locator represents 'editProfile' button
     */
    @FindBy(how = How.XPATH, using = "//div[@class='edit-button']//button")
    private WebElement editProfileButton;

    /**
     * locator represents 'addButton' button
     */
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'add-button')]")
    private WebElement addButton;

    /**
     * locator represents 'addClub' button
     */
    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id, 'tmp_key-0')]")
    private WebElement addClubButton;

    /**
     * locator represents 'addCenter' button
     */
    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id, 'tmp_key-1')]")
    private WebElement addCenterButton;

    /**
     * locator represents a list of dots for clubs
     */
    @FindBy(how = How.XPATH, using = "//div[@class='update-club-dropdown']")
    private List<WebElement> clubDots;

    /**
     * locator represents 'editClub' button
     */
    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id, 'edit_club')]")
    private WebElement editClubButton;

    /**
     * locator represents 'deleteClub' button
     */
    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id, 'delete_club')]")
    private WebElement deleteClubButton;

    /**
     * locator represents 'chooseOption' button
     */
    @FindBy(how = How.XPATH, using = ".//div[@class='ant-select-selector']")
    private WebElement chooseClubCenter;

    /**
     * locator represents the dropdown-menu with center and club
     */
    @FindBy(how = How.XPATH, using = ".//div[@class='rc-virtual-list-holder-inner']")
    private WebElement dropdownClubCenter;

    /**
     * locator represents the dropdown-menu for center
     */
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'ant-select-item')])[3]")
    private WebElement centerDropdownElement;

    /**
     * locator represents a list of dots for centers
     */
    @FindBy(how = How.XPATH, using = ".//div[@class='center-edit-button']")
    private List<WebElement> centerDots;

    /**
     * locator represents 'editCenter' button
     */
    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'tmp_key-0')]")
    private WebElement editCenterButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Gets all static information on the profile page
     * @return List<String> with all static information
     */
    public List<String> getProfilePageContent() {
        List<WebElement> pageContent = waitForElementsToAppear(Arrays.asList(
                profileTitle, userNameField, userRoleField, userPhoneField, userEmailField
        ));
        return pageContent.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    /**
     * click the 'editProfile' button
     * @return opened EditProfileComponent
     */
    @Step("Click on the 'Редагувати профіль' button")
    public EditProfileComponent clickEditProfileButton() {
        waitForElementToBeClickable(editProfileButton).click();
        return new EditProfileComponent(driver, editProfileNode);
    }

    /**
     * click the 'add' button
     * @return ProfilePage with specific dropdown-menu
     */
    @Step("Click on the 'Додати' button")
    public ProfilePage clickAddButton() {
        waitForElementToBeClickable(addButton).click();
        return this;
    }

    /**
     * click 'addClub' button
     * @return opened AddClubMainInfoComponent
     */
    @Step("Click on the 'Додати гурток' button")
    public AddClubMainInfoComponent clickAddClubButton() {
        waitForElementToBeClickable(addClubButton).click();
        return new AddClubMainInfoComponent(driver);
    }

    /**
     * click 'addCenter' button
     * @return opened AddCenterMainInfoComponent
     */
    @Step("Click on the 'Додати центр' button")
    public AddCenterMainInfoComponent clickAddCenterButton() {
        waitForElementToBeClickable(addCenterButton).click();
        return new AddCenterMainInfoComponent(driver);
    }

    /**
     * click on the dots of a specific club
     * @return ProfilePage with specific dropdown-menu
     */
    @Step("Click on the three dots of specific club")
    public ProfilePage clickClubDots(int clubIndex) {
        waitForElementsToAppear(clubDots).get(clubIndex).click();
        return this;
    }

    /**
     * click 'editClub' button
     * @return opened EditClubMainInfoComponent
     */
    @Step("Click on the 'Редагувати гурток' button")
    public EditClubMainInfoComponent clickEditClubButton() {
        waitForElementToBeClickable(editClubButton).click();
        return new EditClubMainInfoComponent(driver);
    }

    /**
     * click 'deleteClub' button
     * @return ProfilePage and club is deleted
     */
    @Step("Click on the 'Видалити гурток' button")
    public ProfilePage clickDeleteClubButton() {
        waitForElementToBeClickable(deleteClubButton).click();
        return this;
    }

    /**
     * click 'dropdown-menu'
     * @return ProfilePage with specific dropdown-menu
     */
    @Step("Click on the 'Мої гуртки/центри' button")
    public ProfilePage openDropdownClubCenter() {
        waitForElementToBeClickable(chooseClubCenter).click();
        waitForElementToAppear(dropdownClubCenter);
        return this;
    }

    /**
     * click 'centers' button on the dropdown-menu
     * @return ProfilePage
     */
    @Step("Choose the 'центри' section")
    public ProfilePage chooseCenters() {
        waitForElementToBeClickable(centerDropdownElement).click();
        return this;
    }

    /**
     * click on the dots of a specific center
     * @return ProfilePage with specific dropdown-menu
     */
    @Step("Click on the three dots of specific centre")
    public ProfilePage clickCenterDots(int centerIndex) {
        waitForElementsToAppear(centerDots).get(centerIndex).click();
        return this;
    }

    /**
     * click 'editCenter' button
     * @return opened EditCenterMainInfoComponent
     */
    @Step("Click on the 'Редагувати Центр' button")
    public EditCenterMainInfoComponent getEditCenterButton() {
        waitForElementToBeClickable(editCenterButton).click();
        return new EditCenterMainInfoComponent(driver);
    }

    /**
     * method for getting node of editProfile component
     * @return webElement of editProfileNode
     */
    public WebElement getEditProfileNode() {
        return editProfileNode;
    }
}
