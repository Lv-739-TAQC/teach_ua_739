package org.ssu.edu.teachua.ui.components.search;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdvancedSearchClubComponent extends AdvancedSearchCenterComponent {

    @FindBy(how = How.XPATH, using = ".//input[@type='checkbox']")
    private WebElement remote;

    @FindBy(how = How.XPATH, using = ".//input[@role='spinbutton']")
    private WebElement ageField;

    public AdvancedSearchClubComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Click remote button")
    public void chooseRemote() {
        remote.click();
    }

    @Step("Click category {category} ")
    public void chooseCategory(String category) {
        driver.findElement(By.xpath(String.format(".//input[@value='%s']", category))).click();
    }

    public String getAge() {
        return ageField.getAttribute("value");
    }

    @Step("Type {age} into age field")
    public AdvancedSearchClubComponent setAge(String age) {
        waitForElementToBeClickable(ageField).click();
        ageField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        ageField.sendKeys(age);
        return this;
    }
}
