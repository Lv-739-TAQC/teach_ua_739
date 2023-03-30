package org.ssu.edu.teachua.utils.runners;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.testng.annotations.BeforeClass;

/**
 * This class contains a method with a precondition for login as "Lead" on the speak-ukrainian.org.ua website
 * The necessary browser with our site is launched in the {@link BaseTestRunnerUI} class,
 * which is inherited by this class
 */
public class LoginWithLeadUIRunner extends BaseTestRunnerUI{

    /**
     *This method is a precondition for tests for which we need to be registered as "Lead"
     */
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
