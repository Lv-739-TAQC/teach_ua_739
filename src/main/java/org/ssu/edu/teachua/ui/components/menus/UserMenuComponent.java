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

public class UserMenuComponent  extends BaseComponent implements MenuComponent{
    public UserMenuComponent(WebDriver driver, WebElement node) {
        super(driver, node);
public class UserMenuComponent extends BaseComponent {
	@FindBy(how = How.XPATH, using = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[1]")
	private WebElement addClub;
	@FindBy(how = How.XPATH, using = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[2]")
	private WebElement addCentre;
	@FindBy(how = How.XPATH, using = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[3]")
	private WebElement searchCertificates;
	@FindBy(how = How.XPATH, using = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[4]")
	private WebElement profilePage;
	@FindBy(how = How.XPATH, using = "//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[5]")
	private WebElement logOut;
	@FindBy(how = How.XPATH, using = "//div[@class='ant-modal modal-add-club']")
    private WebElement addClubForm;
    @FindBy(how = How.XPATH, using = "//div[@class='ant-modal addCenter']")
    private WebElement addCentreForm;

	public UserMenuComponent(WebDriver driver, WebElement node) {
		super(driver, node);
	}

	public AddClubComponent openAddClubForm() {
    	addCentre.click();
    	return new AddClubComponent(driver, addClubForm);
    }
	public AddCenterComponent openAddCentreForm() {
    	addCentre.click();
    	return new AddCenterComponent(driver, addCentreForm);
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
