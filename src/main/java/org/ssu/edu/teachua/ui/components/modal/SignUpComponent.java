package org.ssu.edu.teachua.ui.components.modal;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;


public class SignUpComponent extends BaseComponent {
    @FindBy(how = How.XPATH, using = ".//input[@id='lastName']")
    private WebElement lastNameField;
    @FindBy(how = How.XPATH, using = ".//input[@id='firstName']")
    private WebElement firstNameField;
    @FindBy(how = How.XPATH, using = ".//input[@id='phone']")
    private WebElement phoneField;
    @FindBy(how = How.XPATH, using = ".//input[@id='email']")
    private WebElement emailField;
    @FindBy(how = How.XPATH, using = ".//input[@id='password']")
    private WebElement passwordField;
    @FindBy(how = How.XPATH, using = ".//input[@id='confirm']")
    private WebElement confirmPasswordField;
    @FindBy(how = How.XPATH, using = ".//div[@Class='ant-modal-content']//button[contains(@aria-label,'Close')]")
    private WebElement closeButton;
    @FindBy(how = How.XPATH, using = ".//button[@class='ant-btn ant-btn-default registration-button']")
    private WebElement signUpButton;

    public SignUpComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public SignUpComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Set to input last name field value: {lastName} ")
    public SignUpComponent enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    @Step("Set to input first name field value: {firstName} ")
    public SignUpComponent enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    @Step("Set to input phone field value: {phone} ")
    public SignUpComponent enterPhone(String phone) {
        phoneField.sendKeys(phone);
        return this;
    }

    @Step("Set to input email field value: {email} ")
    public SignUpComponent enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @Step("Set to input password field value: {password} ")
    public SignUpComponent enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Set to input confirm password field value: {confirmPassword} ")
    public SignUpComponent enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
        return this;
    }

    @Step("Click on Close button")
    public HomePage clickCloseButton() {
        closeButton.click();
        return new HomePage(driver);
    }

    @Step("Click on Sign Up button")
    public HomePage clickSignUpButton() {
        signUpButton.click();
        return new HomePage(driver);
    }

    @Step("Get the value of the last name field")
    public String getLastNameFieldValue() {
        return lastNameField.getAttribute("value");
    }

    @Step("Get the value of the first name field")
    public String getFirstNameFieldValue() {
        return firstNameField.getAttribute("value");
    }

    @Step("Get the value of the phone field")
    public String getPhoneFieldValue() {
        return phoneField.getAttribute("value");
    }

    @Step("Get the value of the email field")
    public String getEmailFieldValue() {
        return emailField.getAttribute("value");
    }

    @Step("Get the value of the password field")
    public String getPasswordFieldValue() {
        return passwordField.getAttribute("value");
    }

    @Step("Get the value of the confirm password field")
    public String getConfirmPasswordFieldValue() {
        return confirmPasswordField.getAttribute("value");
    }
}


