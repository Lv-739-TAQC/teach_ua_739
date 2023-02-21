package org.ssu.edu.teachua.ui.components.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.components.modal.LoginComponent;
import org.ssu.edu.teachua.ui.components.modal.SignUpComponent;

public class GuestMenuComponent extends BaseComponent {
	
	//@FindBy(how = How.XPATH, using = "//div[@class='ant-dropdown-trigger user-profile']")
	//private WebElement mainElement; 
								
	@FindBy(how = How.XPATH, using = "/ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']"
										+"//li[@data-menu-id='rc-menu-uuid-69246-2-register']")
	private WebElement registration; 
	
	@FindBy(how = How.XPATH, using = "/ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']"
			+"//li[@data-menu-id='rc-menu-uuid-69246-2-login']")
	private WebElement login; 
	
	public GuestMenuComponent(WebDriver driver , WebElement node ) {
		super(driver, node);
    }
    
    public SignUpComponent openRegistrationForm() {
    	registration.click();
    	return new SignUpComponent(driver, componentRoot);
    }
    public LoginComponent openLogInForm() {
    	registration.click();
    	return new LoginComponent(driver, componentRoot);
    }
    
}
