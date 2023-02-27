package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TUA229 extends TestRunnerUI {
    @Test
    public void testTUA229() throws IOException {

        TestValueProvider adminCredentials = new TestValueProvider();

        AddChallengePage addChallengePage = new HomePage(driver)
                .getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(adminCredentials.getAdminEmail())
                .enterPassword(adminCredentials.getAdminPassword())
                .clickLoginButton()
                .getHeader()
                .openAdminProfileMenu()
                .openContentMenu()
                .openChallengesMenu()
                .clickChallenges()
                .addChallenge()
                .addPhoto("C:/test/image.png");

        Assert.assertTrue(addChallengePage.getPhotoAppeared().isDisplayed());
    }
}
