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

public class ProfilePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@class='menu-title']")
    private WebElement profileTitle;

    @FindBy(how = How.XPATH, using = "//div[@class='user-name']")
    private WebElement userNameField;

    @FindBy(how = How.XPATH, using = "//div[@class='user-role']")
    private WebElement userRoleField;

    @FindBy(how = How.XPATH, using = "//div[@class='user-phone-data']")
    private WebElement userPhoneField;

    @FindBy(how = How.XPATH, using = "//div[@class='user-email-data']")
    private WebElement userEmailField;

    @FindBy(how = How.XPATH, using =
            "//div[@class='ant-modal user-edit']//div[@class='ant-modal-content']"
    )
    private WebElement editProfileNode;

    @FindBy(how = How.XPATH, using = "//div[@class='edit-button']//button")
    private WebElement editProfileButton;

    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'add-button')]")
    private WebElement addButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'modal-add-club')]")
    private WebElement addClubNode;

    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id, 'tmp_key-0')]")
    private WebElement addClubButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'modal addCenter')]")
    private WebElement addCenterNode;

    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id, 'tmp_key-1')]")
    private WebElement addCenterButton;

    @FindBy(how = How.XPATH, using = "//div[@class='update-club-dropdown']")
    private List<WebElement> clubDots;

    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id, 'edit_club')]")
    private WebElement editClubButton;

    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id, 'delete_club')]")
    private WebElement deleteClubButton;

    @FindBy(how = How.XPATH, using = ".//div[@class='ant-select-selector']")
    private WebElement chooseClubCenter;

    @FindBy(how = How.XPATH, using = ".//div[@class='rc-virtual-list-holder-inner']")
    private WebElement dropdownClubCenter;

    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'ant-select-item')])[3]")
    private WebElement centerDropdownElement;

    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'ant-select-item')])[1]")
    private WebElement clubDropdownElement;

    @FindBy(how = How.XPATH, using = ".//div[@class='center-edit-button']")
    private List<WebElement> centerDots;

    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'tmp_key-0')]")
    private WebElement editCenterButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProfilePageContent() {
        List<WebElement> pageContent = waitForElementsToAppear(Arrays.asList(
                profileTitle, userNameField, userRoleField, userPhoneField, userEmailField
        ));
        return pageContent.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Step("Click on the 'Редагувати профіль' button")
    public EditProfileComponent clickEditProfileButton() {
        waitForElementToBeClickable(editProfileButton).click();
        return new EditProfileComponent(driver, editProfileNode);
    }

    @Step("Click on the 'Додати' button")
    public ProfilePage clickAddButton() {
        waitForElementToBeClickable(addButton).click();
        return this;
    }

    @Step("Click on the 'Додати гурток' button")
    public AddClubMainInfoComponent clickAddClubButton() {
        waitForElementToBeClickable(addClubButton).click();
        return new AddClubMainInfoComponent(driver);
    }

    @Step("Click on the 'Додати центр' button")
    public AddCenterMainInfoComponent clickAddCenterButton() {
        waitForElementToBeClickable(addCenterButton).click();
        return new AddCenterMainInfoComponent(driver);
    }

    @Step("Click on the three dots of specific club")
    public ProfilePage clickClubDots(int clubIndex) {
        waitForElementsToAppear(clubDots).get(clubIndex).click();
        return this;
    }

    @Step("Click on the 'Редагувати гурток' button")
    public EditClubMainInfoComponent clickEditClubButton() {
        waitForElementToBeClickable(editClubButton).click();
        return new EditClubMainInfoComponent(driver);
    }

    @Step("Click on the 'Видалити гурток' button")
    public ProfilePage clickDeleteClubButton() {
        waitForElementToBeClickable(deleteClubButton).click();
        return this;
    }

    @Step("Click on the 'Мої гуртки/центри' button")
    public ProfilePage openDropdownClubCenter() {
        waitForElementToBeClickable(chooseClubCenter).click();
        waitForElementToAppear(dropdownClubCenter);
        return this;
    }

    @Step("Choose the 'центри' section")
    public ProfilePage chooseCenters() {
        waitForElementToBeClickable(centerDropdownElement).click();
        return this;
    }

    @Step("Click on the three dots of specific centre")
    public ProfilePage clickCenterDots(int centerIndex) {
        waitForElementsToAppear(centerDots).get(centerIndex).click();
        return this;
    }

    @Step("Click on the 'Редагувати Центр' button")
    public EditCenterMainInfoComponent getEditCenterButton() {
        waitForElementToBeClickable(editCenterButton).click();
        return new EditCenterMainInfoComponent(driver);
    }

    public WebElement getEditProfileNode() {
        return editProfileNode;
    }
}
