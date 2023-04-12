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
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.asserts.SoftAssert;

public class ProfileZhannaScenariosStep {

    private WebDriver driver;

    private TestValueProvider valueProvider = new TestValueProvider();

    private SoftAssert softAssert = new SoftAssert();

    private ProfilePage profilePage;

    private EditProfileComponent editProfile;

    private final String redBorderColor = "rgb(255, 0, 0)";

    @Given("User open the main page of the site and login as administrator")
    public void loginsWithAdminCredentials() {
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

    @When("User open profile page")
    public void userOpenProfilePage() {
        profilePage = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openProfilePage();
    }

    @When("User click to 'Редагувати профіль' button and click 'Save'")
    public void userClickEditProfile() {
        editProfile = new ProfilePage(driver).clickEditProfileButton()
                .clickChangePassword()
                .clickSaveAfterEnteringInvalidData();
    }

    @Then("The 'Підтвердіть новий пароль' field is bordered in red colour and error message {string} appeared")
    public void userGetErrorMsgForConfirmNewPassword(String expectedErrorMsg) {
        String actualError = editProfile.getAlertMessageConfirmPassword();
        String actualBorderColor = editProfile.getBorderColorForConfirmPasswordField();
        softAssert.assertEquals(actualError, expectedErrorMsg);
        softAssert.assertEquals(actualBorderColor, redBorderColor);
        softAssert.assertAll();
    }

    @Then("The 'Введіть новий пароль' field is bordered in red colour and the error message {string} appeared")
    public void userGetErrorMsgForNewPassword(String expectedErrorMsg) {
        String actualError = editProfile.getAlertMessageNewPassword();
        String actualBorderColor = editProfile.getBorderColorForNewPasswordField();
        softAssert.assertEquals(actualError, expectedErrorMsg);
        softAssert.assertEquals(actualBorderColor, redBorderColor);
        softAssert.assertAll();
    }

    @Then("The 'Введіть діючий пароль' field is bordered in red colour and the error message {string} appeared")
    public void userGetErrorMsgForCurrentPassword(String expectedErrorMsg) {
        String actualError = editProfile.getAlertMessageCurrentPassword();
        String actualBorderColor = editProfile.getBorderColorForCurrentPasswordField();
        softAssert.assertEquals(actualError, expectedErrorMsg);
        softAssert.assertEquals(actualBorderColor, redBorderColor);
        softAssert.assertAll();
    }

    @After
    public void afterChallengeScenario() {
        if (driver != null) {
            driver.quit();
        }
    }

}
