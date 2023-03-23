/**
 * package contains classes
 * related to new center creation functionality
 */

package org.ssu.edu.teachua.ui.components.modal.edit_center_component;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterContactsComponent;

/**
 * class contains attributes and methods
 * related to editing all contact data for a center,
 * navigation to the next and previous pages
 */
public class EditCenterContactsComponent extends AddCenterContactsComponent {

    /**
     * locator for the Facebook field
     */
    @FindBy(how = How.XPATH, using = ".//input[@name='Facebook']")
    private WebElement facebook;

    /**
     * locator for the website field
     */
    @FindBy(how = How.XPATH, using = ".//input[@name='Contact']")
    private WebElement site;

    /**
     * locator for the E-mail field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='contacts_contactПошта']")
    private WebElement mail;

    /**
     * locator for the Skype field
     */
    @FindBy(how = How.XPATH, using = ".//input[@name='Skype']")
    private WebElement skype;

    /**
     * locator for the What's Up field
     */
    @FindBy(how = How.XPATH, using = ".//input[@name='WhatsApp']")
    private WebElement whatsApp;

    /**
     * locator for the contact phone number field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='contacts_contactТелефон']")
    private WebElement phone;

    /**
     * locator for the next page button
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'next-btn')]")
    private WebElement nextStepButton;

    /**
     * locator for the previous page button
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'prev-btn')]")
    private WebElement backButton;

    /**
     * creation constructor matching super
     *
     * @param driver instance
     */
    public EditCenterContactsComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * edit center Facebook
     *
     * @param centerFacebook - Facebook page of the center
     */
    @Step("Edit center Facebook {centerFacebook}")
    public EditCenterContactsComponent enterCenterFacebook(String centerFacebook) {
        facebook.click();
        facebook.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        facebook.sendKeys(centerFacebook);
        return this;
    }

    /**
     * edit center site
     *
     * @param centerSite - website of the center
     */
    @Step("Edit center site {centerSite}")
    public EditCenterContactsComponent enterCenterSite(String centerSite) {
        site.click();
        site.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        site.sendKeys(centerSite);
        return this;
    }

    /**
     * edit center E-mail
     *
     * @param centerMail - E-mail address of the center
     */
    @Step("Edit center e-mail {centerEmail}")
    public EditCenterContactsComponent enterCenterMail(String centerMail) {
        mail.click();
        mail.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        mail.sendKeys(centerMail);
        return this;
    }

    /**
     * edit center Skype
     *
     * @param centerSkype - Skype of the center
     */
    @Step("Edit center Skype {centerSkype}")
    public EditCenterContactsComponent enterCenterSkype(String centerSkype) {
        skype.click();
        skype.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        skype.sendKeys(centerSkype);
        return this;
    }

    /**
     * edit center What's Up
     *
     * @param centerWhatsApp - What's up contact of the center
     */
    @Step("Edit center What'sApp {centerWhatsUp}")
    public EditCenterContactsComponent enterCenterWhatsAppNumber(String centerWhatsApp) {
        whatsApp.click();
        whatsApp.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        whatsApp.sendKeys(centerWhatsApp);
        return this;
    }

    /**
     * edit center contact phone number
     *
     * @param contactPhone - contact phone number of the center
     */
    @Step("Edit center phone {centerPhone}")
    public EditCenterContactsComponent enterPhone(String contactPhone) {
        phone.click();
        phone.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        phone.sendKeys(contactPhone);
        return this;
    }

    /**
     * click navigation to the next page button
     *
     * @return opened {@link EditCenterDescriptionComponent}
     */
    @Step("Press 'Наступний крок' button")
    public EditCenterDescriptionComponent pressNextButton() {
        this.nextStepButton.click();
        return new EditCenterDescriptionComponent(driver);
    }

    /**
     * click navigation to the previous page button
     *
     * @return opened {@link EditCenterMainInfoComponent}
     */
    @Step("Press 'Назад' button")
    public EditCenterMainInfoComponent pressBackButton() {
        this.backButton.click();
        return new EditCenterMainInfoComponent(driver);
    }

}
