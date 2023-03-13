package org.ssu.edu.teachua.ui.components.modal.edit_center_component;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.AddLocationComponent;

public class DeleteLocationComponent extends AddLocationComponent {

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'cancel-button')]")
    private WebElement cancelDeleteLocation;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'ok-button')]")
    private WebElement confirmDeleteLocation;

    public DeleteLocationComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    @Step("Confirm location deletion")
    public EditCenterMainInfoComponent confirmDeleteLocation() {
        confirmDeleteLocation.click();
        return new EditCenterMainInfoComponent(driver);
    }

    @Step("Cancel location deletion")
    public EditCenterMainInfoComponent cancelDeleteLocation() {
        cancelDeleteLocation.click();
        return new EditCenterMainInfoComponent(driver);
    }

}
