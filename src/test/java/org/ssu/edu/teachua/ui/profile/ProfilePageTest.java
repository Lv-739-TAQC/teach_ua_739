package org.ssu.edu.teachua.ui.profile;

import org.ssu.edu.teachua.ui.components.modal.EditProfileComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class ProfilePageTest extends LoginWithAdminRunner {

    public final String RED_BORDER_COLOR = "rgb(255, 0, 0)";
    public final List<String> ERROR_MSG_PASSWORD = Arrays.asList(
            "Будь ласка, підтвердіть новий пароль",
            "Будь ласка, введіть новий пароль",
            "Будь ласка, введіть діючий пароль"
    );

    @BeforeMethod(description = "Precondition method: open Profile Page")
    public void openProfilePagePrecondition() {
        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .openAdminProfileMenu()
                .openProfilePage();
    }

    @Test
    public void verifyErrorMessagesForChangePassword() {

        SoftAssert softAssert = new SoftAssert();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickEditProfileButton();

        EditProfileComponent editProfile = new EditProfileComponent(driver, profilePage.getEditProfileNode());

        String actualErrorFirst = editProfile.clickChangePassword()
                .clickSaveAfterEnteringInvalidData()
                .getAlertMessageConfirmPassword();
        softAssert.assertEquals(actualErrorFirst, ERROR_MSG_PASSWORD.get(0));

        String actualBorderColorFirst = editProfile.getBorderColorForConfirmPasswordField();
        softAssert.assertEquals(actualBorderColorFirst, RED_BORDER_COLOR);

        String actualErrorSecond = editProfile.getAlertMessageNewPassword();
        softAssert.assertEquals(actualErrorSecond, ERROR_MSG_PASSWORD.get(1));

        String actualBorderColorSecond = editProfile.getBorderColorForNewPasswordField();
        softAssert.assertEquals(actualBorderColorSecond, RED_BORDER_COLOR);

        String actualErrorThird = editProfile.getAlertMessageCurrentPassword();
        softAssert.assertEquals(actualErrorThird, ERROR_MSG_PASSWORD.get(2));

        String actualBorderColorThird = editProfile.getBorderColorForCurrentPasswordField();
        softAssert.assertEquals(actualBorderColorThird, RED_BORDER_COLOR);

        softAssert.assertAll();

    }

}

