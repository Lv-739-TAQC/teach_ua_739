package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.ssu.edu.teachua.ui.utils.NumberGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChallengesTest extends TestRunnerUI {

    @Test
    public void verifyThatAdminCannotCreateChallengeWithInvalidDataInDescriptionFieldOnDescriptionTab() throws InterruptedException {
        new HomePage(driver)
                .getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getAdminEmail())
                .enterPassword(valueProvider.getAdminPassword())
                .clickLoginButton();

        AddChallengePage addChallengePage = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openContentMenu()
                .openChallengesMenu()
                .clickChallenges()
                .addChallenge();

        addChallengePage.fillSortNumber(String.valueOf(NumberGenerator.generateRandomNumber()));
        addChallengePage.fillName("Ukraine");
        addChallengePage.fillTitle("Title");
        addChallengePage.fillDescription("В эпоху Возрождения разделяется понятие искусства (искусной деятельности) и персонализированной художественной деятельности с индивидуальными образами");
        addChallengePage.addPhoto("path_to_photo");
        Thread.sleep(5000);
        addChallengePage.clickSave();

        Assert.assertEquals(addChallengePage.checkErrorMessage(), "description Помилка. Текст містить недопустимі символи");
    }
}
