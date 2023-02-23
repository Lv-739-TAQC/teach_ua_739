package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.AddLocationComponent;

public class AddCenterMainInfoComponent extends BaseAddCenterComponent {
    public AddCenterMainInfoComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_name']")
    private WebElement centerName;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'add-location-btn')]")
    private WebElement addLocationButton;

    @FindBy(how = How.XPATH, using = "(.//input[@class='ant-checkbox-input'])[3]")
    private WebElement locationToCheck;

    @FindBy(how = How.XPATH, using = ".//main[contains(@class, 'add-club-container')]")
    private WebElement addLocationContainer;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'next-btn')]")
    private WebElement nextStepButton;


    // @Step("Main info: enter the name of the center")
    public AddCenterMainInfoComponent enterCenterName(String centerName) {
        this.centerName.click();
        this.centerName.clear();
        this.centerName.sendKeys(centerName);
        return this;
    }

    // @Step("Main info: press add new location button")
    public AddLocationComponent pressAddLocationButton() {
        addLocationButton.click();
        return new AddLocationComponent(driver, addLocationContainer);
    }

    // @Step("Main info: check a location from the list")
    public AddCenterMainInfoComponent checkLocation() {
        locationToCheck.click();
        return this;
    }

    // @Step("Main info: Press Next step button")
    public AddCenterContactsComponent pressNextButton() {
        this.nextStepButton.click();
        return new AddCenterContactsComponent(driver, addCenterContainer);
    }

}
