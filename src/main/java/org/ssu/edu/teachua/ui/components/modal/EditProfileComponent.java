package org.ssu.edu.teachua.ui.components.modal;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;

import java.util.List;
import java.util.stream.Collectors;

public class EditProfileComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = "//div[@class='edit-header']")
    private WebElement editProfileTitle;

    @FindBy(how = How.XPATH, using = "//input[@id='edit_lastName']")
    private WebElement editLastNameField;

    @FindBy(how = How.XPATH, using = "//input[@id='edit_firstName']")
    private WebElement editFirstNameField;

    @FindBy(how = How.XPATH, using = "//input[@id='edit_phone']")
    private WebElement editPhoneField;

    @FindBy(how = How.XPATH, using = "//input[@id='edit_urlLogo']")
    private WebElement uploadPhotoField;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'ant-upload-list-item-done')]")
    private WebElement uploadedPhotoAppeared;

    @FindBy(how = How.XPATH, using = "//input[@class='checkbox']")
    private WebElement changePasswordSection;

    @FindBy(how = How.XPATH, using = "//input[@id='edit_currentPassword']")
    private WebElement editCurrentPasswordField;

    @FindBy(how = How.XPATH, using = "//input[@id='edit_password']")
    private WebElement newPasswordField;

    @FindBy(how = How.XPATH, using = "//input[@id='edit_confirmPassword']")
    private WebElement confirmPasswordField;

    @FindBy(how = How.XPATH, using = "//div[@class='ant-form-item-explain-error']")
    private List<WebElement> errorMessages;

    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'submit-button')]")
    private WebElement saveChangesButton;

    @FindBy(how = How.XPATH, using = "(//button[@class='ant-modal-close'])[2]")
    private WebElement closeButton;

    public EditProfileComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public String getEditProfileTitle() {
        return waitForElementToAppear(editProfileTitle).getText();
    }

    public EditProfileComponent enterNewLastName(String lastName) {
        waitForElementToBeClickable(editLastNameField).click();
        waitForElementToBeClickable(editLastNameField).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        waitForElementToBeClickable(editLastNameField).sendKeys(lastName);
        return this;
    }

    public EditProfileComponent enterNewFirstName(String firstName) {
        waitForElementToBeClickable(editFirstNameField).click();
        waitForElementToBeClickable(editFirstNameField).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        waitForElementToBeClickable(editFirstNameField).sendKeys(firstName);
        return this;
    }

    public EditProfileComponent enterNewPhone(String phone) {
        waitForElementToBeClickable(editPhoneField).click();
        waitForElementToBeClickable(editPhoneField).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        waitForElementToBeClickable(editPhoneField).sendKeys(phone);
        return this;
    }

    public EditProfileComponent uploadNewPhoto(String photoPath) {
        uploadPhotoField.sendKeys(photoPath);
        waitForElementToAppear(uploadedPhotoAppeared);
        return this;
    }

    public EditProfileComponent clickChangePassword() {
        waitForElementToBeClickable(changePasswordSection).click();
        return this;
    }

    public EditProfileComponent enterCurrentPassword(String currentPassword) {
        waitForElementToBeClickable(editCurrentPasswordField).click();
        waitForElementToBeClickable(editCurrentPasswordField).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        waitForElementToBeClickable(editCurrentPasswordField).sendKeys(currentPassword);
        return this;
    }

    public EditProfileComponent enterNewPassword(String password) {
        waitForElementToBeClickable(newPasswordField).click();
        waitForElementToBeClickable(newPasswordField).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        waitForElementToBeClickable(newPasswordField).sendKeys(password);
        return this;
    }

    public EditProfileComponent confirmNewPassword(String password) {
        waitForElementToBeClickable(confirmPasswordField).click();
        waitForElementToBeClickable(confirmPasswordField).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        waitForElementToBeClickable(confirmPasswordField).sendKeys(password);
        return this;
    }

    public List<String> getErrorMessages() {
        return waitForElementsToAppear(errorMessages).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public ProfilePage clickSaveChangesButton() {
        waitForElementToBeClickable(saveChangesButton).click();
        return new ProfilePage(driver);
    }

    public ProfilePage clickCloseButton() {
        waitForElementToBeClickable(closeButton).click();
        return new ProfilePage(driver);
    }
}
