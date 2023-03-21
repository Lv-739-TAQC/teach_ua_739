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
import org.ssu.edu.teachua.ui.pages.view.ViewTaskPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTaskPage extends BasePage {

    protected static final String CHALLENGE_NAME_XPATH = "//div[@class='ant-select-item-option-content' and text()='%s']";

    @FindBy(how = How.XPATH, using = "//input[@id='startDate']")
    protected WebElement startDateInput;

    @FindBy(how = How.XPATH, using = "//input[@id='picture']")
    protected WebElement photoInput;

    @FindBy(how = How.XPATH, using = "//div[@class='ant-upload-list-picture-card-container']")
    protected WebElement photoAppeared;

    @FindBy(how = How.XPATH, using = "//input[@id='name']")
    protected WebElement nameInput;

    @FindBy(how = How.XPATH, using = "//label[text()='Заголовок']//parent::div//following-sibling::div//div[contains(@class, 'ql-editor')]/p")
    protected WebElement titleInput;

    @FindBy(how = How.XPATH, using = "//label[text()='Опис']//parent::div//following-sibling::div//div[contains(@class, 'ql-editor')]/p")
    protected WebElement descriptionInput;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'ant-col-14')]//div[@class='ant-select-selector']")
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

    /**
     * select date for future task
     * @param day - day of task
     * @param month - month of task
     * @param year - year of task
     * @return AddTaskPage with selected date
     */
    @Step("Select date with '{day}' day, '{month}' month and '{year}' year into task start date field")
    public AddTaskPage selectStartDate(int day, int month, int year) {
        waitForElementToAppear(startDateInput).click();
        WebElement selectDateNode = driver.findElement(By.xpath("//div[contains(@class, 'ant-picker-dropdown')]"));
        new SelectDateComponent(driver, selectDateNode).selectDate(day, month, year);
        return this;
    }

    /**
     * upload photo fo task
     * @param photoPath - photoPath from computer
     * @return AddTaskPage with selected photo
     */
    @Step("Upload photo from '{photoPath}' into task photo field")
    public AddTaskPage uploadPhoto(String photoPath) {
        photoInput.sendKeys(photoPath);
        waitForElementToAppear(photoAppeared);
        return this;
    }

    /**
     * type name for task
     * @param name - name of the task
     * @return AddTaskPage with typed name
     */
    @Step("Type '{name}' into task name field")
    public AddTaskPage typeName(String name) {
        waitForElementToAppear(nameInput).sendKeys(name);
        return this;
    }

    /**
     * type title for task
     * @param title - title of the task
     * @return AddTaskPage with typed title
     */
    @Step("Type '{title}' into task title field")
    public AddTaskPage typeTitle(String title) {
        waitForElementToAppear(titleInput).sendKeys(title);
        return this;
    }

    /**
     * type description for task
     * @param description - description of the task
     * @return AddTaskPage with typed description
     */
    @Step("Type '{description}' into task description field")
    public AddTaskPage typeDescription(String description) {
        waitForElementToAppear(descriptionInput).sendKeys(description);
        return this;
    }

    /**
     * select challenge from dropdown list for task
     * @param challenge - challenge name of the task
     * @return AddTaskPage with selected challenge
     */
    @Step("Select '{challenge}' into task from challenge dropdown")
    public AddTaskPage selectChallenge(String challenge) {
        waitForElementToAppear(challengeDropdown).click();
        waitForElementToAppear(driver.findElement(By.xpath(String.format(CHALLENGE_NAME_XPATH, challenge)))).click();
        return this;
    }

    /**
     * click save button and create task
     * @return ViewChallengePage with created task
     */
    @Step("Click save button and return ViewTaskPage")
    public ViewTaskPage clickSuccessSaveButton() {
        waitForElementToAppear(saveBtn).click();
        return new ViewTaskPage(driver);
    }

    /**
     * click save button with invalid data to show error message
     * @return AddTaskPage with error message
     */
    @Step("Click save button and return AddTaskPage")
    public AddTaskPage clickFailSaveButton() {
        waitForElementToAppear(saveBtn).click();
        return this;
    }

    /**
     * show success message of created task
     * @return text of success message
     */
    @Step("Get success message")
    public String checkSuccessMessage() {
        return waitForElementToAppear(successMessage).getText();
    }

    /**
     * show error message of uncreated task
     * @return text of error message
     */
    @Step("Verify that all fields are empty by default")
    public String checkErrorMessage() {
        return waitForElementToAppear(errorMessage).getText();
    }

    /**
     * Check if same input parameter are empty
     * @return boolean value if same input parameter are empty
     */
    @Step("Verify that all fields are empty by default")
    public boolean areWebElementsEmpty() {
        List<WebElement> taskPageFieldsList = new ArrayList<WebElement>(Arrays.asList(
                startDateInput, photoInput, nameInput, titleInput, descriptionInput, challengeDropdown
        ));
        boolean isFilled = false;
        for (WebElement taskPageField : taskPageFieldsList) {
            if (taskPageField.getAttribute("value") == null)
                isFilled = true;
        }
        return isFilled;
    }
    @Step("Get error message")
    public String getErrorMsg() {
        return waitForElementToAppear(errorMessage).getText();
    }
}
