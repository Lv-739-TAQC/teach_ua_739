package org.ssu.edu.teachua.ui.components.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;

public class GuestMenuComponent extends BaseComponent {
	
	@FindBy(how = How.XPATH, using = "//div[@class='ant-dropdown-trigger user-profile']")
	WebElement mainElement; 
	
	@FindBy(how = How.XPATH, using = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[1]")
	WebElement registration; 
	
	@FindBy(how = How.XPATH, using = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[2]")
	WebElement login; 
	
	public GuestMenuComponent(WebDriver driver , WebElement node ) {
		super(driver, node);
    }
    
    public void openRegistration() {
    	mainElement.click();
    	registration.click();
    	
    }
    public void openLogIn() {
    	mainElement.click();
    	registration.click();
    }
    
}
