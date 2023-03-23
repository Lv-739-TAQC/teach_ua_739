/**
 * package contains classes
 * related to new center creation functionality
 */

package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * class contains attributes and methods
 * related to adding all contact data while creating a center,
 * navigation to the next and previous pages
 */
public class AddCenterContactsComponent extends BaseAddCenterComponent {

    /**
     * locator for the Facebook field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='contacts_contactFacebook']")
    private WebElement facebook;

    /**
     * locator for the website field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='contacts_contactContact']")
    private WebElement site;

    /**
     * locator for the E-mail field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='contacts_contactПошта']")
    private WebElement mail;

    /**
     * locator for the Skype field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='contacts_contactSkype']")
    private WebElement skype;

    /**
     * locator for the What's Up field
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='contacts_contactWhatsApp']")
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
    public AddCenterContactsComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * enter center Facebook
     *
     * @param centerFacebook - Facebook page of the center
     * @return current page
     */
    @Step("Enter center Facebook {centerFacebook}")
    public AddCenterContactsComponent enterCenterFacebook(String centerFacebook) {
        facebook.click();
        facebook.clear();
        facebook.sendKeys(centerFacebook);
        return this;
    }

    /**
     * enter center site
     *
     * @param centerSite - website of the center
     * @return current page
     */
    @Step("Enter center site {centerSite}")
    public AddCenterContactsComponent enterCenterSite(String centerSite) {
        site.click();
        site.clear();
        site.sendKeys(centerSite);
        return this;
    }

    /**
     * enter center E-mail
     *
     * @param centerMail - E-mail address of the center
     * @return current page
     */
    @Step("Enter center e-mail {centerEmail}")
    public AddCenterContactsComponent enterCenterMail(String centerMail) {
        mail.click();
        mail.clear();
        mail.sendKeys(centerMail);
        return this;
    }

    /**
     * enter center Skype
     *
     * @param centerSkype - Skype of the center
     * @return current page
     */
    @Step("Enter center Skype {centerSkype}")
    public AddCenterContactsComponent enterCenterSkype(String centerSkype) {
        skype.click();
        skype.clear();
        skype.sendKeys(centerSkype);
        return this;
    }

    /**
     * enter center What's Up
     *
     * @param centerWhatsApp - What's up contact of the center
     * @return current page
     */
    @Step("Enter center What's App {centerWhatsApp}")
    public AddCenterContactsComponent enterCenterWhatsAppNumber(String centerWhatsApp) {
        whatsApp.click();
        whatsApp.clear();
        whatsApp.sendKeys(centerWhatsApp);
        return this;
    }

    /**
     * enter center contact phone number
     *
     * @param contactPhone - contact phone number of the center
     * @return current page
     */
    @Step("Enter center phone number {centerPhone}")
    public AddCenterContactsComponent enterPhone(String contactPhone) {
        phone.click();
        phone.clear();
        phone.sendKeys(contactPhone);
        return this;
    }

    /**
     * click navigation to the next page button
     *
     * @return opened {@link AddCenterDescriptionComponent}
     */
    @Step("Press 'Наступний крок' button")
    public AddCenterDescriptionComponent pressNextButton() {
        this.nextStepButton.click();
        return new AddCenterDescriptionComponent(driver);
    }

    /**
     * click navigation to the previous page button
     *
     * @return opened {@link AddCenterMainInfoComponent}
     */
    @Step("Press 'Назад' button")
    public AddCenterMainInfoComponent pressBackButton() {
        this.backButton.click();
        return new AddCenterMainInfoComponent(driver);
    }

}