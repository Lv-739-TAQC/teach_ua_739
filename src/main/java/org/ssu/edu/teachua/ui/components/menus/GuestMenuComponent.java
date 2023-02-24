package org.ssu.edu.teachua.ui.components.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.components.modal.LoginComponent;
import org.ssu.edu.teachua.ui.components.modal.SignUpComponent;

public class GuestMenuComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'register')]")
    private WebElement registration;

    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'login')]")
    private WebElement login;

    @FindBy(how = How.XPATH, using = "//div[@class='ant-modal modal-registration']")
    private WebElement registerModalForm;

    @FindBy(how = How.XPATH, using = "//div[@class='ant-modal modal-login']")
    private WebElement loginModalForm;

    public GuestMenuComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public SignUpComponent openRegistrationForm() {
        waitForElementToBeClickable(registration).click();
        return new SignUpComponent(driver, registerModalForm);
    }

    public LoginComponent openLogInForm() {
        waitForElementToBeClickable(login).click();
        return new LoginComponent(driver, loginModalForm);
    }
}
