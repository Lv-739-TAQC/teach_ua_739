package org.ssu.edu.teachua.ui.components.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdminMenuComponent extends UserMenuComponent implements MenuComponent {

    @FindBy(how = How.XPATH, using = ".//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[4]")
    private WebElement contentButton;
    @FindBy(how = How.XPATH, using = ".//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[8]")
    private WebElement locationPage;
    @FindBy(how = How.XPATH, using = ".//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[8]")
    private WebElement groupButton;
    @FindBy(how = How.XPATH, using = ".//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[8]")
    private WebElement pageButton;

    @FindBy(how = How.XPATH, using = ".//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[8]")
    private WebElement profilePage;
    @FindBy(how = How.XPATH, using = ".//ul[@class='ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light']//li[9]")
    private WebElement logOut;

    public AdminMenuComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

}
