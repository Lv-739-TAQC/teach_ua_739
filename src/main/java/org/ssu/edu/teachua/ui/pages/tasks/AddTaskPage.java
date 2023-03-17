package org.ssu.edu.teachua.ui.pages.tasks;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.date_picker.SelectDateComponent;
import org.ssu.edu.teachua.ui.pages.view.ViewChallengePage;

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

    @FindBy(how = How.XPATH, using = "//div[@class='ant-message-custom-content ant-message-success']")
    private WebElement successMessage;

    @FindBy(how = How.XPATH, using = "//*[@class='ant-message']")
    private WebElement errorMessage;

    public AddTaskPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select date with '{day}' day, '{month}' month and '{year}' year into task start date field")
    public AddTaskPage selectStartDate(int day, int month, int year) {
        waitForElementToAppear(startDateInput).click();
        WebElement selectDateNode = driver.findElement(By.xpath("//div[contains(@class, 'ant-picker-dropdown')]"));
        new SelectDateComponent(driver, selectDateNode).selectDate(day, month, year);
        return this;
    }

    @Step("Upload photo from '{photoPath}' into task photo field")
    public AddTaskPage uploadPhoto(String photoPath) {
        waitForElementToAppear(photoInput).sendKeys(photoPath);
        return this;
    }

    @Step("Type '{name}' into task name field")
    public AddTaskPage typeName(String name) {
        waitForElementToAppear(nameInput).sendKeys(name);
        return this;
    }

    @Step("Type '{title}' into task title field")
    public AddTaskPage typeTitle(String title) {
        waitForElementToAppear(titleInput).sendKeys(title);
        return this;
    }

    @Step("Type '{description}' into task description field")
    public AddTaskPage typeDescription(String description) {
        waitForElementToAppear(descriptionInput).sendKeys(description);
        return this;
    }

    @Step("Select '{challenge}' into task from challenge dropdown")
    public AddTaskPage selectChallenge(String challenge) {
        waitForElementToAppear(challengeDropdown).click();
        waitForElementToAppear(driver.findElement(By.xpath(String.format(CHALLENGE_NAME_XPATH, challenge)))).click();
        return this;
    }

    @Step("Click save button and return ViewTaskPage")
    public ViewChallengePage clickSuccessSaveButton() {
        waitForElementToAppear(saveBtn).click();
        return new ViewChallengePage(driver);
    }
    @Step("Click save button and return AddTaskPage")
    public AddTaskPage clickFailSaveButton() {
        waitForElementToAppear(saveBtn).click();
        return this;
    }

    @Step("Get success message")
    public String checkSuccessMessage() {
        return waitForElementToAppear(successMessage).getText();
    }

    @Step("Get error message")
    public String checkErrorMessage() {
        return waitForElementToAppear(errorMessage).getText();
    }
}
