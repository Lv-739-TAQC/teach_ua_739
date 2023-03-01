package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class TUA336 extends TestRunnerUI {
    private static final List<String> NAME = Arrays.asList(
            "писатель эссеист",
            "",
            "Історично сформовані є особливості"
    );

    private static final String TITLE = "Заголовок Челенджу";
    private static final String DESCRIPTION = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s";
    private static final List<String> ERROR_MSG = Arrays.asList(
            "Це поле може містити тільки українські та англійські літери, цифри та спеціальні символи",
            "Поле ‘Назва Челенджу’ не може бути порожнім",
            "Назва Челенджу задовга"
    );

    @Test
    public void testTUA336() throws IOException {
        SoftAssert softAssert = new SoftAssert();

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
                .fillSortNumber(String.valueOf(System.currentTimeMillis()))
                .fillTitle(TITLE)
                .fillDescription(DESCRIPTION)
                .addPhoto(valueProvider.getFilePath("image.png"));

        String actualErrorMsgFirst = addChallengePage.fillName(NAME.get(0))
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorMsgFirst, ERROR_MSG.get(0));

        String actualErrorMsgSecond = addChallengePage.waitForErrorMessageToDisappear()
                .clearName()
                .fillName(NAME.get(1))
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorMsgSecond, ERROR_MSG.get(1));

        String actualErrorMsgThird = addChallengePage.waitForErrorMessageToDisappear()
                .clearName()
                .fillName(NAME.get(2))
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorMsgThird, ERROR_MSG.get(2));
        softAssert.assertAll();
    }
}
