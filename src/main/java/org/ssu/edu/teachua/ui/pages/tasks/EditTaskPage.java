package org.ssu.edu.teachua.ui.pages.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.date_picker.SelectDateComponent;

public class EditTaskPage extends AddTaskPage{

    @FindBy(how = How.XPATH, using = "//input[@name='startDate']")
    private WebElement startDateInput;

    public EditTaskPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AddTaskPage selectStartDate(int day, int month, int year) {
        startDateInput.click();
        WebElement selectDateNode = driver.findElement(By.xpath("//div[contains(@class, 'ant-picker-dropdown')]"));
        new SelectDateComponent(driver, selectDateNode).selectDate(day, month, year);
        return this;
    }

    @Override
    public AddTaskPage typeName(String name) {
        nameInput.clear();
        return super.typeName(name);
    }

    @Override
    public AddTaskPage typeTitle(String title) {
        titleInput.clear();
        return super.typeTitle(title);
    }

    @Override
    public AddTaskPage typeDescription(String title) {
        descriptionInput.clear();
        return super.typeDescription(title);
    }

    @Override
    public AddTaskPage selectChallenge(String challenge) {
        Actions act =  new Actions(driver);
        act.moveToElement(challengeDropdown).click().perform();
        driver.findElement(By.xpath(String.format(CHALLENGE_NAME_XPATH, challenge))).click();
        return this;
    }
}
