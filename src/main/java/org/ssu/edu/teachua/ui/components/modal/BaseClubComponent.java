package org.ssu.edu.teachua.ui.components.modal;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.ssu.edu.teachua.ui.base.BaseComponent;

public abstract class BaseClubComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'add-club-content-next')]")
    protected WebElement nextStepButton;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'add-club-content-prev')]")
    protected WebElement previousPageButton;
    @FindBy(how = How.XPATH, using = ".//span[@class='ant-input-suffix']//span[@aria-label='check-circle']")
    private WebElement checkCircle;
    @FindBy(how = How.XPATH, using = ".//span[@class='ant-input-textarea-suffix']//span[@aria-label='check-circle']")
    private WebElement areaCheckCircle;
    @FindBy(how = How.XPATH, using = ".//span[@class='ant-input-suffix']//span[@aria-label='close-circle']")
    private WebElement closeCircle;
    @FindBy(how = How.XPATH, using = ".//span[@class='ant-input-textarea-suffix']//span[@aria-label='close-circle']")
    private WebElement areaCloseCircle;
    @FindBy(how = How.XPATH, using = ".//div[@class='ant-form-item-explain-error']")
    private WebElement fieldErrorMsg;
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-active')]//div[text()[contains(., 'Основна інформація')]])[1]")
    private WebElement clubMainInfoComponent;
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-active')]//div[text()[contains(., 'Контакти')]])[1])")
    private WebElement clubContactsComponent;
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-active')]//div[text()[contains(., 'Опис')]])[1]")
    private WebElement clubDescriptionComponent;
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class,'ant-steps-vertical')]//span)[1]")
    private WebElement firstStep;
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class,'ant-steps-vertical')]//span)[2]")
    private WebElement secondStep;
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class,'ant-steps-vertical')]//span)[3]")
    private WebElement thirdStep;


    public BaseClubComponent(WebDriver driver) {

        super(driver);
        componentRoot = driver.findElement(By.xpath("//div[contains(@class, 'ant-modal modal-add-club')]"));
        PageFactory.initElements(new DefaultElementLocatorFactory(componentRoot), this);
    }

    /**
     * This method check the Main Info page of Add Club or Edit Club pop-up is active
     * @return element that method was applied to
     */
    @Step("Check the Main Info page is active")
    public WebElement getClubMainInfoComponent() {
        waitForElementToAppear(clubMainInfoComponent);
        return clubMainInfoComponent;
    }

    /**
     * This method check the Contacts page of Add Club or Edit Club pop-up is active
     * @return element that method was applied to
     */
    @Step("Check the Contacts page is active")
    public WebElement getClubContactsComponent() {
        waitForElementToAppear(clubContactsComponent);
        return clubContactsComponent;
    }

    /**
     * This method check the Description page of Add Club or Edit Club pop-up is active
     * @return element that method was applied to
     */
    @Step("Check the Description page is active")
    public WebElement getClubDescriptionComponent() {
        waitForElementToAppear(clubDescriptionComponent);
        return clubDescriptionComponent;
    }

    /**
     * This method check the 'First step' circle of Add Club or Edit Club pop-up is orange
     * @return color of the circle element in hex format
     */
    @Step("Check the 'First step' circle is orange")
    public String getFirstStepColor() {
        String colorCode = firstStep.getCssValue("background-color");
        String hexacolor = Color.fromString(colorCode).asHex();
        return hexacolor;
    }

    /**
     * This method check the 'Second step' circle of Add Club or Edit Club pop-up is orange
     * @return color of the circle element in hex format
     */
    @Step("Check the 'Second step' circle is orange")
    public String getSecondStepColor() {
        String colorCode = secondStep.getCssValue("background-color");
        String hexacolor = Color.fromString(colorCode).asHex();
        return hexacolor;
    }

    /**
     * This method check the 'Third step' circle of Add Club or Edit Club pop-up is orange
     * @return color of the circle element in hex format
     */
    @Step("Check the 'Third step' circle is orange")
    public String getThirdStepColor() {
        String colorCode = thirdStep.getCssValue("background-color");
        String hexacolor = Color.fromString(colorCode).asHex();
        return hexacolor;
    }

    /**
     * This method checks the green check-circle is appeared near the field with valid data in it
     * @return element that method was applied to
     */
    @Step("Check the check-circle is appear")
    public WebElement getCheckCircle() {
        waitForElementToAppear(checkCircle);
        return checkCircle;
    }

    /**
     * This method checks the red close-circle is appeared near the field with invalid data in it
     * @return element that method was applied to
     */
    @Step("Check the close-circle is appear")
    public WebElement getCloseCircle() {
        waitForElementToAppear(closeCircle);
        return closeCircle;
    }

    /**
     * This method checks the green check-circle is appeared near the text-area-field with valid data in it
     * @return element that method was applied to
     */
    @Step("Check the area check-circle is appear")
    public WebElement getAreaCheckCircle() {
        waitForElementToAppear(areaCheckCircle);
        return areaCheckCircle;
    }

    /**
     * This method checks the red close-circle is appeared near the text-area-field with invalid data in it
     * @return element that method was applied to
     */
    @Step("Check the area close-circle is appear")
    public WebElement getAreaCloseCircle() {
        waitForElementToAppear(areaCloseCircle);
        return areaCloseCircle;
    }

    /**
     * This method checks the error message is appeared near the field with invalid data in it
     * @return element that method was applied to
     */
    @Step("Check the error message is appear")
    public WebElement getFieldErrorMsg() {
        waitForElementToAppear(fieldErrorMsg);
        return fieldErrorMsg;
    }
}
