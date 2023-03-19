package org.ssu.edu.teachua.utils.runners;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.testng.annotations.BeforeClass;

public class LoginWithLeadRunner extends BaseTestRunnerUI{

    @BeforeClass(description = "Precondition method : login into Lead account")
    public void loginPrecondition() {
        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getLeadEmail())
                .enterPassword(valueProvider.getLeadPassword())
                .clickLoginButton()
                .loginIsSuccess();
    }
}
