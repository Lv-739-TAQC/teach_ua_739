package org.ssu.edu.teachua.ui.components.modal.edit_center_component;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterContactsComponent;

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

    @Step("Edit center Facebook")
    public EditCenterContactsComponent enterCenterFacebook(String centerFacebook) {
        facebook.click();
        facebook.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        facebook.sendKeys(centerFacebook);
        return this;
    }

    @Step("Edit center site")
    public EditCenterContactsComponent enterCenterSite(String centerSite) {
        site.click();
        site.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        site.sendKeys(centerSite);
        return this;
    }

    @Step("Edit center e-mail")
    public EditCenterContactsComponent enterCenterMail(String centerMail) {
        mail.click();
        mail.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        mail.sendKeys(centerMail);
        return this;
    }

    @Step("Edit center Skype")
    public EditCenterContactsComponent enterCenterSkype(String centerSkype) {
        skype.click();
        skype.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        skype.sendKeys(centerSkype);
        return this;
    }

    @Step("Edit center What'sApp")
    public EditCenterContactsComponent enterCenterWhatsAppNumber(String centerWhatsApp) {
        whatsApp.click();
        whatsApp.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        whatsApp.sendKeys(centerWhatsApp);
        return this;
    }

    @Step("Edit center phone")
    public EditCenterContactsComponent enterPhone(String contactPhone) {
        phone.click();
        phone.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        phone.sendKeys(contactPhone);
        return this;
    }

    @Step("Press 'Наступний крок' button")
    public EditCenterDescriptionComponent pressNextButton() {
        this.nextStepButton.click();
        return new EditCenterDescriptionComponent(driver);
    }

    @Step("Press 'Назад' button")
    public EditCenterMainInfoComponent pressBackButton() {
        this.backButton.click();
        return new EditCenterMainInfoComponent(driver);
    }

}
