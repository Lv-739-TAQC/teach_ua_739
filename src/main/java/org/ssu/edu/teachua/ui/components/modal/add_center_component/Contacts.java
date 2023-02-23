package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Contacts extends BaseAddCenterComponent {
    public Contacts(WebDriver driver, WebElement node) {
        super(driver, node);
    }

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


    // @Step("Contacts: add center facebook")
    public Contacts enterCenterFacebook(String centerFacebook) {
        facebook.click();
        facebook.clear();
        facebook.sendKeys(centerFacebook);
        return this;
    }

    // @Step("Contacts: add center site")
    public Contacts enterCenterSite(String centerSite) {
        site.click();
        site.clear();
        site.sendKeys(centerSite);
        return this;
    }

    // @Step("Contacts: add center e-mail")
    public Contacts enterCenterMail(String centerMail) {
        mail.click();
        mail.clear();
        mail.sendKeys(centerMail);
        return this;
    }

    // @Step("Contacts: add center Skype")
    public Contacts enterCenterSkype(String centerSkype) {
        skype.click();
        skype.clear();
        skype.sendKeys(centerSkype);
        return this;
    }

    // @Step("Contacts: add center What'sApp number")
    public Contacts enterCenterWhatsAppNumber(String centerWhatsApp) {
        whatsApp.click();
        whatsApp.clear();
        whatsApp.sendKeys(centerWhatsApp);
        return this;
    }

    // @Step("Contacts: add center phone number")
    public Contacts enterPhone(String contactPhone) {
        phone.click();
        phone.clear();
        phone.sendKeys(contactPhone);
        return this;
    }

    // @Step("Contacts: Press Next step button")
    public Description pressNextButton() {
        this.nextStepButton.click();
        return new Description(driver, addCenterContainer);
    }

    // @Step("Contacts: Press Back button")
    public MainInfo pressBackButton() {
        this.backButton.click();
        return new MainInfo(driver, addCenterContainer);
    }

}