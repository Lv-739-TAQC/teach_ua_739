package org.ssu.edu.teachua.ui.components.modal.add_club_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.AddLocationComponent;
import org.ssu.edu.teachua.ui.components.modal.BaseClubComponent;

public class AddClubContactsComponent extends BaseClubComponent {

    @FindBy(how = How.XPATH, using = ".//div/span[@class='add-club-location']")
    protected WebElement addLocationButton;

    @FindBy(how = How.XPATH, using = ".//button[@role]")
    protected WebElement onlineSwitchButton;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactFacebook']")
    protected WebElement contactFacebookField;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactContact']")
    protected WebElement contactContactField;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactПошта']")
    protected WebElement contactEmailField;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactSkype']")
    protected WebElement contactSkypeField;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactWhatsApp']")
    protected WebElement contactWhatsAppField;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactТелефон']")
    protected WebElement contactPhoneField;

    public AddClubContactsComponent(WebDriver driver) {
        super(driver);
    }

    public AddLocationComponent clickAddLocationButton() {
        waitForElementToBeClickable(addLocationButton);
        this.addLocationButton.click();
        return new AddLocationComponent(driver);
    }

    public AddClubContactsComponent clickOnlineSwitchButton() {
        waitForElementToBeClickable(onlineSwitchButton);
        this.onlineSwitchButton.click();
        return this;
    }

    public AddClubContactsComponent enterContactFacebook(String contactFacebook) {
        waitForElementToBeClickable(contactFacebookField);
        this.contactFacebookField.click();
        this.contactFacebookField.clear();
        this.contactFacebookField.sendKeys(contactFacebook);
        return this;
    }

    public AddClubContactsComponent enterContactContact(String contactContact) {
        waitForElementToBeClickable(contactContactField);
        this.contactContactField.click();
        this.contactContactField.clear();
        this.contactContactField.sendKeys(contactContact);
        return this;
    }

    public AddClubContactsComponent enterContactEmail(String contactEmail) {
        waitForElementToBeClickable(contactEmailField);
        this.contactEmailField.click();
        this.contactEmailField.clear();
        this.contactEmailField.sendKeys(contactEmail);
        return this;
    }

    public AddClubContactsComponent enterContactSkype(String contactSkype) {
        waitForElementToBeClickable(contactSkypeField);
        this.contactSkypeField.click();
        this.contactSkypeField.clear();
        this.contactSkypeField.sendKeys(contactSkype);
        return this;
    }

    public AddClubContactsComponent enterContactWhatsApp(String contactWhatsApp) {
        waitForElementToBeClickable(contactWhatsAppField);
        this.contactWhatsAppField.click();
        this.contactWhatsAppField.clear();
        this.contactWhatsAppField.sendKeys(contactWhatsApp);
        return this;
    }

    public AddClubContactsComponent enterContactPhone(String contactPhone) {
        waitForElementToBeClickable(contactPhoneField);
        this.contactPhoneField.click();
        this.contactPhoneField.clear();
        this.contactPhoneField.sendKeys(contactPhone);
        return this;
    }

    public AddClubDescriptionComponent clickNextStepButton() {
        waitForElementToBeClickable(nextStepButton);
        nextStepButton.click();
        return new AddClubDescriptionComponent(driver);
    }

    public AddClubMainInfoComponent clickPreviousPageButton() {
        waitForElementToBeClickable(previousPageButton);
        previousPageButton.click();
        return new AddClubMainInfoComponent(driver);
    }
}
