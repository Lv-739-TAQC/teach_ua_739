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
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.view.ViewChallengePage;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.Assert;

public class Tua71Step {
    private WebDriver driver;
    private final TestValueProvider valueProvider = new TestValueProvider();
    private ViewChallengePage challengePage;
    public String expected;
    public String testChallengePage;

    @Given("User open website with baseUrl")
    public void userOpenWebsiteWithBaseUrl() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(valueProvider.getBaseUiUrl());
        checkErrorPage();

    }

    private void checkErrorPage() {
        try {
            driver.findElement(By.id("details-button")).click();
            driver.findElement(By.id("proceed-link")).click();
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @When("User open challenge page")
    public void userClicksChallengeButton() {
        challengePage = new HomePage(driver)
                .getHeader()
                .clickChallengesButton()
                .clickChallengeButton(5);
    }

    @When("User get the current url of challenge page")
    public void getCurrentUrl() {
        expected = challengePage.getCurrentUrl();
    }

    @When("User click the 'Челендж' button in the header and get the url of challenge in dropdown you opened early")
    public void getChallengeInDropdownUrl() {
        testChallengePage = challengePage.getHeader()
                .clickChallengesButton()
                .getChallengeUrl(5);
    }

    @Then("Url of challenge page equal to url of challenge in dropdown")
    public void assertUrls() {
        Assert.assertEquals(testChallengePage, expected);
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }
}
