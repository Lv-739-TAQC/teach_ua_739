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
import org.ssu.edu.teachua.ui.components.modal.EditProfileComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.asserts.SoftAssert;

public class ProfileBohdanScenarioSteps {

    private WebDriver driver;
    private TestValueProvider valueProvider = new TestValueProvider();
    private SoftAssert softAssert = new SoftAssert();
    private EditProfileComponent editProfileComponent;

    @Given("User login as admin")
    public void loginAsAdmin() {
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

    @When("User open edit profile page")
    public void userOpenEditProfilePage() {
        editProfileComponent = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openProfilePage()
                .clickEditProfileButton();
    }

    @When("User enters {string} into profile name field")
    public void userEnterNewName(String name) {
        editProfileComponent.enterNewFirstName(name);
    }

    @Then("Error message {string} is shown")
    public void userGetErrorMessage(String expectedErrorMsg) {
        String actualError = editProfileComponent.getAlertMessageFirstName();
        softAssert.assertEquals(actualError, expectedErrorMsg);
        softAssert.assertAll();
    }

    @After
    public void afterChallengeScenario() {
        if (driver != null) {
            driver.quit();
        }
    }
}
