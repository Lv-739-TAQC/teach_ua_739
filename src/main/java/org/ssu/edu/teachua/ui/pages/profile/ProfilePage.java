package org.ssu.edu.teachua.ui.pages.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.modal.AddCenterComponent;
import org.ssu.edu.teachua.ui.components.modal.AddClubComponent;
import org.ssu.edu.teachua.ui.components.modal.EditProfileComponent;

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

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'club-center-select')]")
    private WebElement chooseOption;

    @FindBy(how = How.XPATH, using =
            "//div[contains(@class, 'option')]//span[contains(text(), 'гуртки')]"
    )
    private WebElement chooseClubOption;

    @FindBy(how = How.XPATH, using =
            "//div[contains(@class, 'option')]//span[contains(text(), 'центри')]"
    )
    private WebElement chooseCenterOption;

    @FindBy(how = How.XPATH, using =
            "//div[@class='side-menu']//div[contains(@class, 'club-dropdown')]"
    )
    private List<WebElement> clubDots;

    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id, 'edit_club')]")
    private WebElement editClubButton;

    @FindBy(how = How.XPATH, using = "//li[contains(@data-menu-id, 'delete_club')]")
    private WebElement deleteClubButton;

    @FindBy(how = How.XPATH, using = "//div[@class='center-edit-button']")
    private List<WebElement> centerDots;

    @FindBy(how = How.XPATH, using =
            "//ul[contains(@class, 'update-menu')]//li[contains(@data-menu-id, 'tmp_key-0')]"
    )
    private WebElement editCenterButton;

    @FindBy(how = How.XPATH, using =
            "//ul[contains(@class, 'update-menu')]//li[contains(@data-menu-id, 'tmp_key-1')]"
    )
    private WebElement deleteCenterButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProfilePageContent() {
        List<WebElement> pageContent = waitForElementsToAppear(Arrays.asList(
                profileTitle, userNameField, userRoleField, userPhoneField, userEmailField
        ));
        return pageContent.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public EditProfileComponent clickEditProfileButton() {
        waitForElementToBeClickable(editProfileButton).click();
        return new EditProfileComponent(driver, editProfileNode);
    }

    public ProfilePage moveToAddButton() {
        actions.moveToElement(waitForElementToAppear(addButton)).perform();
        return this;
    }

    public AddClubComponent clickAddClubButton() {
        waitForElementToBeClickable(addClubButton).click();
        return new AddClubComponent(driver, addClubNode);
    }

    public AddCenterComponent clickAddCenterButton() {
        waitForElementToBeClickable(addCenterButton).click();
        return new AddCenterComponent(driver, addCenterNode);
    }

    public ProfilePage clickOption() {
        waitForElementToBeClickable(chooseOption).click();
        return this;
    }

    public ProfilePage clickClubOption() {
        waitForElementToBeClickable(chooseClubOption).click();
        return this;
    }

    public ProfilePage clickCenterOption() {
        waitForElementToBeClickable(chooseCenterOption).click();
        return this;
    }

    public ProfilePage moveToClubDots(int clubIndex) {
        actions.moveToElement(
                waitForElementsToAppear(clubDots).get(clubIndex)
        ).perform();
        return this;
    }

    public AddClubComponent clickEditClubButton() {
        waitForElementToBeClickable(editClubButton).click();
        return new AddClubComponent(driver, addClubNode);
    }

    public ProfilePage clickDeleteClubButton() {
        waitForElementToBeClickable(deleteClubButton).click();
        return this;
    }

    public ProfilePage moveToCenterDots(int centerIndex) {
        actions.moveToElement(
                waitForElementsToAppear(centerDots).get(centerIndex)
        ).perform();
        return this;
    }

    public AddCenterComponent clickEditCenterButton() {
        waitForElementToBeClickable(editCenterButton).click();
        return new AddCenterComponent(driver, addCenterNode);
    }

    public ProfilePage clickDeleteCenterButton() {
        waitForElementToBeClickable(deleteCenterButton).click();
        return this;
    }
}
