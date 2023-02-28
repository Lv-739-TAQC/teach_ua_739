package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.pages.challenges.AddChallengePage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TUA231 extends TestRunnerUI {

    public static final String RED_BORDER_COLOR = "rgb(255, 0, 0)";
    public static final String VALID_SORT_NUMBER = "546789";
    public static final String VALID_TITLE = "testFeb2023";
    public static final String VALID_DESCRIPTION = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
    public static final List<String> INVALID_NAME = Arrays.asList(
            "Дыผð*.:",
            "2",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            ""
    );
    public static final List<String> ERROR_MSG = Arrays.asList(
            "Це поле може містити тільки українські та англійські літери, цифри та спеціальні символи",
            "Назва Челенджу закоротка",
            "Назва Челенджу задовга",
            "Поле не повинно бути пустим"
    );

    @Test
    public void testTUA231() throws IOException {

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
                .fillSortNumber(VALID_SORT_NUMBER)
                .fillTitle(VALID_TITLE)
                .fillDescription(VALID_DESCRIPTION)
                .addPhoto(valueProvider.getFilePath("image.png"));

        String actualErrorFirst = addChallengePage.fillName(INVALID_NAME.get(0))
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorFirst, ERROR_MSG.get(0));

        String actualErrorSecond = addChallengePage.waitForErrorMessageToDisappear()
                .clearName()
                .fillName(INVALID_NAME.get(1))
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorSecond, ERROR_MSG.get(1));

        String actualErrorThird = addChallengePage.waitForErrorMessageToDisappear()
                .clearName()
                .fillName(INVALID_NAME.get(2))
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorThird, ERROR_MSG.get(2));

        String actualErrorForth = addChallengePage.waitForErrorMessageToDisappear()
                .clearName()
                .fillName(INVALID_NAME.get(3))
                .clickSave()
                .checkErrorMessage();
        softAssert.assertEquals(actualErrorForth, ERROR_MSG.get(3));

        String actualBorderColor = addChallengePage.getBorderColorForNameField();
        softAssert.assertEquals(actualBorderColor, RED_BORDER_COLOR);

        softAssert.assertAll();
    }
}
