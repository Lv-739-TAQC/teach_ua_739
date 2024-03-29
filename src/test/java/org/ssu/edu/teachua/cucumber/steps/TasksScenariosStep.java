package org.ssu.edu.teachua.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.ssu.edu.teachua.db.entities.Task;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.tasks.AddTaskPage;
import org.ssu.edu.teachua.utils.EntityService;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Calendar;
import java.util.List;

public class TasksScenariosStep {

    private WebDriver driver;
    private EntityService entityService = new EntityService();
    private TestValueProvider valueProvider = new TestValueProvider();

    private AddTaskPage addTaskPage;
    private String taskName;
    private String errorMessage;

    private SoftAssert softAssert = new SoftAssert();

    @Given("User logins with admin credentials")
    public void userLoginsWithAdminCredentials() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(valueProvider.getBaseUiUrl());
        checkErrorPage("chrome");

        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getAdminEmail())
                .enterPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .loginIsSuccess();
    }

    private void checkErrorPage(String browser) {
        try {
            driver.findElement(By.id(browser.equals("firefox") ? "advancedButton" : "details-button")).click();
            driver.findElement(By.id(browser.equals("firefox") ? "exceptionDialogButton" : "proceed-link")).click();
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @When("User open add task page")
    public void userOpenAddTaskPage() {
        addTaskPage = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openContentMenu()
                .openChallengesMenu()
                .clickTasks()
                .openAddTaskPage();
    }

    @When("User selects start date with day {int}, month {int} and next year")
    public void userSelectsStartDate(int day, int month) {
        Calendar now = Calendar.getInstance();
        addTaskPage.selectStartDate(day, month, now.get(Calendar.YEAR) + 1);
    }

    @When("User selects start date with day {int}, month {int} and year {int}")
    public void userSetStartDate(int day, int month, int year) {
        addTaskPage.selectStartDate(day, month, year);
    }

    @When("User downloads the image into 'Фото' field")
    public void userDownloadsTheImage() {
        addTaskPage.uploadPhoto(valueProvider.getFilePath("photos/heart.png"));
    }

    @When("User enters {string} into 'Назва' field")
    public void userEntersName(String name) {
        addTaskPage.typeName(name);
    }

    @When("User enters {string} into 'Заголовок' field")
    public void userEntersTitle(String title) {
        addTaskPage.typeTitle(title);
    }

    @When("User enters {string} into 'Опис' field")
    public void userEntersDescription(String description) {
        addTaskPage.typeDescription(description);
    }

    @When("User choose the challenge with name {string} in dropdown list on the 'Челендж' field")
    public void userSelectChallenge(String challenge) {
        addTaskPage.selectChallenge(challenge);
    }

    @When("User clicks on the 'Зберегти' button")
    public void userClicksSaveButton() {
        taskName = addTaskPage.clickSuccessSaveButton().getTaskName();
    }

    @When("User clicks on the 'Зберегти' button after empty challenge")
    public void userClicksSaveButtonAfterEmptyChallenge() {
        errorMessage = addTaskPage.clickFailSaveButton().checkErrorMessage();
    }

    @When("User clicks on the 'Зберегти' button after selected invalid start date")
    public void userClicksSaveButtonInvalidStartDate() {
        errorMessage = addTaskPage.clickFailSaveButton().checkErrorMessage();
    }

    @Then("User is on the task page with name {string}")
    public void userIsOnTheTaskPageWithName(String expectedTaskName) {
        Assert.assertEquals(taskName, expectedTaskName);
    }

    @Then("Error message appears: {string}")
    public void errorMessageAppears(String expectedErrorMessage) {
        Assert.assertEquals(errorMessage, expectedErrorMessage);
    }

    @Then("The error message appears: {string}")
    public void theErrorMessageAppears(String expectedErrorMessage) {
        softAssert.assertEquals(errorMessage, expectedErrorMessage);
    }

    @Then("Task with name {string} is present in database")
    public void taskWithNameIsPresentInDatabase(String expectedTaskName) {
        List<Task> tasks = entityService.getTaskService().getTasksByName(expectedTaskName);
        for (Task task: tasks) {
            Assert.assertEquals(task.getName(), expectedTaskName);
        }
    }

    @Then("Task with name {string} is not added to the DB")
    public void taskWithNameIsNotAddedToDB(String expectedTaskName) {
        List<Task> tasks = entityService.getTaskService().getTasksByName(expectedTaskName);
        softAssert.assertEquals(tasks.size(), 0);
        softAssert.assertAll();
    }


    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }
}
