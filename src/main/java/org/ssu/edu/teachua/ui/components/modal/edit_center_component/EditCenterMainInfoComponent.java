package org.ssu.edu.teachua.ui.components.modal.edit_center_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.AddLocationComponent;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterContactsComponent;
import org.ssu.edu.teachua.ui.components.modal.add_center_component.AddCenterMainInfoComponent;

public class EditCenterMainInfoComponent extends AddCenterMainInfoComponent {

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_name']")
    private WebElement centerName;
    @FindBy(how = How.XPATH, using = ".//span[@class='add-club-location']")
    private WebElement addLocationButton;
    @FindBy(how = How.XPATH, using = ".//span[@aria-label='edit']")
    private WebElement editLocation;
    @FindBy(how = How.XPATH, using = ".//span[@aria-label='delete']")
    private WebElement deleteLocation;
    @FindBy(how = How.XPATH, using = ".//div[@class='ant-popover-message']")
    private WebElement deleteLocationPopUp;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'next-btn')]")
    private WebElement nextStepButton;

    public EditCenterMainInfoComponent(WebDriver driver) {
        super(driver);
    }

    public EditCenterMainInfoComponent enterCenterName(String centerName) {
        this.centerName.click();
        this.centerName.clear();
        this.centerName.sendKeys(centerName);
        return this;
    }

    public AddLocationComponent pressAddLocationButton() {
        addLocationButton.click();
        return new AddLocationComponent(driver, addLocationContainer);
    }

    public AddLocationComponent pressEditLocation() {
        editLocation.click();
        return new AddLocationComponent(driver, addLocationContainer);
    }

    public DeleteLocationComponent pressDeleteLocation() {
        deleteLocation.click();
        return new DeleteLocationComponent(driver, deleteLocationPopUp);
    }

    public AddCenterContactsComponent pressNextButton() {
        this.nextStepButton.click();
        return new AddCenterContactsComponent(driver);
    }

}