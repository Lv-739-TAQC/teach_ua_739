package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.AddLocationComponent;

public class AddCenterMainInfoComponent extends BaseAddCenterComponent {

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_name']")
    private WebElement centerName;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'add-location-btn')]")
    private WebElement addLocationButton;

    @FindBy(how = How.XPATH, using = "(.//input[@class='ant-checkbox-input'])[3]")
    private WebElement locationToCheck;

    @FindBy(how = How.XPATH, using = ".//main[contains(@class, 'add-club-container')]")
    protected WebElement addLocationContainer;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'next-btn')]")
    private WebElement nextStepButton;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'explain-error')]")
    private WebElement centerNameError;

    public AddCenterMainInfoComponent(WebDriver driver) {
        super(driver);
    }

    public AddCenterMainInfoComponent enterCenterName(String centerName) {
        this.centerName.click();
        this.centerName.clear();
        this.centerName.sendKeys(centerName);
        return this;
    }

    public AddLocationComponent pressAddLocationButton() {
        addLocationButton.click();
        return new AddLocationComponent(driver, addLocationContainer);
    }

    public AddCenterMainInfoComponent checkLocation() {
        locationToCheck.click();
        return this;
    }

    public AddCenterContactsComponent pressNextButton() {
        this.nextStepButton.click();
        return new AddCenterContactsComponent(driver);
    }

    public String getCenterNameError() {
        return waitForElementToAppear(centerNameError).getText();
    }

}
