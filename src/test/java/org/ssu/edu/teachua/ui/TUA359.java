package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.components.modal.EditProfileComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TUA359 extends TestRunnerUI {

    public final String RED_BORDER_COLOR = "rgb(255, 0, 0)";
    public final List<String> ERROR_MSG = Arrays.asList(
            "Будь ласка, підтвердіть новий пароль",
            "Будь ласка, введіть новий пароль",
            "Будь ласка, введіть діючий пароль"
    );

    @Test
    public void testTUA359() throws IOException {

        SoftAssert softAssert = new SoftAssert();

        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getAdminEmail())
                .enterPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .getHeader()
                .openAdminProfileMenu()
                .openProfilePage()
                .clickEditProfileButton();

        EditProfileComponent editProfile = new EditProfileComponent(driver, profilePage.getEditProfileNode());

        String actualErrorFirst = editProfile.clickChangePassword()
                .clickSaveAfterEnteringInvalidData()
                .getAlertMessageConfirmPassword();
        softAssert.assertEquals(actualErrorFirst, ERROR_MSG.get(0));

        String actualBorderColorFirst = editProfile.getBorderColorForConfirmPasswordField();
        softAssert.assertEquals(actualBorderColorFirst, RED_BORDER_COLOR);

        String actualErrorSecond = editProfile.getAlertMessageNewPassword();
        softAssert.assertEquals(actualErrorSecond, ERROR_MSG.get(1));

        String actualBorderColorSecond = editProfile.getBorderColorForNewPasswordField();
        softAssert.assertEquals(actualBorderColorSecond, RED_BORDER_COLOR);

        String actualErrorThird = editProfile.getAlertMessageCurrentPassword();
        softAssert.assertEquals(actualErrorThird, ERROR_MSG.get(2));

        String actualBorderColorThird = editProfile.getBorderColorForCurrentPasswordField();
        softAssert.assertEquals(actualBorderColorThird, RED_BORDER_COLOR);

        softAssert.assertAll();
    }
}
