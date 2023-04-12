package org.ssu.edu.teachua.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class ChallengesZhannaScenariosStep {

    private WebDriver driver;

    private TestValueProvider valueProvider = new TestValueProvider();

    private SoftAssert softAssert = new SoftAssert();

    private AddChallengePage addChallengePage;

    @Given("User open the main page of the site and login as admin")
    public void loginsWithAdminCred() {
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

    @When("User open add challenge page")
    public void userOpenAddChallengePage() {
        addChallengePage = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openContentMenu()
                .openChallengesMenu()
                .clickChallenges()
                .addChallenge();
    }

    @When("User enters {string} into challenge 'Порядковий номер' field")
    public void userEntersSortNumber(String sortNumber) {
        addChallengePage.fillSortNumber(sortNumber);
    }

    @When("User enters {string} into challenge 'Заголовок' field")
    public void userEntersTitle(String title) {
        addChallengePage.fillTitle(title);
    }

    @When("User enters {string} into challenge 'Опис' field")
    public void userEntersDescription(String description) {
        addChallengePage.fillDescription(description);
    }

    @When("User enters {string} into challenge 'Назва' field")
    public void userEntersName(String name) {
        addChallengePage.fillName(name);
    }

    @When("User upload the image into challenge 'Photo' field")
    public void userUploadPhoto() {
        addChallengePage.addPhoto(valueProvider.getFilePath("photos/image.png"));
    }

    @When("User click 'Save' button")
    public void userClickSave() {
        addChallengePage.clickSave();
    }

    @Then("Photo is appeared on the add challenge page")
    public void photoIsAppearedOnAddChallengePage() {
        Assert.assertTrue(addChallengePage.getPhotoAppeared().isDisplayed());
    }

    @Then("Error message {string} appeared and 'Назва' field is bordered in red color")
    public void userGetErrorMsgAndFieldBorderColor(String expectedErrorMsg) {
        String actualError = addChallengePage
                .clickSave()
                .checkErrorMessage();
        String actualBorderColor = addChallengePage.getBorderColorForNameField();
        softAssert.assertEquals(actualError, expectedErrorMsg);
        softAssert.assertEquals(actualBorderColor, "rgb(255, 0, 0)");
        softAssert.assertAll();
    }

    @After
    public void afterChallengeScenario() {
        if (driver != null) {
            driver.quit();
        }
    }
}

