package org.ssu.edu.teachua.ui;
import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.BaseTestRunnerUI;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;



public class TUA157  extends BaseTestRunnerUI {

    private static final String SORT_NUMBER = "";
    private static final String NAME = "Челендж_99";
    private static final String TITLE = "99-й найкращий";
    private static final String DESCRIPTION = "Який-небудь опис челенджу, челенджу челенджу челенджу челенджу";
    private static final String ERROR_MSG = "Поле порядковий номер не має бути пустим";

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
                .addChallenge();

        softAssert.assertTrue(addChallengePage.isEmptyString(addChallengePage.getValueSortNumber()));
        softAssert.assertTrue(addChallengePage.isEmptyString(addChallengePage.getValueName()));
        softAssert.assertTrue(addChallengePage.isEmptyString(addChallengePage.getValueTitle()));
        softAssert.assertTrue(addChallengePage.isEmptyString(addChallengePage.getValueDescription()));

        String actualError = addChallengePage.waitForErrorMessageToDisappear()
                .fillSortNumber(SORT_NUMBER)
                .fillName(NAME)
                .fillTitle(TITLE)
                .fillDescription(DESCRIPTION)
                .addPhoto(valueProvider.getFilePath("photos/image.png"))
                .clickSave()
                .checkErrorMessage();

        softAssert.assertEquals(actualError, ERROR_MSG);

        softAssert.assertAll();
    }
}
