package org.ssu.edu.teachua.ui.components.menus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.components.modal.LoginComponent;
import org.ssu.edu.teachua.ui.components.modal.SignUpComponent;

public class GuestMenuComponent extends BaseComponent implements MenuComponent {
    public GuestMenuComponent(WebDriver driver, WebElement node) {
        super(driver, node);
public class GuestMenuComponent extends BaseComponent {

	@FindBy(how = How.XPATH, using = "//div[@class='ant-dropdown-trigger user-profile']")
	private WebElement profileMenuButton;
	@FindBy(how = How.XPATH, using = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[1]")
	private WebElement registration;
    @FindBy(how = How.XPATH, using = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[2]")
	private WebElement login;


    @FindBy(how = How.XPATH, using = "//div[@class='ant-modal modal-registration']")
    private WebElement registrationForm;
    @FindBy(how = How.XPATH, using = "//div[@class='ant-modal modal-login']")
    private WebElement loginForm;



	public GuestMenuComponent(WebDriver driver , WebElement node ) {
		super(driver, node);
	}

    public SignUpComponent openRegistrationForm() {
    	registration.click();
    	return new SignUpComponent(driver, registrationForm);
    }
    public LoginComponent openLogInForm() {
    	login.click();
    	return new LoginComponent(driver, loginForm);
    }

}
