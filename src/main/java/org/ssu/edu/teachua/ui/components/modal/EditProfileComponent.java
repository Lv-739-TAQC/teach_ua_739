package org.ssu.edu.teachua.ui.components.modal;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;

/**
 * This class contains elements and methods that
 * represent the editProfile window functionality
 */
public class EditProfileComponent extends BaseComponent {

    /**
     * locator represents the text of editProfile title
     */
    @FindBy(how = How.XPATH, using = ".//div[@class='edit-header']")
    private WebElement editProfileTitle;

    /**
     * locator represents 'lastName' field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='edit_lastName']")
    private WebElement editLastNameField;

    /**
     * locator represents alert message for 'lastName' field
     */
    @FindBy(how = How.XPATH, using = ".//div[@id='edit_lastName_help' and @role='alert']")
    private WebElement alertMessageLastName;

    /**
     * locator represents 'firstName' field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='edit_firstName']")
    private WebElement editFirstNameField;

    /**
     * locator represents alert message for 'firstName' field
     */
    @FindBy(how = How.XPATH, using = ".//div[@id='edit_firstName_help' and @role='alert']")
    private WebElement alertMessageFirstName;

    /**
     * locator represents 'phone' field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='edit_phone']")
    private WebElement editPhoneField;

    /**
     * locator represents 'e-mail address' field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='edit_email']")
    private WebElement getEmailAddress;

    /**
     * locator represents alert message for 'phone' field
     */
    @FindBy(how = How.XPATH, using = ".//div[@id='edit_phone_help' and @role='alert']")
    private WebElement alertMessagePhone;

    /**
     * locator represents 'uploadPhoto' field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='edit_urlLogo']")
    private WebElement uploadPhotoField;

    /**
     * locator represents 'appearedPhoto' field
     */
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'ant-upload-list-item-done')]")
    private WebElement uploadedPhotoAppeared;

    /**
     * locator represents 'changePassword' checkbox
     */
    @FindBy(how = How.XPATH, using = ".//input[@class='checkbox']")
    private WebElement changePasswordSection;

    /**
     * locator represents 'currentPassword' field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='edit_currentPassword']")
    private WebElement editCurrentPasswordField;

    /**
     * locator represents alert message for 'currentPassword' field
     */
    @FindBy(how = How.XPATH, using = ".//div[@id='edit_currentPassword_help' and @role='alert']")
    private WebElement alertMessageCurrentPassword;

    /**
     * locator represents 'newPassword' field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='edit_password']")
    private WebElement newPasswordField;

    /**
     * locator represents alert message for 'newPassword' field
     */
    @FindBy(how = How.XPATH, using = ".//div[@id='edit_password_help' and @role='alert']")
    private WebElement alertMessageNewPassword;

    /**
     * locator represents 'confirmPassword' field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='edit_confirmPassword']")
    private WebElement confirmPasswordField;

    /**
     * locator represents alert message for 'confirmPassword' field
     */
    @FindBy(how = How.XPATH, using = ".//div[@id='edit_confirmPassword_help' and @role='alert']")
    private WebElement alertMessageConfirmPassword;

    /**
     * locator represents 'saveChanges' button
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'submit-button')]")
    private WebElement saveChangesButton;

    /**
     * locator represents border color for 'currentPassword' field
     */
    @FindBy(how = How.XPATH, using = "(//span[contains(@class, 'status-error ant-input-affix-wrapper-has-feedback')])[1]")
    private WebElement borderColorCurrentPasswordField;

    /**
     * locator represents border color for 'newPassword' field
     */
    @FindBy(how = How.XPATH, using = "(//span[contains(@class, 'status-error ant-input-affix-wrapper-has-feedback')])[2]")
    private WebElement borderColorNewPasswordField;

    /**
     * locator represents border color for 'confirmPassword' field
     */
    @FindBy(how = How.XPATH, using = "(//span[contains(@class, 'status-error ant-input-affix-wrapper-has-feedback')])[3]")
    private WebElement borderColorConfirmPasswordField;

    /**
     * locator represents 'close' button
     */
    @FindBy(how = How.XPATH, using = ".//button[@class='ant-modal-close']")
    private WebElement closeButton;

    public EditProfileComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    /**
     * get text of editProfile title
     *
     * @return String with this title
     */
    public String getEditProfileTitle() {
        return waitForElementToAppear(editProfileTitle).getText();
    }

    /**
     * enter your new last name
     *
     * @param lastName - new last name
     * @return EditProfileComponent
     */
    @Step("Fill your new last name in the field 'Прізвище' : {lastName}")
    public EditProfileComponent enterNewLastName(String lastName) {
        waitForElementToBeClickable(editLastNameField).click();
        editLastNameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editLastNameField.sendKeys(lastName);
        return this;
    }

    /**
     * get text of alert message for 'lastName' field
     *
     * @return String with this alert message
     */
    public String getAlertMessageLastName() {
        sleep(2);
        return waitForElementToAppear(alertMessageLastName).getText();
    }

    /**
     * enter your new first name
     *
     * @param firstName - new first name
     * @return EditProfileComponent
     */
    @Step("Fill your new first name in the field 'Ім'я' : {firstName}")
    public EditProfileComponent enterNewFirstName(String firstName) {
        waitForElementToBeClickable(editFirstNameField).click();
        editFirstNameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editFirstNameField.sendKeys(firstName);
        return this;
    }

    /**
     * get text of alert message for 'firstName' field
     *
     * @return String with this alert message
     */
    public String getAlertMessageFirstName() {
        return waitForElementToAppear(alertMessageFirstName).getText();
    }

    /**
     * enter your new phone
     *
     * @param phone - new phone
     * @return EditProfileComponent
     */
    @Step("Fill your new phone in the field 'Телефон' : {phone}")
    public EditProfileComponent enterNewPhone(String phone) {
        waitForElementToBeClickable(editPhoneField).click();
        editPhoneField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editPhoneField.sendKeys(phone);
        return this;
    }

    /**
     * get text of alert message for 'phone' field
     *
     * @return String with this alert message
     */
    public String getAlertMessagePhone() {
        return waitForElementToAppear(alertMessagePhone).getText();
    }

    /**
     * upload your new photo
     *
     * @param photoPath - path of your photo
     * @return EditProfileComponent
     */
    @Step("Click on the 'Завантажити фото' button and upload a photo : {photoPath}")
    public EditProfileComponent uploadNewPhoto(String photoPath) {
        uploadPhotoField.sendKeys(photoPath);
        waitForElementToAppear(uploadedPhotoAppeared);
        return this;
    }

    /**
     * click 'changePassword' button
     *
     * @return EditProfileComponent with fields for entering a new password
     */
    @Step("Choose the 'Змінити пароль' section")
    public EditProfileComponent clickChangePassword() {
        waitForElementToBeClickable(changePasswordSection).click();
        return this;
    }

    /**
     * enter your current password
     *
     * @param currentPassword - current password
     * @return EditProfileComponent
     */
    @Step("Fill your current password in the field 'Введіть діючий пароль' : {currentPassword}")
    public EditProfileComponent enterCurrentPassword(String currentPassword) {
        waitForElementToBeClickable(editCurrentPasswordField).click();
        editCurrentPasswordField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editCurrentPasswordField.sendKeys(currentPassword);
        return this;
    }

    /**
     * get text of alert message for 'currentPassword' field
     *
     * @return String with this alert message
     */
    public String getAlertMessageCurrentPassword() {
        return waitForElementToAppear(alertMessageCurrentPassword).getText();
    }

    /**
     * get border color for 'currentPassword' field
     *
     * @return String - color name
     */
    public String getBorderColorForCurrentPasswordField() {
        return borderColorCurrentPasswordField.getCssValue("border-color");
    }

    /**
     * get border color for 'newPassword' field
     *
     * @return String - color name
     */
    public String getBorderColorForNewPasswordField() {
        return borderColorNewPasswordField.getCssValue("border-color");
    }

    /**
     * get border color for 'confirmPassword' field
     *
     * @return String - color name
     */
    public String getBorderColorForConfirmPasswordField() {
        return borderColorConfirmPasswordField.getCssValue("border-color");
    }

    /**
     * enter your new password
     *
     * @param password - new password
     * @return EditProfileComponent
     */
    @Step("Fill your new password in the field 'Введіть новий пароль' : {password}")
    public EditProfileComponent enterNewPassword(String password) {
        waitForElementToBeClickable(newPasswordField).click();
        newPasswordField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        newPasswordField.sendKeys(password);
        return this;
    }

    /**
     * get text of alert message for 'newPassword' field
     *
     * @return String with this alert message
     */
    public String getAlertMessageNewPassword() {
        return waitForElementToAppear(alertMessageNewPassword).getText();
    }

    /**
     * confirm your password
     *
     * @param password - entered password
     * @return EditProfileComponent
     */
    @Step("Confirm your new password in the field 'Підтвердіть новий пароль' : {password}")
    public EditProfileComponent confirmNewPassword(String password) {
        waitForElementToBeClickable(confirmPasswordField).click();
        confirmPasswordField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        confirmPasswordField.sendKeys(password);
        return this;
    }

    /**
     * get text of alert message for 'confirmPassword' field
     *
     * @return String with this alert message
     */
    public String getAlertMessageConfirmPassword() {
        sleep(2);
        return waitForElementToAppear(alertMessageConfirmPassword).getText();
    }

    /**
     * click 'saveChanges' button
     *
     * @return EditProfileComponent
     */
    @Step("Click on the 'Зберегти зміни' button")
    public EditProfileComponent clickSaveAfterEnteringInvalidData() {
        waitForElementToBeClickable(saveChangesButton).click();
        return this;
    }

    /**
     * click 'saveChanges' button
     *
     * @return opened ProfilePage
     */
    @Step("Close the 'Редагувати профіль' window")
    public ProfilePage clickCloseButton() {
        waitForElementToBeClickable(closeButton).click();
        return new ProfilePage(driver);
    }

    /**
     * method for getting locator of 'saveChangesButton'
     *
     * @return webElement of saveChangesButton
     */
    public WebElement getSaveChangesButton() {
        return saveChangesButton;
    }

    /**
     * show the first name of user
     *
     * @return text of user's first name
     */
    @Step("Get user's first name")
    public String getUserFirstName() {
        return editFirstNameField.getAttribute("value");
    }

    /**
     * show the last name of user
     *
     * @return text of user's last name
     */
    @Step("Get user's last name")
    public String getUserLastName() {
        return editLastNameField.getAttribute("value");
    }

    /**
     * show the phone number of user
     *
     * @return text of user's phone number
     */
    @Step("Get user's phone number")
    public String getUserPhone() {
        return editPhoneField.getAttribute("value");
    }

    /**
     * show the e-mail address of user
     *
     * @return text of user's e-mail address
     */
    @Step("Get user's e-mail address")
    public String getUserEmail() {
        return getEmailAddress.getAttribute("value");
    }
}
