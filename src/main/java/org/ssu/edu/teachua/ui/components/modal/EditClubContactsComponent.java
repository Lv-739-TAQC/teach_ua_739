package org.ssu.edu.teachua.ui.components.modal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditClubContactsComponent extends AddClubContactsComponent {

    @FindBy(how = How.XPATH, using = ".//span[@aria-label='edit']")
    private WebElement editLocationButton;

    @FindBy(how = How.XPATH, using = ".//span[@aria-label='delete']")
    private WebElement deleteLocationButton;

    public EditClubContactsComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }
}
