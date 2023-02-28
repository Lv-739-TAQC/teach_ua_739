package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCenterContactsComponent extends BaseAddCenterComponent {
    @FindBy(how = How.XPATH, using = ".//input[@id='contacts_contactFacebook']")
    private WebElement facebook;
    @FindBy(how = How.XPATH, using = ".//input[@id='contacts_contactContact']")
    private WebElement site;
    @FindBy(how = How.XPATH, using = ".//input[@id='contacts_contactПошта']")
    private WebElement mail;
    @FindBy(how = How.XPATH, using = ".//input[@id='contacts_contactSkype']")
    private WebElement skype;
    @FindBy(how = How.XPATH, using = ".//input[@id='contacts_contactWhatsApp']")
    private WebElement whatsApp;
    @FindBy(how = How.XPATH, using = ".//input[@id='contacts_contactТелефон']")
    private WebElement phone;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'next-btn')]")
    private WebElement nextStepButton;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'prev-btn')]")
    private WebElement backButton;

    public AddCenterContactsComponent(WebDriver driver) {
        super(driver);
    }

    public AddCenterContactsComponent enterCenterFacebook(String centerFacebook) {
        facebook.click();
        facebook.clear();
        facebook.sendKeys(centerFacebook);
        return this;
    }

    public AddCenterContactsComponent enterCenterSite(String centerSite) {
        site.click();
        site.clear();
        site.sendKeys(centerSite);
        return this;
    }

    public AddCenterContactsComponent enterCenterMail(String centerMail) {
        mail.click();
        mail.clear();
        mail.sendKeys(centerMail);
        return this;
    }

    public AddCenterContactsComponent enterCenterSkype(String centerSkype) {
        skype.click();
        skype.clear();
        skype.sendKeys(centerSkype);
        return this;
    }

    public AddCenterContactsComponent enterCenterWhatsAppNumber(String centerWhatsApp) {
        whatsApp.click();
        whatsApp.clear();
        whatsApp.sendKeys(centerWhatsApp);
        return this;
    }

    public AddCenterContactsComponent enterPhone(String contactPhone) {
        phone.click();
        phone.clear();
        phone.sendKeys(contactPhone);
        return this;
    }

    public AddCenterDescriptionComponent pressNextButton() {
        this.nextStepButton.click();
        return new AddCenterDescriptionComponent(driver);
    }

    public AddCenterMainInfoComponent pressBackButton() {
        this.backButton.click();
        return new AddCenterMainInfoComponent(driver);
    }

}