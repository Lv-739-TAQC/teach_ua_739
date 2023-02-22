package org.ssu.edu.teachua.ui.components.modal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class EditClubMainInfoComponent extends AddClubMainInfoComponent {

    @FindBy(how = How.XPATH, using = ".//div/form[@id='edit_category']//div/span[contains(@class, 'add-club-input')]")
    private WebElement editNameField; //min 5 characters //need to be clear

    @FindBy(how = How.XPATH, using = ".//div/form[@id='edit_category']//div/label/span[contains(@class, 'ant-checkbox')]")
    private List<WebElement> editCategoriesCheckBoxes;

    @FindBy(how = How.XPATH, using = ".//div/form[@id='edit_category']//div/input[@aria-valuemin='2']")
    private WebElement editChildAgeFrom;

    @FindBy(how = How.XPATH, using = ".//div/form[@id='edit_category']//div/input[@aria-valuemin='3']")
    private WebElement editChildAgeFor;

    @FindBy(how = How.XPATH, using = ".//div/form[@id='edit_category']//div[contains(@class, 'ant-select-in')]")
    private WebElement editBelongingToCenter; //click for open dropdown

    @FindBy(how = How.XPATH, using = ".//div[@aria-selected='false' and @class]")
    private List<WebElement> editCenterList;


    public EditClubMainInfoComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }
}
