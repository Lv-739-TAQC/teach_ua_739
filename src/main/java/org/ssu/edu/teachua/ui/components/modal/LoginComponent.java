package org.ssu.edu.teachua.ui.components.modal;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;

/**
 * Class LoginComponent contains webElements and methods which represents
 * the functionality to log in the system
 */
public class LoginComponent extends BaseComponent {
    /**
     * WebElement representing the email input field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_email']")
    private WebElement emailField;
    /**
     * WebElement representing the password input field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_password']")
    private WebElement passwordField;
    /**
     * WebElement representing log in button
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@type,'submit')]")
    private WebElement logInButton;
    /**
     * WebElement representing close button
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@aria-label,'Close')]")
    private WebElement closeButton;

    /**
     * Constructs a new LoginComponent with the specified WebDriver and node.
     * @param driver the WebDriver object used to interact with the web browser
     * @param node the WebElement representing the login component in the web page
     */
    public LoginComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    /**
     * Enters the data into the email input field
     * @param email
     * @return modal window "Log in" with entered email
     */
    @Step("Set to input email field value: {email} ")
    public LoginComponent enterEmail(String email) {
        waitForElementToAppear(emailField).sendKeys(email);
        return this;
    }

    /**
     * Enters the data into the password input field
     * @param password
     * @return modal window "Log in" with entered password
     */
    @Step("Set to input password field value: {password} ")
    public LoginComponent enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    /**
     * Click on "Log in" button and log in the system
     * @return HomePage
     */
    @Step("Click on Log In button")
    public HomePage clickLoginButton() {
        logInButton.click();
        return new HomePage(driver);
    }
}

