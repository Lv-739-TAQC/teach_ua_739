package org.ssu.edu.teachua.ui.runners;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.testng.annotations.BeforeClass;

public class LoginWithAdminRunner extends BaseTestRunnerUI {

    @BeforeClass(description = "Precondition method : login into Admin account")
    public void loginPrecondition() {
        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getAdminEmail())
                .enterPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .loginIsSuccess();
    }
}
