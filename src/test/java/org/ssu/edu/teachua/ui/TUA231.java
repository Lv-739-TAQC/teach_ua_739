package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TUA231 extends TestRunnerUI {
    public static final String RED_BORDER_COLOR = "rgb(255, 0, 0)";
    public static final List<String> ERROR_MSG = Arrays.asList(
            "Це поле може містити тільки українські та англійські літери, цифри та спеціальні символи",
            "Назва Челенджу закоротка",
            "Назва Челенджу задовга",
            "Поле не повинно бути пустим"
    );

    @Test
    public void testTUA231() throws IOException {

        TestValueProvider adminCredentials = new TestValueProvider();

        SoftAssert softAssert = new SoftAssert();

        AddChallengePage addChallengePage = new HomePage(driver)
                .getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(adminCredentials.getAdminEmail())
                .enterPassword(adminCredentials.getAdminPassword())
                .clickLoginButton()
                .getHeader()
                .openAdminProfileMenu()
                .openContentMenu()
                .openChallengesMenu()
                .clickChallenges()
                .addChallenge()
                .fillSortNumber("546789")
                .fillTitle("testZhanna2502")
                .fillDescription("testZhanna2502".repeat(3))
                .addPhoto("C:/test/image.png");

        String actualErrorFirst = addChallengePage.fillName("Дыผð*.:")
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorFirst, ERROR_MSG.get(0));

        String actualErrorSecond = addChallengePage.waitForErrorMessageToDisappear()
                .clearName()
                .fillName("2")
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorSecond, ERROR_MSG.get(1));

        String actualErrorThird = addChallengePage.waitForErrorMessageToDisappear()
                .clearName()
                .fillName("Test".repeat(20))
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorThird, ERROR_MSG.get(2));

        String actualErrorForth = addChallengePage.waitForErrorMessageToDisappear()
                .clearName()
                .fillName("")
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorForth, ERROR_MSG.get(3));

        String actualBorderColor = addChallengePage.getBorderColorForNameField();
        softAssert.assertEquals(actualBorderColor, RED_BORDER_COLOR);

        softAssert.assertAll();
    }
}