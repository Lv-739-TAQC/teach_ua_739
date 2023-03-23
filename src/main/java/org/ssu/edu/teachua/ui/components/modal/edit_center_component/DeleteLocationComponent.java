/**
 * package contains classes
 * related to edit center functionality
 */

package org.ssu.edu.teachua.ui.components.modal.edit_center_component;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.AddLocationComponent;

/**
 * class contains attributes and methods
 * related to deleting location for a center
 */
public class DeleteLocationComponent extends AddLocationComponent {

    /**
     * locator for cancel location deletion button
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'cancel-button')]")
    private WebElement cancelDeleteLocation;

    /**
     * locator for confirmation location deletion button
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'ok-button')]")
    private WebElement confirmDeleteLocation;

    /**
     * creation constructor matching super
     *
     * @param driver instance
     */
    public DeleteLocationComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    /**
     * click confirm location deletion button
     *
     * @return opened {@link EditCenterMainInfoComponent}
     */
    @Step("Confirm location deletion")
    public EditCenterMainInfoComponent confirmDeleteLocation() {
        confirmDeleteLocation.click();
        return new EditCenterMainInfoComponent(driver);
    }

    /**
     * click cancel location deletion button
     *
     * @return opened {@link EditCenterMainInfoComponent}
     */
    @Step("Cancel location deletion")
    public EditCenterMainInfoComponent cancelDeleteLocation() {
        cancelDeleteLocation.click();
        return new EditCenterMainInfoComponent(driver);
    }

}
