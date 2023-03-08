package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.BaseTestRunnerUI;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TUA335 extends BaseTestRunnerUI {
    private static final List<String> NAME = Arrays.asList(
            "Українськамоваєнаймилозвучніша",
            "Ukrainian",
            "99999",
            "~`!@#$%^&()_=+{}[]/|:<>?"
    );
    private static final String TITLE = "Заголовок Челенджу";
    private static final String DESCRIPTION = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s";
    private static final List<String> SUCCESS_MSG = Arrays.asList(
            "Челендж 'Українськамоваєнаймилозвучніша' успішно доданий!",
            "Челендж 'Ukrainian' успішно доданий!",
            "Челендж '99999' успішно доданий!",
            "Челендж '~`!@#$%^&()_=+{}[]/|:<>?' успішно доданий!"
    );

    @Test
    public void testTUA335() throws IOException {
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
                .addPhoto(valueProvider.getFilePath("photos/image.png"));

        String actualValueFirst = addChallengePage.fillName(NAME.get(0))
                .clickSave()
                .checkSuccessMessage();
        softAssert.assertEquals(actualValueFirst,SUCCESS_MSG.get(0));

        String actualValueSecond = addChallengePage.waitForSuccessMessageToDisappear()
                .clearName()
                .clearSortNumber()
                .fillSortNumber(String.valueOf(System.currentTimeMillis()))
                .fillName(NAME.get(1))
                .clickSave()
                .checkSuccessMessage();
        softAssert.assertEquals(actualValueSecond,SUCCESS_MSG.get(1));

        String actualValueThird = addChallengePage.waitForSuccessMessageToDisappear()
                .clearName()
                .clearSortNumber()
                .fillSortNumber(String.valueOf(System.currentTimeMillis()))
                .fillName(NAME.get(2))
                .clickSave()
                .checkSuccessMessage();
        softAssert.assertEquals(actualValueThird,SUCCESS_MSG.get(2));

        String actualValueFourth = addChallengePage.waitForSuccessMessageToDisappear()
                .clearName()
                .clearSortNumber()
                .fillSortNumber(String.valueOf(System.currentTimeMillis()))
                .fillName(NAME.get(3))
                .clickSave()
                .checkSuccessMessage();
        softAssert.assertEquals(actualValueFourth,SUCCESS_MSG.get(3));
        softAssert.assertAll();
    }
}