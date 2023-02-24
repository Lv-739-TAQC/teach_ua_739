package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class FirstTest extends TestRunnerUI {

    @Test
    public void testFirstFunctionality() throws IOException {
        // login preconditions :
        TestValueProvider adminCredentials = new TestValueProvider();
        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(adminCredentials.getAdminEmail())
                .enterPassword(adminCredentials.getAdminPassword())
                .clickLoginButton();

        // example of test execution :
        String actualResult = homePage.getHeader()
                .openAdminProfileMenu()
                .openContentMenu()
                .openChallengesMenu()
                .clickChallenges()
                .getNameOfSecondTableHeaderElement();

        Assert.assertEquals(actualResult, "Порядковий номер");
    }
}
