package org.ssu.edu.teachua.ui.components.modal;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;


public class EditProfileComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = ".//div[@class='edit-header']")
    private WebElement editProfileTitle;

    @FindBy(how = How.XPATH, using = ".//input[@id='edit_lastName']")
    private WebElement editLastNameField;

    @FindBy(how = How.XPATH, using = ".//div[@id='edit_lastName_help' and @role='alert']")
    private WebElement alertMessageLastName;

    @FindBy(how = How.XPATH, using = ".//input[@id='edit_firstName']")
    private WebElement editFirstNameField;

    @FindBy(how = How.XPATH, using = ".//div[@id='edit_firstName_help' and @role='alert']")
    private WebElement alertMessageFirstName;

    @FindBy(how = How.XPATH, using = ".//input[@id='edit_phone']")
    private WebElement editPhoneField;

    @FindBy(how = How.XPATH, using = ".//div[@id='edit_phone_help' and @role='alert']")
    private WebElement alertMessagePhone;

    @FindBy(how = How.XPATH, using = ".//input[@id='edit_urlLogo']")
    private WebElement uploadPhotoField;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'ant-upload-list-item-done')]")
    private WebElement uploadedPhotoAppeared;

    @FindBy(how = How.XPATH, using = ".//input[@class='checkbox']")
    private WebElement changePasswordSection;

    @FindBy(how = How.XPATH, using = ".//input[@id='edit_currentPassword']")
    private WebElement editCurrentPasswordField;

    @FindBy(how = How.XPATH, using = ".//div[@id='edit_currentPassword_help' and @role='alert']")
    private WebElement alertMessageCurrentPassword;

    @FindBy(how = How.XPATH, using = ".//input[@id='edit_password']")
    private WebElement newPasswordField;

    @FindBy(how = How.XPATH, using = ".//div[@id='edit_password_help' and @role='alert']")
    private WebElement alertMessageNewPassword;

    @FindBy(how = How.XPATH, using = ".//input[@id='edit_confirmPassword']")
    private WebElement confirmPasswordField;

    @FindBy(how = How.XPATH, using = ".//div[@id='edit_confirmPassword_help' and @role='alert']")
    private WebElement alertMessageConfirmPassword;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'submit-button')]")
    private WebElement saveChangesButton;
    @FindBy(how = How.XPATH, using = "(//span[contains(@class, 'status-error ant-input-affix-wrapper-has-feedback')])[1]")
    private WebElement borderColorCurrentPasswordField;
    @FindBy(how = How.XPATH, using = "(//span[contains(@class, 'status-error ant-input-affix-wrapper-has-feedback')])[2]")
    private WebElement borderColorNewPasswordField;
    @FindBy(how = How.XPATH, using = "(//span[contains(@class, 'status-error ant-input-affix-wrapper-has-feedback')])[3]")
    private WebElement borderColorConfirmPasswordField;

    @FindBy(how = How.XPATH, using = ".//button[@class='ant-modal-close']")
    private WebElement closeButton;

    public EditProfileComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public String getEditProfileTitle() {
        return waitForElementToAppear(editProfileTitle).getText();
    }

    @Step("Fill your new last name in the field 'Прізвище'")
    public EditProfileComponent enterNewLastName(String lastName) {
        waitForElementToBeClickable(editLastNameField).click();
        editLastNameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editLastNameField.sendKeys(lastName);
        return this;
    }

    public String getAlertMessageLastName() {
    	sleep(2);
        return waitForElementToAppear(alertMessageLastName).getText();
    }

    @Step("Fill your new first name in the field 'Ім'я'")
    public EditProfileComponent enterNewFirstName(String firstName) {
        waitForElementToBeClickable(editFirstNameField).click();
        editFirstNameField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editFirstNameField.sendKeys(firstName);
        return this;
    }

    public String getAlertMessageFirstName() {
        return waitForElementToAppear(alertMessageFirstName).getText();
    }

    @Step("Fill your new phone in the field 'Телефон'")
    public EditProfileComponent enterNewPhone(String phone) {
        waitForElementToBeClickable(editPhoneField).click();
        editPhoneField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editPhoneField.sendKeys(phone);
        return this;
    }

    public String getAlertMessagePhone() {
        return waitForElementToAppear(alertMessagePhone).getText();
    }

    @Step("Click on the 'Завантажити фото' button and upload a photo")
    public EditProfileComponent uploadNewPhoto(String photoPath) {
        uploadPhotoField.sendKeys(photoPath);
        waitForElementToAppear(uploadedPhotoAppeared);
        return this;
    }

    @Step("Choose the 'Змінити пароль' section")
    public EditProfileComponent clickChangePassword() {
        waitForElementToBeClickable(changePasswordSection).click();
        return this;
    }

    @Step("Fill your current password in the field 'Введіть діючий пароль'")
    public EditProfileComponent enterCurrentPassword(String currentPassword) {
        waitForElementToBeClickable(editCurrentPasswordField).click();
        editCurrentPasswordField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        editCurrentPasswordField.sendKeys(currentPassword);
        return this;
    }

    public String getAlertMessageCurrentPassword() {
        return waitForElementToAppear(alertMessageCurrentPassword).getText();
    }

    public String getBorderColorForCurrentPasswordField() {
        return borderColorCurrentPasswordField.getCssValue("border-color");
    }

    public String getBorderColorForNewPasswordField() {
        return borderColorNewPasswordField.getCssValue("border-color");
    }

    public String getBorderColorForConfirmPasswordField() {
        return borderColorConfirmPasswordField.getCssValue("border-color");
    }

    @Step("Fill your new password in the field 'Введіть новий пароль'")
    public EditProfileComponent enterNewPassword(String password) {
        waitForElementToBeClickable(newPasswordField).click();
        newPasswordField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        newPasswordField.sendKeys(password);
        return this;
    }

    public String getAlertMessageNewPassword() {
        return waitForElementToAppear(alertMessageNewPassword).getText();
    }

    @Step("Confirm your new password in the field 'Підтвердіть новий пароль'")
    public EditProfileComponent confirmNewPassword(String password) {
        waitForElementToBeClickable(confirmPasswordField).click();
        confirmPasswordField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        confirmPasswordField.sendKeys(password);
        return this;
    }

    public String getAlertMessageConfirmPassword() {
    	sleep(2);
        return waitForElementToAppear(alertMessageConfirmPassword).getText();
    }

    @Step("Click on the 'Зберегти зміни' button")
    public EditProfileComponent clickSaveAfterEnteringInvalidData() {
        waitForElementToBeClickable(saveChangesButton).click();
        return this;
    }

    @Step("Close the 'Редагувати профіль' window")
    public ProfilePage clickCloseButton() {
        waitForElementToBeClickable(closeButton).click();
        return new ProfilePage(driver);
    }
    
    public WebElement getSaveChangesButton() {
    	return  saveChangesButton;
    }
}
