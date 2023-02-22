package org.ssu.edu.teachua.ui.components.modal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddClubContactsComponent extends BaseClubComponent {

    @FindBy(how = How.XPATH, using = ".//div/span[@class='add-club-location']")
    private WebElement addLocationButton;

    @FindBy(how = How.XPATH, using = ".//button[@role]")
    private WebElement onlineSwitchButton;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactFacebook']")
    private WebElement contactFacebookField;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactContact']")
    private WebElement contactContactField;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactПошта']")
    private WebElement contactEmailField;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactSkype']")
    private WebElement contactSkypeField;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactWhatsApp']")
    private WebElement contactWhatsAppField;

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_contactТелефон']")
    private WebElement contactPhoneField;

    public AddClubContactsComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public AddClubContactsComponent clickAddLocationButton() {
        this.addLocationButton.click();
        return new AddLocationComponent(driver, getAddLocationComponent);
    }

    public AddClubContactsComponent clickOnlineSwitchButton() {
        this.onlineSwitchButton.click();
        return this;
    }

    public AddClubContactsComponent enterContactFacebook(String contactFacebook) {
        this.contactFacebookField.click();
        this.contactFacebookField.clear();
        this.contactFacebookField.sendKeys(contactFacebook);
        return this;
    }

    public AddClubContactsComponent enterContactContact(String contactContact) {
        this.contactContactField.click();
        this.contactContactField.clear();
        this.contactContactField.sendKeys(contactContact);
        return this;
    }

    public AddClubContactsComponent enterContactEmail(String contactEmail) {
        this.contactEmailField.click();
        this.contactEmailField.clear();
        this.contactEmailField.sendKeys(contactEmail);
        return this;
    }

    public AddClubContactsComponent enterContactSkype(String contactSkype) {
        this.contactSkypeField.click();
        this.contactSkypeField.clear();
        this.contactSkypeField.sendKeys(contactSkype);
        return this;
    }

    public AddClubContactsComponent enterContactWhatsApp(String contactWhatsApp) {
        this.contactWhatsAppField.click();
        this.contactWhatsAppField.clear();
        this.contactWhatsAppField.sendKeys(contactWhatsApp);
        return this;
    }

    public AddClubContactsComponent enterContactPhone(String contactPhone) {
        this.contactPhoneField.click();
        this.contactPhoneField.clear();
        this.contactPhoneField.sendKeys(contactPhone);
        return this;
    }

    public AddClubDescriptionComponent clickNextStepButton() {
        nextStepButton.click();
        return new AddClubDescriptionComponent(driver, getClubDescriptionComponent());
    }

    public AddClubMainInfoComponent clickPreviousPageButton() {
        previousPageButton.click();
        return new AddClubMainInfoComponent(driver, getClubMainInfoComponent());
    }
}
