package org.ssu.edu.teachua.ui.pages.tasks;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.date_picker.SelectDateComponent;

public class EditTaskPage extends AddTaskPage {

    @FindBy(how = How.XPATH, using = "//input[@name='startDate']")
    private WebElement startDateInput;

    public EditTaskPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select date with '{day}' day, '{month}' month and '{year}' year into task start date field")
    @Override
    public AddTaskPage selectStartDate(int day, int month, int year) {
        waitForElementToAppear(startDateInput).click();
        WebElement selectDateNode = waitForElementToAppear(driver.findElement(By.xpath("//div[contains(@class, 'ant-picker-dropdown')]")));
        new SelectDateComponent(driver, selectDateNode).selectDate(day, month, year);
        return this;
    }

    @Step("Type '{name}' into task name field")
    @Override
    public AddTaskPage typeName(String name) {
        waitForElementToAppear(nameInput).click();
        nameInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        return super.typeName(name);
    }

    @Step("Type '{title}' into task title field")
    @Override
    public AddTaskPage typeTitle(String title) {
        waitForElementToAppear(titleInput).clear();
        return super.typeTitle(title);
    }

    @Step("Type '{description}' into task description field")
    @Override
    public AddTaskPage typeDescription(String description) {
        waitForElementToAppear(descriptionInput).clear();
        return super.typeDescription(description);
    }

    @Step("Select '{challenge}' into task from challenge dropdown")
    @Override
    public AddTaskPage selectChallenge(String challenge) {
        actions.moveToElement(waitForElementToAppear(challengeDropdown)).click().perform();
        waitForElementToAppear(driver.findElement(By.xpath(String.format(CHALLENGE_NAME_XPATH, challenge)))).click();
        return this;
    }
}
