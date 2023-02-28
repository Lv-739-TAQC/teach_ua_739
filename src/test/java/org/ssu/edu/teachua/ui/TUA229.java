package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class TUA229 extends TestRunnerUI {

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
                .addPhoto(valueProvider.getFilePath("image.png"));

        Assert.assertTrue(addChallengePage.getPhotoAppeared().isDisplayed());
    }
}
