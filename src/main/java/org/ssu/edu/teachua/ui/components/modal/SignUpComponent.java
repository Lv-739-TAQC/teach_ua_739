package org.ssu.edu.teachua.ui.components.modal;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;

/**
 * Class SignUpComponent contains webElements and methods which represents
 * the functionality to sign up the system
 */
public class SignUpComponent extends BaseComponent {
    /**
     * WebElement representing the last name input field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='lastName']")
    private WebElement lastNameField;
    /**
     * WebElement representing the name input field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='firstName']")
    private WebElement firstNameField;
    /**
     * WebElement representing the phone input field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='phone']")
    private WebElement phoneField;
    /**
     * WebElement representing the email input field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='email']")
    private WebElement emailField;
    /**
     * WebElement representing the password input field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='password']")
    private WebElement passwordField;
    /**
     * WebElement representing the confirmation password input field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='confirm']")
    private WebElement confirmPasswordField;
    /**
     * WebElement representing close button
     */
    @FindBy(how = How.XPATH, using = ".//div[@Class='ant-modal-content']//button[contains(@aria-label,'Close')]")
    private WebElement closeButton;
    /**
     * WebElement representing sign up button
     */
    @FindBy(how = How.XPATH, using = ".//button[@class='ant-btn ant-btn-default registration-button']")
    private WebElement signUpButton;
    /**
     * Constructs a new SignUpComponent with the specified WebDriver and node.
     * @param driver the WebDriver object used to interact with the web browser
     * @param node the WebElement representing the signup component in the web page
     */
    public SignUpComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public SignUpComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * Enters the data into the last name input field
     * @param lastName
     * @return modal window "Sign up" with entered last name
     */
    @Step("Set to input last name field value: {lastName} ")
    public SignUpComponent enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    /**
     * Enters the data into the first name input field
     * @param firstName
     * @return modal window "Sign up" with entered first name
     */
    @Step("Set to input first name field value: {firstName} ")
    public SignUpComponent enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    /**
     * Enters the data into the phone input field
     * @param phone
     * @return modal window "Sign up" with entered phone
     */
    @Step("Set to input phone field value: {phone} ")
    public SignUpComponent enterPhone(String phone) {
        phoneField.sendKeys(phone);
        return this;
    }

    /**
     * Enters the data into the email input field
     * @param email
     * @return modal window "Sign up" with entered email
     */
    @Step("Set to input email field value: {email} ")
    public SignUpComponent enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    /**
     * Enters the data into the password input field
     * @param password
     * @return modal window "Sign up" with entered password
     */
    @Step("Set to input password field value: {password} ")
    public SignUpComponent enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    /**
     * Enters the data into the confirmation password input field
     * @param confirmPassword
     * @return modal window "Sign up" with entered confirmation password
     */
    @Step("Set to input confirm password field value: {confirmPassword} ")
    public SignUpComponent enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
        return this;
    }

    /**
     * Click on "Close" button and close modal window "Sign up"
     * @return HomePage
     */
    @Step("Click on Close button")
    public HomePage clickCloseButton() {
        closeButton.click();
        return new HomePage(driver);
    }

    /**
     * Click on "Sign up" button and sign up the system
     * @return HomePage
     */
    @Step("Click on Sign up button")
    public HomePage clickSignUpButton() {
        signUpButton.click();
        return new HomePage(driver);
    }

    /**
     * Get the value of the last name input field
     * @return a String containing the value of the last name input field
     */
    @Step("Get the value of the last name field")
    public String getLastNameFieldValue() {
        return lastNameField.getAttribute("value");
    }

    /**
     * Get the value of the first name input field
     * @return a String containing the value of the first name input field
     */
    @Step("Get the value of the first name field")
    public String getFirstNameFieldValue() {
        return firstNameField.getAttribute("value");
    }

    /**
     * Get the value of the phone input field
     * @return a String containing the value of the phone input field
     */
    @Step("Get the value of the phone field")
    public String getPhoneFieldValue() {
        return phoneField.getAttribute("value");
    }

    /**
     * Get the value of the email input field
     * @return a String containing the value of the email input field
     */
    @Step("Get the value of the email field")
    public String getEmailFieldValue() {
        return emailField.getAttribute("value");
    }

    /**
     * Get the value of the password input field
     * @return a String containing the value of the password input field
     */
    @Step("Get the value of the password field")
    public String getPasswordFieldValue() {
        return passwordField.getAttribute("value");
    }

    /**
     * Get the value of the confirmation password input field
     * @return a String containing the value of the confirmation password input field
     */
    @Step("Get the value of the confirmation password field")
    public String getConfirmPasswordFieldValue() {
        return confirmPasswordField.getAttribute("value");
    }
}


