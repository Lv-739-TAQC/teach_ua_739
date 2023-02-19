package org.ssu.edu.teachua.ui.components.modal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;


public class SignUpComponent extends BaseComponent {
    @FindBy (how = How.XPATH, using = "//input[@id='lastName']")
    private WebElement lastNameField;
    @FindBy (how = How.XPATH, using = "//input[@id='firstName']")
    private WebElement firstNameField;
    @FindBy (how = How.XPATH, using = "//input[@id='phone']")
    private WebElement phoneField;
    @FindBy (how = How.XPATH, using = "//input[@id='email']")
    private WebElement emailField;
    @FindBy (how = How.XPATH, using = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy (how = How.XPATH, using = "//input[@id='confirm']")
    private WebElement confirmPasswordField;
    @FindBy (how = How.XPATH, using = "//div[@class='ant-modal modal-registration']//button[contains(@aria-label,'Close')]")
    private WebElement closeButton;
    @FindBy (how = How.XPATH, using = "//*[@class='ant-btn ant-btn-default registration-button']")
    private WebElement signUpButton;

    public SignUpComponent (WebDriver driver, WebElement node) {super(driver, node);}

    public SignUpComponent enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }
    public SignUpComponent enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }
    public SignUpComponent enterPhone(String phone) {
        phoneField.sendKeys(phone);
        return this;
    }

    public SignUpComponent enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public SignUpComponent enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public SignUpComponent enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
        return this;
    }
    public HomePage clickCloseButton() {
        closeButton.click();
        return new HomePage(driver);
    }


    public String enterLastNameFieldValue() {
        return lastNameField.getAttribute("value");
    }

    public String enterFirstNameFieldValue() {
        return firstNameField.getAttribute("value");
    }

    public String enterPhoneFieldValue() {
        return phoneField.getAttribute("value");
    }

    public String enterEmailFieldValue() {
        return emailField.getAttribute("value");
    }

    public String enterPasswordFieldValue() {
        return passwordField.getAttribute("value");
    }

    public String enterConfirmPasswordFieldValue() {
        return confirmPasswordField.getAttribute("value");
    }
}

