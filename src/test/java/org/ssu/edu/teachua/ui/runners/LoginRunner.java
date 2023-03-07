package org.ssu.edu.teachua.ui.runners;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class LoginRunner extends TestRunnerUI {
    protected HomePage homePage;

    @BeforeClass(description = "Precondition method : login into your account")
    public void loginPrecondition() {
        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getAdminEmail())
                .enterPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .getLoginSuccessMsg();
    }

    @BeforeMethod
    public void goToHomePage() {
        driver.get(valueProvider.getBaseUiUrl());
        homePage = new HomePage(driver);
    }
}
