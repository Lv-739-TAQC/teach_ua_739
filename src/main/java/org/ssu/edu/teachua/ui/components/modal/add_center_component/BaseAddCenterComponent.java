package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;

public abstract class BaseAddCenterComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-title')])[1]")
    protected WebElement mainInfo;
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-title')])[2]")
    protected WebElement contacts;
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-title')])[3]")
    protected WebElement description;
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-title')])[4]")
    protected WebElement clubs;
    @FindBy(how = How.XPATH, using = "(.//main[contains(@class, 'add-center-container')]")
    protected WebElement addCenterContainer;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'ant-modal addCenter')]")
    protected WebElement root;
    @FindBy(how = How.XPATH, using = "(.//div[@class='side-mobile']//span[contains(@class,'ant-steps-icon') and text()=1]//parent::div")
    protected WebElement firstStep;
    @FindBy(how = How.XPATH, using = "(.//div[@class='side-mobile']//span[contains(@class,'ant-steps-icon') and text()=2]//parent::div")
    protected WebElement secondStep;
    @FindBy(how = How.XPATH, using = "(.//div[@class='side-mobile']//span[contains(@class,'ant-steps-icon') and text()=3]//parent::div")
    protected WebElement thirdStep;
    @FindBy(how = How.XPATH, using = "(.//div[@class='side-mobile']//span[contains(@class,'ant-steps-icon') and text()=4]//parent::div")
    protected WebElement forthStep;

    public BaseAddCenterComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getMainInfo() {
        return mainInfo;
    }

    public WebElement getContacts() {
        return contacts;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getClubs() {
        return clubs;
    }

    public String getFirstStepColor() {
        String colorCode = firstStep.getCssValue("background-color");
        String hexacolor = Color.fromString(colorCode).asHex();
        return hexacolor;
    }

    public String getSecondStepColor() {
        String colorCode = secondStep.getCssValue("background-color");
        String hexacolor = Color.fromString(colorCode).asHex();
        return hexacolor;
    }

    public String getThirdStepColor() {
        String colorCode = thirdStep.getCssValue("background-color");
        String hexacolor = Color.fromString(colorCode).asHex();
        return hexacolor;
    }

    public String getForthStepColor() {
        String colorCode = forthStep.getCssValue("background-color");
        String hexacolor = Color.fromString(colorCode).asHex();
        return hexacolor;
    }
}
