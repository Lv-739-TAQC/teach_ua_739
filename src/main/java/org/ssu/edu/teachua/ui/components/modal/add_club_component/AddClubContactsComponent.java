package org.ssu.edu.teachua.ui.components.modal.add_club_component;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.AddLocationComponent;
import org.ssu.edu.teachua.ui.components.modal.BaseClubComponent;

/**
 * This class contains elements and classes
 * that describe the Contacts page of Add Club pop-up
 */
public class AddClubContactsComponent extends BaseClubComponent {

    /**
     * This element is finds by xPath the "Add Location" button
     */
    @FindBy(how = How.XPATH, using = ".//div/span[@class='add-club-location']")
    protected WebElement addLocationButton;

    /**
     * This element is finds by xPath the "Online" slider button
     * which makes club online or offline
     */
    @FindBy(how = How.XPATH, using = ".//button[@role]")
    protected WebElement onlineSwitchButton;

    /**
     * This element is finds by xPath the field for entering the club Facebook contact
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactFacebook']")
    protected WebElement contactFacebookField;

    /**
     * This element is finds by xPath the field for entering the club Website contact
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactContact']")
    protected WebElement contactContactField;

    /**
     * This element is finds by xPath the field for entering the club Email contact
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactПошта']")
    protected WebElement contactEmailField;

    /**
     * This element is finds by xPath the field for entering the club Skype contact
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactSkype']")
    protected WebElement contactSkypeField;

    /**
     * This element is finds by xPath the field for entering the club WhatsApp contact
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactWhatsApp']")
    protected WebElement contactWhatsAppField;

    /**
     * This element is finds by xPath the field for entering the club Phone number
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactТелефон']")
    protected WebElement contactPhoneField;

    public AddClubContactsComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * This method open the Add Location pop-up
     * @return new instance of AddLocationComponent
     */
    @Step("Open Add Location pop-up")
    public AddLocationComponent clickAddLocationButton() {
        waitForElementToBeClickable(addLocationButton);
        this.addLocationButton.click();
        return new AddLocationComponent(driver);
    }

    /**
     * This method makes club online
     * @return instance of AddClubContactsComponent
     */
    @Step("Makes club online")
    public AddClubContactsComponent clickOnlineSwitchButton() {
        waitForElementToBeClickable(onlineSwitchButton);
        this.onlineSwitchButton.click();
        return this;
    }

    /**
     * This method entering club Facebook contact
     * @param contactFacebook
     * @return instance of AddClubContactsComponent
     */
    @Step("Enter Facebook contact {contactFacebook}")
    public AddClubContactsComponent enterContactFacebook(String contactFacebook) {
        waitForElementToBeClickable(contactFacebookField);
        this.contactFacebookField.click();
        this.contactFacebookField.clear();
        this.contactFacebookField.sendKeys(contactFacebook);
        return this;
    }

    /**
     * This method entering club Website contact
     * @param contactContact club Website
     * @return instance of AddClubContactsComponent
     */
    @Step("Enter club contact {contactContact}")
    public AddClubContactsComponent enterContactContact(String contactContact) {
        waitForElementToBeClickable(contactContactField);
        this.contactContactField.click();
        this.contactContactField.clear();
        this.contactContactField.sendKeys(contactContact);
        return this;
    }

    /**
     * This method entering club Email contact
     * @param contactEmail
     * @return instance of AddClubContactsComponent
     */
    @Step("Enter email contact {contactEmail}")
    public AddClubContactsComponent enterContactEmail(String contactEmail) {
        waitForElementToBeClickable(contactEmailField);
        this.contactEmailField.click();
        this.contactEmailField.clear();
        this.contactEmailField.sendKeys(contactEmail);
        return this;
    }

    /**
     * This method entering club Skype contact
     * @param contactSkype
     * @return instance of AddClubContactsComponent
     */
    @Step("Enter Skype contact{contactSkype}")
    public AddClubContactsComponent enterContactSkype(String contactSkype) {
        waitForElementToBeClickable(contactSkypeField);
        this.contactSkypeField.click();
        this.contactSkypeField.clear();
        this.contactSkypeField.sendKeys(contactSkype);
        return this;
    }

    /**
     * This method entering club WhatsApp contact
     * @param contactWhatsApp
     * @return instance of AddClubContactsComponent
     */
    @Step("Enter WhatsApp contact {contactWhatsApp}")
    public AddClubContactsComponent enterContactWhatsApp(String contactWhatsApp) {
        waitForElementToBeClickable(contactWhatsAppField);
        this.contactWhatsAppField.click();
        this.contactWhatsAppField.clear();
        this.contactWhatsAppField.sendKeys(contactWhatsApp);
        return this;
    }

    /**
     * This method entering club Phone number without country code
     * @param contactPhone
     * @return instance of AddClubContactsComponent
     */
    @Step("Enter phone number {contactPhone}")
    public AddClubContactsComponent enterContactPhone(String contactPhone) {
        waitForElementToBeClickable(contactPhoneField);
        this.contactPhoneField.click();
        this.contactPhoneField.clear();
        this.contactPhoneField.sendKeys(contactPhone);
        return this;
    }

    /**
     * This method click on the 'Next' button
     * @return new instance of AddClubDescriptionComponent
     */
    @Step("Click on the 'Next' button")
    public AddClubDescriptionComponent clickNextStepButton() {
        waitForElementToBeClickable(nextStepButton);
        nextStepButton.click();
        return new AddClubDescriptionComponent(driver);
    }

    /**
     * This method click on the 'Back' button
     * @return new instance of AddClubMainInfoComponent
     */
    @Step("Click on the 'Back' button")
    public AddClubMainInfoComponent clickPreviousPageButton() {
        waitForElementToBeClickable(previousPageButton);
        previousPageButton.click();
        return new AddClubMainInfoComponent(driver);
    }
}
