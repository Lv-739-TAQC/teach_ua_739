package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;

public class Contacts extends BaseComponent {
    public Contacts(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    @FindBy(how = How.XPATH, using = ".//*[@id='contacts_contactFacebook']")
    private WebElement facebook;

    // @Step("Contacts: add center facebook")
    public Contacts enterCenterFacebook(String centerFacebook) {
        facebook.click();
        facebook.clear();
        facebook.sendKeys(centerFacebook);
        return this;
    }

    @FindBy(how = How.XPATH, using = ".//*[@id='contacts_contactContact']")
    private WebElement site;

    // @Step("Contacts: add center site")
    public Contacts enterCenterSite(String centerSite) {
        site.click();
        site.clear();
        site.sendKeys(centerSite);
        return this;
    }

    @FindBy(how = How.XPATH, using = ".//*[@id='contacts_contactПошта']")
    private WebElement mail;

    // @Step("Contacts: add center e-mail")
    public Contacts enterCenterMail(String centerMail) {
        mail.click();
        mail.clear();
        mail.sendKeys(centerMail);
        return this;
    }

    @FindBy(how = How.XPATH, using = ".//*[@id='contacts_contactSkype']")
    private WebElement skype;

    // @Step("Contacts: add center Skype")
    public Contacts enterCenterSkype(String centerSkype) {
        skype.click();
        skype.clear();
        skype.sendKeys(centerSkype);
        return this;
    }

    @FindBy(how = How.XPATH, using = ".//*[@id='contacts_contactWhatsApp']")
    private WebElement whatsApp;

    // @Step("Contacts: add center What'sApp number")
    public Contacts enterCenterWhatsAppNumber(String centerWhatsApp) {
        whatsApp.click();
        whatsApp.clear();
        whatsApp.sendKeys(centerWhatsApp);
        return this;
    }

    @FindBy(how = How.XPATH, using = ".//*[@id='contacts_contactТелефон']")
    private WebElement phone;

    // @Step("Contacts: add center phone number")
    public Contacts enterPhone(String contactPhone) {
        phone.click();
        phone.clear();
        phone.sendKeys(contactPhone);
        return this;
    }

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'prev-btn')]")
    private WebElement backButton;

    // @Step("Contacts: press back button")
    public Contacts pressBackButton() {
        this.backButton.click();
        return this;
    }

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'next-btn')]")
    private WebElement nextButton;

    // @Step("Contacts: press Next step button")
    public Contacts pressNextButton() {
        this.nextButton.click();
        return this;
    }

}