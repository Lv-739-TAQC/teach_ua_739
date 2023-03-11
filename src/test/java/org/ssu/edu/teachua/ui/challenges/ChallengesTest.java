package org.ssu.edu.teachua.ui.challenges;

import io.qameta.allure.Issue;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChallengesTest extends LoginWithAdminRunner {

    private static final String NAME = "Ukraine";
    private static final String TITLE = "Title";
    private static final String DESCRIPTION =
            "В эпоху Возрождения разделяется понятие искусства (искусной деятельности) " +
            "и персонализированной художественной деятельности с индивидуальными образами";
    private static final String PHOTO_PATH = "path_to_photo";

    @Issue(value = "TUA-338")
    @Test(description = "[Challenge] Verify that 'Admin' cannot create challenge with invalid data in 'Опис' field on 'Опис' tab")
    public void verifyThatAdminCannotCreateChallengeWithInvalidDataInDescriptionFieldOnDescriptionTab() {
        String errorMessage = new HomePage(driver)
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
                .fillSortNumber(String.valueOf(System.currentTimeMillis()))
                .fillName(NAME)
                .fillTitle(TITLE)
                .fillDescription(DESCRIPTION)
                .addPhoto(PHOTO_PATH)
                .clickSave()
                .checkErrorMessage();

        Assert.assertEquals(errorMessage, "description Помилка. Текст містить недопустимі символи");
    }
}
