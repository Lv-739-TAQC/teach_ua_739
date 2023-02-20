package org.ssu.edu.teachua.ui.components.modal;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;

import java.util.List;
import java.util.stream.Collectors;

public class AddClubComponent extends BaseComponent {

    //first page

    @FindBy(how = How.XPATH, using = "//div[@class='add-club-dropdown']/button")
    private WebElement addButton; // hover mouse for open dropdown

    @FindBy(how = How.XPATH, using = "//div/ul/li[contains(@data-menu-id,'tmp_key-0')]")
    private WebElement dropdownElementAddClub;

    @FindBy(how = How.XPATH, using = "//div[@class='ant-modal-body'])[2]")
    private WebElement addClubPopUp;

    @FindBy(how = How.XPATH, using = "//div/form[@id='basic']//div/span[contains(@class, 'add-club-input')]")
    private WebElement nameField; // min 5 characters

    @FindBy(how = How.XPATH, using = "$x(//div/form[@id='basic']//div/label/span[contains(@class, 'ant-checkbox')]")
    private List<WebElement> categoriesCheckBoxes;

    @FindBy(how = How.XPATH, using = "//div/form[@id='basic']//div/input[@aria-valuemin='2']")
    private WebElement childAgeFrom;

    @FindBy(how = How.XPATH, using = "//div/form[@id='basic']//div/input[@aria-valuemin='3']")
    private WebElement childAgeFor;

    @FindBy(how = How.XPATH, using = "//div/form[@id='basic']//div[contains(@class, 'ant-select-in')]")
    private WebElement belongingToCenter; //click for open dropdown

    @FindBy(how = How.XPATH, using = "//div[@aria-selected='false' and @class]")
    private List<WebElement> centerList;

    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'add-club-content-next')]")
    private WebElement nextStepButton;

    //second page

    @FindBy(how = How.XPATH, using = "//div/span[@class='add-club-location']")
    private WebElement addLocationButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'add-club-locations')]")
    private WebElement addLocationPopUp;

    @FindBy(how = How.XPATH, using = "//button[@role]")
    private WebElement onlineSwitchButton;

    @FindBy(how = How.XPATH, using = "//input[@id='basic_contactFacebook']")
    private WebElement contactFacebookField;

    @FindBy(how = How.XPATH, using = "//input[@id='basic_contactContact']")
    private WebElement contactContactField;

    @FindBy(how = How.XPATH, using = "//input[@id='basic_contactПошта']")
    private WebElement contactEmailField;

    @FindBy(how = How.XPATH, using = "//input[@id='basic_contactSkype']")
    private WebElement contactSkypeField;

    @FindBy(how = How.XPATH, using = "//input[@id='basic_contactWhatsApp']")
    private WebElement contactWhatsAppField;

    @FindBy(how = How.XPATH, using = "//input[@id='basic_contactТелефон']")
    private WebElement contactPhoneField;

    //third page

    @FindBy(how = How.XPATH, using = "(//span[@class='add-club-upload'])[1]")
    private WebElement uploadLogo;

    @FindBy(how = How.XPATH, using = "(//span[@class='add-club-upload'])[2]")
    private WebElement uploadBackgroundPicture;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'ant-upload')]//span[@aria-label='plus']")
    private WebElement uploadGallery;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'ant-input-textarea')]")
    private WebElement descriptionField; //min 40 max 1500 characters

    public AddClubComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }
}
