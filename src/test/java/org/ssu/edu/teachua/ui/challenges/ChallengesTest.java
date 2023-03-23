package org.ssu.edu.teachua.ui.challenges;

import io.qameta.allure.Issue;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChallengesTest extends LoginWithAdminRunner {

    private static final String NAME = "Ukraine";
    private static final String TITLE = "Title";
    private static final String DESCRIPTION =
            "В эпоху Возрождения разделяется понятие искусства (искусной деятельности) " +
            "и персонализированной художественной деятельности с индивидуальными образами";

    @Issue(value = "TUA-338")
    @Test(description = "[Challenge] Verify that 'Admin' cannot create challenge with invalid data in 'Опис' field on 'Опис' tab")
    public void verifyThatAdminCannotCreateChallengeWithInvalidDataInDescriptionFieldOnDescriptionTab() {
        String errorMessage = new HomePage(driver)
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
                .addPhoto(valueProvider.getFilePath("photos/heart.png"))
                .clickSave()
                .checkErrorMessage();

        Assert.assertEquals(errorMessage, "description Помилка. Текст містить недопустимі символи");
    }
}
