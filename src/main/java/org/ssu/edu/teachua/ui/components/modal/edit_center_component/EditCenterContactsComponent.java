package org.ssu.edu.teachua.ui.components.modal.edit_center_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterContactsComponent;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterDescriptionComponent;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterMainInfoComponent;

public class EditCenterContactsComponent extends AddCenterContactsComponent {
    @FindBy(how = How.XPATH, using = ".//input[@name='Facebook']")
    private WebElement facebook;
    @FindBy(how = How.XPATH, using = ".//input[@name='Contact']")
    private WebElement site;
    @FindBy(how = How.XPATH, using = ".//input[@id='contacts_contactПошта']")
    private WebElement mail;
    @FindBy(how = How.XPATH, using = ".//input[@name='Skype']")
    private WebElement skype;
    @FindBy(how = How.XPATH, using = ".//input[@name='WhatsApp']")
    private WebElement whatsApp;
    @FindBy(how = How.XPATH, using = ".//input[@id='contacts_contactТелефон']")
    private WebElement phone;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'next-btn')]")
    private WebElement nextStepButton;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'prev-btn')]")
    private WebElement backButton;

    public EditCenterContactsComponent(WebDriver driver) {
        super(driver);
    }

    public EditCenterContactsComponent enterCenterFacebook(String centerFacebook) {
        facebook.click();
        facebook.clear();
        facebook.sendKeys(centerFacebook);
        return this;
    }

    public EditCenterContactsComponent enterCenterSite(String centerSite) {
        site.click();
        site.clear();
        site.sendKeys(centerSite);
        return this;
    }

    public EditCenterContactsComponent enterCenterMail(String centerMail) {
        mail.click();
        mail.clear();
        mail.sendKeys(centerMail);
        return this;
    }

    public EditCenterContactsComponent enterCenterSkype(String centerSkype) {
        skype.click();
        skype.clear();
        skype.sendKeys(centerSkype);
        return this;
    }

    public EditCenterContactsComponent enterCenterWhatsAppNumber(String centerWhatsApp) {
        whatsApp.click();
        whatsApp.clear();
        whatsApp.sendKeys(centerWhatsApp);
        return this;
    }

    public EditCenterContactsComponent enterPhone(String contactPhone) {
        phone.click();
        phone.clear();
        phone.sendKeys(contactPhone);
        return this;
    }

    public EditCenterDescriptionComponent pressNextButton() {
        this.nextStepButton.click();
        return new EditCenterDescriptionComponent(driver);
    }

    public EditCenterMainInfoComponent pressBackButton() {
        this.backButton.click();
        return new EditCenterMainInfoComponent(driver);
    }

}
