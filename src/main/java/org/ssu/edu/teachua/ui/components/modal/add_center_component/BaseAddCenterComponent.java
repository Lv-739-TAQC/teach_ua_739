package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;

public abstract class BaseAddCenterComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-title')])[1]")
    protected WebElement mainInfo;
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-title')])[2]")
    protected WebElement contacts;
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-title')])[3]")
    protected WebElement description;
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-title')])[4]")
    protected WebElement clubs;
    @FindBy(how = How.XPATH, using = "(.//main[contains(@class, 'add-center-container')]")
    protected WebElement addCenterContainer;


     public BaseAddCenterComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public WebElement getMainInfo() {
        return mainInfo;
    }

    public WebElement getContacts() {
        return contacts;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getClubs() {
        return clubs;
    }

}