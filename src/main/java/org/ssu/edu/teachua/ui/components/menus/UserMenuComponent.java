package org.ssu.edu.teachua.ui.components.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.components.modal.AddCenterComponent;
import org.ssu.edu.teachua.ui.components.modal.AddClubComponent;
import org.ssu.edu.teachua.ui.components.modal.LoginComponent;
import org.ssu.edu.teachua.ui.components.modal.SignUpComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;

public class UserMenuComponent extends BaseComponent {
	//@FindBy(how = How.XPATH, using = "//div[@class='ant-dropdown-trigger user-profile']")
	//WebElement mainElement; 
	
	@FindBy(how = How.XPATH, using = "/ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']"+
		 	"//li[@data-menu-id='rc-menu-uuid-69246-2-add_club']")
	private WebElement addClub;
	
	@FindBy(how = How.XPATH, using = "/ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']"+
									 	"//li[@data-menu-id='rc-menu-uuid-01896-2-add_centre']")
	private WebElement addCentre; 
	
	@FindBy(how = How.XPATH, using = "/ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']"+
			  							"//li[@data-menu-id='rc-menu-uuid-01896-2-search_certificates']")
	private WebElement searchCertificates; 
	
	@FindBy(how = How.XPATH, using = "/ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']"+
										"//li[@data-menu-id='rc-menu-uuid-01896-2-profile']")
	private WebElement profilePage; 

	@FindBy(how = How.XPATH, using = "/ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']"+
										"//li[@data-menu-id='rc-menu-uuid-01896-2-logout']")
	private WebElement logOut;
	
	public UserMenuComponent(WebDriver driver, WebElement node) {
		super(driver, node);
	}
	
	public AddClubComponent openAddClubForm() {
    	addCentre.click();
    	return new AddClubComponent(driver, componentRoot);
    }
	public AddCenterComponent openAddCentreForm() {
    	
		addCentre.click();
    	return new AddCenterComponent(driver, componentRoot);
    }
	
    public void SearchCertificates() {
    	searchCertificates.click();
    }
    
    public ProfilePage openProfilePage() {
    	searchCertificates.click();
    	return new ProfilePage(driver);
    }
    
    public HomePage logOut() {
    	logOut.click();
    	return new HomePage(driver);
    }
}
