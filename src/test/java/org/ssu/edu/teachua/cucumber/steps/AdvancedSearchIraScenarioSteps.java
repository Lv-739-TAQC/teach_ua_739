package org.ssu.edu.teachua.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.ssu.edu.teachua.ui.components.search.AdvancedSearchCenterComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.asserts.SoftAssert;

public class AdvancedSearchIraScenarioSteps {
    private WebDriver driver;

    private final TestValueProvider valueProvider = new TestValueProvider();

    private AdvancedSearchCenterComponent advancedSearchCenterComponent;

    private final SoftAssert softAssert = new SoftAssert();

    @Given("User opens the main page of the site")
    public void userOpensTheMainPageOfTheSite() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(valueProvider.getBaseUiUrl());
        checkErrorPage("chrome");

        HomePage homePage = new HomePage(driver);

        homePage.getHeader();
    }

    private void checkErrorPage(String browser) {
        try {
            driver.findElement(By.id(browser.equals("firefox") ? "advancedButton" : "details-button")).click();
            driver.findElement(By.id(browser.equals("firefox") ? "exceptionDialogButton" : "proceed-link")).click();
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @When("User opens advanced search club component")
    public void userOpensAdvancedSearchClubComponent() {
        advancedSearchCenterComponent = new HomePage(driver)
                .clickAdvancedSearchIcon();
    }

    @Then("Advanced search modal is displayed")
    public void advancedSearchModalIsDisplayed() {
        advancedSearchCenterComponent = new AdvancedSearchCenterComponent(driver);
        boolean isAdvancedSearchModalDisplayed = advancedSearchCenterComponent.isAdvancedSearchModalDisplayed();
        softAssert.assertTrue(isAdvancedSearchModalDisplayed);
    }

    @And("User clicks on advanced search icon")
    public void userClicksOnAdvancedSearchIcon() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAdvancedSearchIcon();
    }

    @Then("Advanced search modal is hidden")
    public void advancedSearchModalIsHidden() {
        boolean isAdvancedSearchModalDisplayed = advancedSearchCenterComponent.isAdvancedSearchModalDisplayed();
        softAssert.assertFalse(isAdvancedSearchModalDisplayed, "Advanced search modal should not be displayed");
        softAssert.assertAll();
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }
}
