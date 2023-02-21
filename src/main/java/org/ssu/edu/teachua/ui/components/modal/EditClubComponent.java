package org.ssu.edu.teachua.ui.components.modal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;

import java.util.List;

public class EditClubComponent extends AddClubComponent {

    @FindBy(how = How.XPATH, using = "//div[@class='update-club-dropdown']")
    private List<WebElement> addEditDropdowns;

    @FindBy(how = How.XPATH, using = "//div/ul/li[contains(@data-menu-id, 'edit')]")
    private WebElement dropdownElementEditClub;

    @FindBy(how = How.XPATH, using = "//div/ul/li[contains(@data-menu-id,'delete')]")
    private WebElement dropdownElementDeleteClub;

    @FindBy(how = How.XPATH, using = "//div[@class='ant-modal-body’])[1]")
    private WebElement editClubPopUp;

    //first page

    @FindBy(how = How.XPATH, using = "//div/form[@id='edit_category']//div/span[contains(@class, 'add-club-input')]")
    private WebElement editNameField; //min 5 characters //need to be clear

    @FindBy(how = How.XPATH, using = "//div/form[@id='edit_category']//div/label/span[contains(@class, 'ant-checkbox')]")
    private List<WebElement> editCategoriesCheckBoxes;

    @FindBy(how = How.XPATH, using = "//div/form[@id='edit_category']//div/input[@aria-valuemin='2']")
    private WebElement editChildAgeFrom;

    @FindBy(how = How.XPATH, using = "//div/form[@id='edit_category']//div/input[@aria-valuemin='3']")
    private WebElement editChildAgeFor;

    @FindBy(how = How.XPATH, using = "//div/form[@id='edit_category']//div[contains(@class, 'ant-select-in')]")
    private WebElement editBelongingToCenter; //click for open dropdown

    @FindBy(how = How.XPATH, using = "//div[@aria-selected='false' and @class]")
    private List<WebElement> editCenterList;

    //second page// the "nextStepButton" is the same as in AddClubComponent

    @FindBy(how = How.XPATH, using = "//span[@aria-label='edit']")
    private WebElement editLocationButton;

    @FindBy(how = How.XPATH, using = "//span[@aria-label='delete']")
    private WebElement deleteLocationButton;

    // addLocationButton is the same as in AddClubComponent
    // addLocationPopUp is the same as in AddClubComponent
    // onlineSwitchButton is the same as in AddClubComponent
    // all contact fields are the same as in AddClubComponent, but need to be clear

    //third page

    //All fields is the same as in AddClubLocation, but descriptionField need to be clear

    //error messages

    @FindBy(how = How.XPATH, using = ".//div[@id='edit_category_name_help']")
    private WebElement editErrMsgNameField;

    @FindBy(how = How.XPATH, using = ".//div[@id='edit_category_selectedCategories_help']")
    private WebElement editErrMsgCategories;

    //errMsgPhone and errMsgDescription is the same as in the AddClubComponent

    @FindBy(how = How.XPATH, using = "(.//span[@aria-label='check-circle'])[4]")
    private WebElement editCheckCircle;

    public EditClubComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }
}
