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
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubContactsComponent;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubDescriptionComponent;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubMainInfoComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.Assert;


public class AddClubAnnaScenarioSteps {
    private WebDriver driver;

    private TestValueProvider valueProvider = new TestValueProvider();


    private AddClubMainInfoComponent addClubMainInfoComponent;
    private AddClubContactsComponent addClubContactsComponent;
    private AddClubDescriptionComponent addClubDescriptionComponent;

    @Given("User open the main page of the site and login as lead")
    public void loginsWithLeadCred() {
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
                .enterEmail(valueProvider.getLeadEmail())
                .enterPassword(valueProvider.getLeadPassword())
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

    @When("User opens add club main info component")
    public void userOpensAddClubMainInfoComponent() {
        addClubMainInfoComponent = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openAddClubForm();
    }

    @Then("User enters {string} into club 'Назва' field")
    public void userEntersCLubName(String name) {
        addClubMainInfoComponent.enterClubName(name);
    }

    @And("User chooses club category {int}")
    public void userChoosesCategories(int category) {
        addClubMainInfoComponent.getCategoriesCheckBoxes(category);
    }

    @And("User enters child minimum age {string}")
    public void userEntersChildMinAge(String childAgeFrom) {
        addClubMainInfoComponent.enterChildAgeFrom(childAgeFrom);
    }

    @And("User enters child maximum age {string}")
    public void userEntersChildMaxAge(String childAgeFor) {
        addClubMainInfoComponent.enterChildAgeFor(childAgeFor);
    }

    @Then("User clicks the 'Next' button and navigates further to Contacts component")
    public void userClicksNextStepButtonContacts() {
        addClubMainInfoComponent.clickNextStepButton();
    }

    @And("User enters phone number {string}")
    public void userEntersPhoneNumber(String contactPhone) {
        addClubContactsComponent = new AddClubContactsComponent(driver);
        addClubContactsComponent.enterContactPhone(contactPhone);
    }

    @Then("User clicks the 'Next' button and navigates further to Description component")
    public void userClicksNextStepButtonDescription() {
        addClubContactsComponent.clickNextStepButton();
    }

    @And("User enters {string} to 'Опис' field")
    public void userEntersDescription(String description) {

        addClubDescriptionComponent = new AddClubDescriptionComponent(driver);
        addClubDescriptionComponent.enterDescription(description);
    }

    @Then("Description field validation success")
    public void descriptionTextSuccess() {
        Assert.assertTrue(addClubDescriptionComponent.getDescriptionSuccess());
    }

    @Then("Error message {string} appeared")
    public void descriptionTextError(String expectedErrorMsg) {
        String actualError = addClubDescriptionComponent.getDescriptionErrorMessage();
        Assert.assertEquals(actualError, expectedErrorMsg);
    }

    @After
    public void afterChallengeScenario() {
        if (driver != null) {
            driver.quit();
        }
    }
}
