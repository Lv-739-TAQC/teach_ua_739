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

    @FindBy(how = How.XPATH, using = ".//div[@class='ant-popover-message']")
    private WebElement deleteLocationMessage;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'ok-button')]")
    private WebElement okDeleteLocationButton;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'cancel-button')]")
    private WebElement cancelDeleteLocationButton;

    public EditClubContactsComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public EditClubContactsComponent clickEditLocationButton() {
        this.editLocationButton.click();
        return this;
        // need create getAddLocationComponent
    }

    public EditClubContactsComponent clickDeleteLocationButton() {
        this.deleteLocationButton.click();
        return (EditClubContactsComponent) deleteLocationMessage;
    }

    public EditClubContactsComponent clickOkDeleteLocationButton() {
        this.okDeleteLocationButton.click();
        return this;
    }

    public EditClubContactsComponent clickCancelDeleteLocationButton() {
        this.cancelDeleteLocationButton.click();
        return this;
    }

    public EditClubContactsComponent clickEditOnlineSwitchButton() {
        this.onlineSwitchButton.click();
        return this;
    }

    public EditClubContactsComponent enterEditContactFacebook(String editContactFacebook) {
        this.contactFacebookField.click();
        this.contactFacebookField.clear();
        this.contactFacebookField.sendKeys(editContactFacebook);
        return this;
    }

    public EditClubContactsComponent enterEditContactContact(String editContactContact) {
        this.contactContactField.click();
        this.contactContactField.clear();
        this.contactContactField.sendKeys(editContactContact);
        return this;
    }

    public EditClubContactsComponent enterEditContactEmail(String editContactEmail) {
        this.contactEmailField.click();
        this.contactEmailField.clear();
        this.contactEmailField.sendKeys(editContactEmail);
        return this;
    }

    public EditClubContactsComponent enterEditContactSkype(String editContactSkype) {
        this.contactSkypeField.click();
        this.contactSkypeField.clear();
        this.contactSkypeField.sendKeys(editContactSkype);
        return this;
    }

    public EditClubContactsComponent enterEditContactWhatsApp(String editContactWhatsApp) {
        this.contactWhatsAppField.click();
        this.contactWhatsAppField.clear();
        this.contactWhatsAppField.sendKeys(editContactWhatsApp);
        return this;
    }

    public EditClubContactsComponent enterEditContactPhone(String editContactPhone) {
        this.contactPhoneField.click();
        this.contactPhoneField.clear();
        this.contactPhoneField.sendKeys(editContactPhone);
        return this;
    }

    public EditClubDescriptionComponent clickEditNextStepButton() {
        nextStepButton.click();
        return new EditClubDescriptionComponent(driver, getClubDescriptionComponent());
    }

    public EditClubDescriptionComponent clickEditPreviousPageButton() {
        previousPageButton.click();
        return new EditClubDescriptionComponent(driver, getClubMainInfoComponent());
    }
}
