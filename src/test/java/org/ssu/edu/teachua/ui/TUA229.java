package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.BaseTestRunnerUI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TUA229 extends BaseTestRunnerUI {

    @Test
    public void testTUA229() throws IOException {

        AddChallengePage addChallengePage = new HomePage(driver)
                .getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getAdminEmail())
                .enterPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .getHeader()
                .openAdminProfileMenu()
                .openContentMenu()
                .openChallengesMenu()
                .clickChallenges()
                .addChallenge()
                .addPhoto(valueProvider.getFilePath("photos/image.png"));

        Assert.assertTrue(addChallengePage.getPhotoAppeared().isDisplayed());
    }
}
