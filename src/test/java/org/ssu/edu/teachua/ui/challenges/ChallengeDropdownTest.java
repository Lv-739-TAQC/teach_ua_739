package org.ssu.edu.teachua.ui.challenges;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.BaseTestRunnerUI;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ChallengeDropdownTest extends BaseTestRunnerUI {

    @Test
    public void testTua71() throws IOException {
        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .clickChallengesButton()
                .clickChallengeButton(5);
        String expected = driver.getCurrentUrl();

        String testChallengePage = homePage.getHeader()
                .clickChallengesButton()
                .getChallengeUrl(5);

        Assert.assertEquals(testChallengePage, expected);
    }
}
