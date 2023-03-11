package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.AddLocationComponent;

import java.util.List;

public class AddCenterMainInfoComponent extends BaseAddCenterComponent {

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'location-list')]")
    protected WebElement locationList;
    @FindBy(how = How.XPATH, using = ".//div[@id='basic_locations']//label")
    protected List<WebElement> locationsName;
    @FindBy(how = How.XPATH, using = "//div[@class='ant-modal modal-add-club']")
    protected WebElement addLocationContainer;
    @FindBy(how = How.XPATH, using = ".//input[@id='basic_name']")
    private WebElement centerName;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'add-location-btn')]")
    private WebElement addLocationButton;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'next-btn')]")
    private WebElement nextStepButton;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'explain-error')]")
    private WebElement centerNameError;

    public AddCenterMainInfoComponent(WebDriver driver) {
        super(driver);
    }
    @Step("Enter center name")
    public AddCenterMainInfoComponent enterCenterName(String centerName) {
        this.centerName.click();
        this.centerName.clear();
        this.centerName.sendKeys(centerName);
        return this;
    }

    @Step("Click 'Додати локацію' button")
    public AddLocationComponent pressAddLocationButton() {
        addLocationButton.click();
        return new AddLocationComponent(driver, addLocationContainer);
    }

    @Step("Tick a location")
    public AddCenterMainInfoComponent checkLocation(int numberLocation) {
        WebElement checkBoxLocation = driver.findElement(By.xpath(
                String.format(".//div[@id='basic_locations']//div[@class='checkbox-item'][%d]/label", numberLocation)));
        checkBoxLocation.click();
        return this;
    }

    @Step("Press 'Наступний крок' button")
    public AddCenterContactsComponent pressNextButton() {
        this.nextStepButton.click();
        return new AddCenterContactsComponent(driver);
    }

    public String getCenterNameError() {
        return waitForElementToAppear(centerNameError).getText();
    }

    @Step("Locate a just created location in the list")
    public String getNameNewLocation() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locationList);
        int lengthList = waitForElementsToAppear(locationsName).size();
        return waitForElementsToAppear(locationsName).get(lengthList - 1).getText();
    }

}
