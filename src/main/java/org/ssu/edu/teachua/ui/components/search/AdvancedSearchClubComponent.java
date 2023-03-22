package org.ssu.edu.teachua.ui.components.search;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * This class contains elements and methods that describe
 * the functionality of advanced search component when Club radio button is selected
 */
public class AdvancedSearchClubComponent extends AdvancedSearchCenterComponent {

    /**
     * WebElement for Remote checkbox
     */
    @FindBy(how = How.XPATH, using = ".//input[@type='checkbox']")
    private WebElement remote;

    /**
     * WebElement for Age field
     */
    @FindBy(how = How.XPATH, using = ".//input[@role='spinbutton']")
    private WebElement ageField;

    /**
     * Constructs a new AdvancedSearchClubComponent with the specified WebDriver.
     * @param driver the WebDriver object used to interact with the web browser
     */
    public AdvancedSearchClubComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * Method for access ageField WebElement
     * @return ageField WebElement
     */
    public WebElement ageField() {
        return ageField;
    }

    /**
     * Click on remote checkbox
     */
    @Step("Click remote button")
    public void chooseRemote() {
        remote.click();
    }

    /**
     * Click on category checkbox
     * @param category is String used in XPath to find category
     */
    @Step("Click category {category} ")
    public void chooseCategory(String category) {
        driver.findElement(By.xpath(String.format(".//input[@value='%s']", category))).click();
    }

    /**
     * @return entered int number from age field
     */
    public String getAge() {
        return ageField.getAttribute("value");
    }

    /**
     * Method to enter age in age field
     * @param age
     * @return advanced search club component with entered age
     */
    @Step("Type {age} into age field")
    public AdvancedSearchClubComponent setAge(String age) {
        waitForElementToBeClickable(ageField).click();
        ageField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        ageField.sendKeys(age);
        return this;
    }

    /**
     * Method to clear age field
     * @return advanced search club component without entered age
     */
    @Step("Clear age field")
    public AdvancedSearchClubComponent clearAge() {
        waitForElementToBeClickable(ageField()).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }
}
