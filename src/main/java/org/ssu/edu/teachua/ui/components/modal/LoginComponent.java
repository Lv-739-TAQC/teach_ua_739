package org.ssu.edu.teachua.ui.components.modal;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;

public class LoginComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_email']")
    private WebElement emailField;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_password']")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = ".//button[contains(@type,'submit')]")
    private WebElement logInButton;

    @FindBy(how = How.XPATH, using = ".//button[contains(@aria-label,'Close')]")
    private WebElement closeButton;

    public LoginComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    @Step("set to input email: {email} ")
    public LoginComponent enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    @Step("set to input password: {password} ")
    public LoginComponent enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("click login")
    public HomePage clickLoginButton() {
        logInButton.click();
        return new HomePage(driver);
    }
}

