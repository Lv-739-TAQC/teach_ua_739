package org.ssu.edu.teachua.ui.runners;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.testng.annotations.BeforeMethod;

public class LoginRunner extends TestRunnerUI {

    @BeforeMethod(description = "Precondition method : login into your account")
    public void loginPrecondition() {
        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getAdminEmail())
                .enterPassword(valueProvider.getAdminPassword())
                .clickLoginButton();
    }
}
