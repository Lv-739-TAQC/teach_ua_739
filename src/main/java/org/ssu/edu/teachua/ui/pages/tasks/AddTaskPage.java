package org.ssu.edu.teachua.ui.pages.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.date_picker.SelectDateComponent;
import org.ssu.edu.teachua.ui.pages.view.ViewTaskPage;

public class AddTaskPage extends BasePage {

    protected static final String CHALLENGE_NAME_XPATH = "//div[@class='ant-select-item-option-content' and text()='%s']";

    @FindBy(how = How.XPATH, using = "//input[@id='startDate']")
    protected WebElement startDateInput;

    @FindBy(how = How.XPATH, using = "//input[@id='picture']")
    protected WebElement photoInput;

    @FindBy(how = How.XPATH, using = "//input[@id='name']")
    protected WebElement nameInput;

    @FindBy(how = How.XPATH, using = "//label[text()='Заголовок']//parent::div//following-sibling::div//div[contains(@class, 'ql-editor')]/p")
    protected WebElement titleInput;

    @FindBy(how = How.XPATH, using = "//label[text()='Опис']//parent::div//following-sibling::div//div[contains(@class, 'ql-editor')]/p")
    protected WebElement descriptionInput;

    @FindBy(how = How.XPATH, using = "//input[@id='challengeId']")
    protected WebElement challengeDropdown;

    @FindBy(how = How.XPATH, using = "//span[text()='Зберегти']//parent::button")
    protected WebElement saveBtn;

    public AddTaskPage(WebDriver driver) {
        super(driver);
    }

    public AddTaskPage selectStartDate(int day, int month, int year) {
        waitForElementToAppear(startDateInput).click();
        WebElement selectDateNode = driver.findElement(By.xpath("//div[contains(@class, 'ant-picker-dropdown')]"));
        new SelectDateComponent(driver, selectDateNode).selectDate(day, month, year);
        return this;
    }

    public AddTaskPage uploadPhoto(String photoPath) {
        waitForElementToAppear(photoInput).sendKeys(photoPath);
        return this;
    }

    public AddTaskPage typeName(String name) {
        waitForElementToAppear(nameInput).sendKeys(name);
        return this;
    }

    public AddTaskPage typeTitle(String title) {
        waitForElementToAppear(titleInput).sendKeys(title);
        return this;
    }

    public AddTaskPage typeDescription(String title) {
        waitForElementToAppear(descriptionInput).sendKeys(title);
        return this;
    }

    public AddTaskPage selectChallenge(String challenge) {
        waitForElementToAppear(challengeDropdown).click();
        waitForElementToAppear(driver.findElement(By.xpath(String.format(CHALLENGE_NAME_XPATH, challenge)))).click();
        return this;
    }

    public void clickSaveButton() {
        waitForElementToAppear(saveBtn).click();
    }
}
