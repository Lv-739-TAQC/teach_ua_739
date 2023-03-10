package org.ssu.edu.teachua.ui.runners;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.testng.annotations.BeforeClass;

public class LoginWithUserRunner extends BaseTestRunnerUI {

    @BeforeClass(description = "Precondition method : login into User account")
    public void loginPrecondition() {
        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getUserEmail())
                .enterPassword(valueProvider.getUserPassword())
                .clickLoginButton()
                .loginIsSuccess();
    }
}
