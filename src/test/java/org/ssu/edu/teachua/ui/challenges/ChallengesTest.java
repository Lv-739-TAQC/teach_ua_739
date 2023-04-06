package org.ssu.edu.teachua.ui.challenges;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebElement;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminUIRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ChallengesTest extends LoginWithAdminUIRunner {

    private static final String NAME = "Ukraine";
    private static final String TITLE = "Title";
    private static final String DESCRIPTION =
            "В эпоху Возрождения разделяется понятие искусства (искусной деятельности) " +
                    "и персонализированной художественной деятельности с индивидуальными образами";
    private static final String CHALLENGE_NAME = "Мовомаратон";

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

    @Issue(value = "TUA-351")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifies that user is able to find the 'Мовомаратон' button as the 1st item of the drop-down menu of challenges")
    @Test
    public void testChallengeExistence() {
        List<WebElement> challenges = new HomePage(driver)
                .getHeader()
                .clickChallengesButton()
                .getChallenges();
        Assert.assertEquals(CHALLENGE_NAME, challenges.get(0).getText());
    }
}
