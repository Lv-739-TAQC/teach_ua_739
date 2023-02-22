package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;

public class MainInfo extends BaseComponent {
    public MainInfo(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_name']")
    private WebElement centerName;

    //    @Step("Main info: enter the name of the center")
    public MainInfo enterCenterName(String centerName) {
        this.centerName.click();
        this.centerName.clear();
        this.centerName.sendKeys(centerName);
        return this;
    }

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'add-location-btn')]")
    private WebElement addLocationButton;

    // @Step("Main info: press add new location button")
    public MainInfo pressAddLocationButton() {
        addLocationButton.click();
        return this;
    }

    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-checkbox-input'])[3]")
    private WebElement locationToCheck;

    // @Step("Main info: check a location from the list")
    public MainInfo checkLocation() {
        locationToCheck.click();
        return this;
    }

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'next-btn')]")
    private WebElement nextStepButton;

    // @Step("Main info: press Next step button")
    public MainInfo pressNextStepButton() {
        nextStepButton.click();
        return this;
    }

}
