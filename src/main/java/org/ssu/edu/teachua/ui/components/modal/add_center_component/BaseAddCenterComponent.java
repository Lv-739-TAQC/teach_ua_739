/**
 * package contains classes
 * related to new center creation functionality
 */

package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;

/**
 * class contains attributes and methods
 * related to adding a center sidebar
 */
public abstract class BaseAddCenterComponent extends BaseComponent {

    /**
     * locator for the Main Information step text
     */
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-title')])[1]")
    protected WebElement mainInfo;

    /**
     * locator for the Contacts step text
     */
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-title')])[2]")
    protected WebElement contacts;

    /**
     * locator for the Description step text
     */
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-title')])[3]")
    protected WebElement description;

    /**
     * locator for the Clubs step text
     */
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-title')])[4]")
    protected WebElement clubs;

    /**
     * locator for the add center container
     */
    @FindBy(how = How.XPATH, using = "(.//main[contains(@class, 'add-center-container')]")
    protected WebElement addCenterContainer;

    /**
     * locator for the add center root element
     */
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'ant-modal addCenter')]")
    protected WebElement root;

    /**
     * locator for the first step (Main Information) color
     */
    @FindBy(how = How.XPATH, using = "(.//div[@class='side-mobile']//span[contains(@class,'ant-steps-icon') and text()=1]//parent::div")
    protected WebElement firstStep;

    /**
     * locator for the second step (Contacts) color
     */
    @FindBy(how = How.XPATH, using = "(.//div[@class='side-mobile']//span[contains(@class,'ant-steps-icon') and text()=2]//parent::div")
    protected WebElement secondStep;

    /**
     * locator for the third step (Description) color
     */
    @FindBy(how = How.XPATH, using = "(.//div[@class='side-mobile']//span[contains(@class,'ant-steps-icon') and text()=3]//parent::div")
    protected WebElement thirdStep;

    /**
     * locator for the fourth step (Clubs) color
     */
    @FindBy(how = How.XPATH, using = "(.//div[@class='side-mobile']//span[contains(@class,'ant-steps-icon') and text()=4]//parent::div")
    protected WebElement forthStep;

    /**
     * creation constructor matching super
     */
    public BaseAddCenterComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * getter for the Main Information step text
     */
    public WebElement getMainInfo() {
        return mainInfo;
    }

    /**
     * getter for the Contacts step text
     */
    public WebElement getContacts() {
        return contacts;
    }

    /**
     * getter for the Description step text
     */
    public WebElement getDescription() {
        return description;
    }

    /**
     * getter for the Clubs step text
     */
    public WebElement getClubs() {
        return clubs;
    }

    /**
     * getting the color of the first step - Main Information
     *
     * @return hex value of the color
     */
    @Step("Get the color of the first step - 'Основна інформація'")
    public String getFirstStepColor() {
        String colorCode = firstStep.getCssValue("background-color");
        String hexacolor = Color.fromString(colorCode).asHex();
        return hexacolor;
    }

    /**
     * getting the color of the second step - Contacts
     *
     * @return hex value of the color
     */
    @Step("Get the color of the second step - 'Контакти'")
    public String getSecondStepColor() {
        String colorCode = secondStep.getCssValue("background-color");
        String hexacolor = Color.fromString(colorCode).asHex();
        return hexacolor;
    }

    /**
     * getting the color of the third step - Description
     *
     * @return hex value of the color
     */
    @Step("Get the color of the third step - 'Опис'")
    public String getThirdStepColor() {
        String colorCode = thirdStep.getCssValue("background-color");
        String hexacolor = Color.fromString(colorCode).asHex();
        return hexacolor;
    }

    /**
     * getting the color of the forth step - Clubs
     *
     * @return hex value of the color
     */
    @Step("Get the color of the forth step - 'Гуртки'")
    public String getForthStepColor() {
        String colorCode = forthStep.getCssValue("background-color");
        String hexacolor = Color.fromString(colorCode).asHex();
        return hexacolor;
    }
}
