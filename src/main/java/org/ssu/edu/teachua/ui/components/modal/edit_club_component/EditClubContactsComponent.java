package org.ssu.edu.teachua.ui.components.modal.edit_club_component;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.AddLocationComponent;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubContactsComponent;

/**
 * This class contains elements and classes
 * that describe the Contacts page of Edit Club pop-up
 */
public class EditClubContactsComponent extends AddClubContactsComponent {

    /**
     * This element is finds by xPath the "Add Location" button
     */
    @FindBy(how = How.XPATH, using = ".//span[@aria-label='edit']")
    private WebElement editLocationButton;

    /**
     * This element is finds by xPath the "Delete Location" icon
     */
    @FindBy(how = How.XPATH, using = ".//span[@aria-label='delete']")
    private WebElement deleteLocationButton;

    /**
     * This element is finds by xPath the "Delete location?" message
     */
    @FindBy(how = How.XPATH, using = ".//div[@class='ant-popover-message']")
    private WebElement deleteLocationMessage;

    /**
     * This element is finds by xPath the "Yes" button on the "Delete location?" message
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'ok-button')]")
    private WebElement okDeleteLocationButton;

    /**
     * This element is finds by xPath the "No" button on the "Delete location?" message
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'cancel-button')]")
    private WebElement cancelDeleteLocationButton;

    /**
     * This element is finds by xPath the field for entering the club Phone number
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_Телефон']")
    protected WebElement editContactPhoneField;

    public EditClubContactsComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * This method open the Add Location pop-up
     * @return new instance of AddLocationComponent
     */
    @Step("Open Edit Location pop-up")
    public AddLocationComponent clickEditLocationButton() {
        waitForElementToBeClickable(editLocationButton);
        this.editLocationButton.click();
        return new AddLocationComponent(driver);
    }

    /**
     * This method deleting current location
     * @return delete location message
     */
    @Step("Delete current location")
    public EditClubContactsComponent clickDeleteLocationButton() {
        waitForElementToBeClickable(deleteLocationButton);
        this.deleteLocationButton.click();
        waitForElementToAppear(deleteLocationMessage);
        return (EditClubContactsComponent) deleteLocationMessage;
    }

    /**
     * This method confirm deletion the location
     * @return instance of EditClubContactsComponent
     */
    @Step("Confirm deletion the location")
    public EditClubContactsComponent clickOkDeleteLocationButton() {
        waitForElementToBeClickable(okDeleteLocationButton);
        this.okDeleteLocationButton.click();
        return this;
    }

    /**
     * This method cancel deletion the location
     * @return instance of EditClubContactsComponent
     */
    @Step("Cancel deletion the location")
    public EditClubContactsComponent clickCancelDeleteLocationButton() {
        waitForElementToBeClickable(cancelDeleteLocationButton);
        this.cancelDeleteLocationButton.click();
        return this;
    }

    /**
     * This method editing the club 'online' status
     * @return instance of EditClubContactsComponent
     */
    @Step("Edit the club 'online' status")
    public EditClubContactsComponent clickEditOnlineSwitchButton() {
        waitForElementToBeClickable(onlineSwitchButton);
        this.onlineSwitchButton.click();
        return this;
    }

    /**
     * This method deleting old club Facebook contact and entering new club Facebook contact
     * @param editContactFacebook
     * @return instance of EditClubContactsComponent
     */
    @Step("Edit Facebook contact {editContactFacebook}")
    public EditClubContactsComponent enterEditContactFacebook(String editContactFacebook) {
        waitForElementToBeClickable(contactFacebookField);
        this.contactFacebookField.click();
        this.contactFacebookField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.contactFacebookField.sendKeys(editContactFacebook);
        return this;
    }

    /**
     * This method deleting old club Website contact and entering new club Website contact
     * @param editContactContact club Website
     * @return instance of EditClubContactsComponent
     */
    @Step("Edit club contact {editContactContact}")
    public EditClubContactsComponent enterEditContactContact(String editContactContact) {
        waitForElementToBeClickable(contactContactField);
        this.contactContactField.click();
        this.contactContactField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.contactContactField.sendKeys(editContactContact);
        return this;
    }

    /**
     * This method deleting old club Email contact and entering new club Email contact
     * @param editContactEmail
     * @return instance of EditClubContactsComponent
     */
    @Step("Edit email contact {editContactEmail}")
    public EditClubContactsComponent enterEditContactEmail(String editContactEmail) {
        waitForElementToBeClickable(contactEmailField);
        this.contactEmailField.click();
        this.contactEmailField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.contactEmailField.sendKeys(editContactEmail);
        return this;
    }

    /**
     * This method deleting old club Skype contact and entering new club Skype contact
     * @param editContactSkype
     * @return instance of EditClubContactsComponent
     */
    @Step("Edit Skype contact {editContactSkype}")
    public EditClubContactsComponent enterEditContactSkype(String editContactSkype) {
        waitForElementToBeClickable(contactSkypeField);
        this.contactSkypeField.click();
        this.contactSkypeField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.contactSkypeField.sendKeys(editContactSkype);
        return this;
    }

    /**
     * This method deleting old club WhatsApp contact and entering new club WhatsApp contact
     * @param editContactWhatsApp
     * @return instance of EditClubContactsComponent
     */
    @Step("Edit WhatsApp contact {editContactWhatsApp}")
    public EditClubContactsComponent enterEditContactWhatsApp(String editContactWhatsApp) {
        waitForElementToBeClickable(contactWhatsAppField);
        this.contactWhatsAppField.click();
        this.contactWhatsAppField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.contactWhatsAppField.sendKeys(editContactWhatsApp);
        return this;
    }

    /**
     * This method deleting old club Phone number without country code and entering new club Phone number without country code
     * @param editContactPhone
     * @return instance of EditClubContactsComponent
     */
    @Step("Edit phone number {editContactPhone}")
    public EditClubContactsComponent enterEditContactPhone(String editContactPhone) {
        waitForElementToBeClickable(editContactPhoneField);
        editContactPhoneField.click();
        editContactPhoneField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        editContactPhoneField.sendKeys(editContactPhone);
        return this;
    }

    /**
     * This method click on the 'Next' button
     * @return new instance of EditClubDescriptionComponent
     */
    @Step("Click on the 'Next' button")
    public EditClubDescriptionComponent clickEditNextStepButton() {
        waitForElementToBeClickable(nextStepButton);
        nextStepButton.click();
        return new EditClubDescriptionComponent(driver);
    }

    /**
     * This method click on the 'Back' button
     * @return new instance of EditClubDescriptionComponent
     */
    @Step("Click on the 'Back' button")
    public EditClubDescriptionComponent clickEditPreviousPageButton() {
        waitForElementToBeClickable(previousPageButton);
        previousPageButton.click();
        return new EditClubDescriptionComponent(driver);
    }
}
