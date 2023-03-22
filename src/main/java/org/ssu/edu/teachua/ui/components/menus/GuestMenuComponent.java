package org.ssu.edu.teachua.ui.components.menus;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.components.modal.LoginComponent;
import org.ssu.edu.teachua.ui.components.modal.SignUpComponent;

/**
 * This class contains methods and elements that describe the menu components for 'Guest' role
 */
public class GuestMenuComponent extends BaseComponent {

    /**
     * This element is finds by xPath the 'Registration' element in the menu dropdown list
     */
    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'register')]")
    private WebElement registration;

    /**
     * This element is finds by xPath the 'Login' element in the menu dropdown list
     */
    @FindBy(how = How.XPATH, using = ".//li[contains(@data-menu-id, 'login')]")
    private WebElement login;

    /**
     * This element is finds by xPath the 'Registration' pop-up
     */
    @FindBy(how = How.XPATH, using = "//div[@class='ant-modal modal-registration']")
    private WebElement registerModalForm;

    /**
     * This element is finds by xPath the 'Login' pop-up
     */
    @FindBy(how = How.XPATH, using = "//div[@class='ant-modal modal-login']")
    private WebElement loginModalForm;

    public GuestMenuComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    /**
     * This method is clicking on 'Registration' element in the menu dropdown
     * which opens Registration pop-up
     * @return new instance of {@link SignUpComponent}
     */
    @Step("Click sign up button. Open the registration form.")
    public SignUpComponent openRegistrationForm() {
        waitForElementToBeClickable(registration).click();
        return new SignUpComponent(driver, registerModalForm);
    }

    /**
     * This method is clicking on 'Login' element in the menu dropdown
     * which opens Login pop-up
     * @return new instance of {@link LoginComponent}
     */
    @Step("Click login button")
    public LoginComponent openLogInForm() {
        waitForElementToBeClickable(login).click();
        return new LoginComponent(driver, loginModalForm);
    }
}
