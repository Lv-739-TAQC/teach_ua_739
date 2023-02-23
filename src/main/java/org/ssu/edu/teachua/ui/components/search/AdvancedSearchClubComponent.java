package org.ssu.edu.teachua.ui.components.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AdvancedSearchClubComponent extends AdvancedSearchCenterComponent{

    @FindBy(how = How.XPATH, using = ".//input[@type='checkbox']")
    private WebElement remote;

    @FindBy(how = How.XPATH, using = ".//input[@role='spinbutton']")
    private WebElement ageField;

    public AdvancedSearchClubComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public void chooseRemote() {
        remote.click();
    }

    public void chooseCategory(String category){
        driver.findElement(By.xpath(String.format(".//input[@value='%s']", category))).click();
    }

    public AdvancedSearchClubComponent setAge(int age){
        ageField.sendKeys(Integer.toString(age));
        return this;
    }
}
