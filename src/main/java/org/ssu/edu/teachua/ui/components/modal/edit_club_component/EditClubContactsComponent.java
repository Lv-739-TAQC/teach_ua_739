package org.ssu.edu.teachua.ui.components.modal.edit_club_component;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.AddLocationComponent;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubContactsComponent;

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

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_Телефон']")
    protected WebElement editContactPhoneField;

    public EditClubContactsComponent(WebDriver driver) {
        super(driver);
    }

    public AddLocationComponent clickEditLocationButton() {
        waitForElementToBeClickable(editLocationButton);
        this.editLocationButton.click();
        return new AddLocationComponent(driver);
    }

    public EditClubContactsComponent clickDeleteLocationButton() {
        waitForElementToBeClickable(deleteLocationButton);
        this.deleteLocationButton.click();
        waitForElementToAppear(deleteLocationMessage);
        return (EditClubContactsComponent) deleteLocationMessage;
    }

    public EditClubContactsComponent clickOkDeleteLocationButton() {
        waitForElementToBeClickable(okDeleteLocationButton);
        this.okDeleteLocationButton.click();
        return this;
    }

    public EditClubContactsComponent clickCancelDeleteLocationButton() {
        waitForElementToBeClickable(cancelDeleteLocationButton);
        this.cancelDeleteLocationButton.click();
        return this;
    }

    public EditClubContactsComponent clickEditOnlineSwitchButton() {
        waitForElementToBeClickable(onlineSwitchButton);
        this.onlineSwitchButton.click();
        return this;
    }

    public EditClubContactsComponent enterEditContactFacebook(String editContactFacebook) {
        waitForElementToBeClickable(contactFacebookField);
        this.contactFacebookField.click();
        this.contactFacebookField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.contactFacebookField.sendKeys(editContactFacebook);
        return this;
    }

    public EditClubContactsComponent enterEditContactContact(String editContactContact) {
        waitForElementToBeClickable(contactContactField);
        this.contactContactField.click();
        this.contactContactField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.contactContactField.sendKeys(editContactContact);
        return this;
    }

    public EditClubContactsComponent enterEditContactEmail(String editContactEmail) {
        waitForElementToBeClickable(contactEmailField);
        this.contactEmailField.click();
        this.contactEmailField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.contactEmailField.sendKeys(editContactEmail);
        return this;
    }

    public EditClubContactsComponent enterEditContactSkype(String editContactSkype) {
        waitForElementToBeClickable(contactSkypeField);
        this.contactSkypeField.click();
        this.contactSkypeField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.contactSkypeField.sendKeys(editContactSkype);
        return this;
    }

    public EditClubContactsComponent enterEditContactWhatsApp(String editContactWhatsApp) {
        waitForElementToBeClickable(contactWhatsAppField);
        this.contactWhatsAppField.click();
        this.contactWhatsAppField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.contactWhatsAppField.sendKeys(editContactWhatsApp);
        return this;
    }

    public EditClubContactsComponent enterEditContactPhone(String editContactPhone) {
        waitForElementToBeClickable(editContactPhoneField);
        editContactPhoneField.click();
        editContactPhoneField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        editContactPhoneField.sendKeys(editContactPhone);
        return this;
    }

    public EditClubDescriptionComponent clickEditNextStepButton() {
        waitForElementToBeClickable(nextStepButton);
        nextStepButton.click();
        return new EditClubDescriptionComponent(driver);
    }

    public EditClubDescriptionComponent clickEditPreviousPageButton() {
        waitForElementToBeClickable(previousPageButton);
        previousPageButton.click();
        return new EditClubDescriptionComponent(driver);
    }
}
