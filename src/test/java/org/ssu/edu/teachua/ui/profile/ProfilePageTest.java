package org.ssu.edu.teachua.ui.profile;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.ui.components.modal.EditProfileComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminRunner;
import org.ssu.edu.teachua.utils.providers.DataProviderProfilePage;
import org.ssu.edu.teachua.utils.providers.DataProviderTua328;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTest extends LoginWithAdminRunner {

    private ProfilePage profilePage;

    @BeforeMethod(description = "Precondition: open Profile Page")
    void openProfilePagePrecondition() {
        driver.navigate().refresh();
        profilePage = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openProfilePage();
    }

    @Issue("TUA-359")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that error messages are shown\n while leaving empty any field in the 'Змінити пароль' pop-up")
    @Test(dataProvider = "dpTestChangePassword", dataProviderClass = DataProviderProfilePage.class)
    public void testErrorMessagesForChangePassword(String redBorderColor, String errorMsgConfirmNewPassword,
                                                   String errorMsgNewPassword, String errorMsgCurrentPassword) {
        EditProfileComponent editProfile = profilePage.clickEditProfileButton()
                .clickChangePassword()
                .clickSaveAfterEnteringInvalidData();

        String actualErrorMsgFirst = editProfile.getAlertMessageConfirmPassword();
        softAssert.assertEquals(actualErrorMsgFirst, errorMsgConfirmNewPassword);

        String actualBorderColorFirst = editProfile.getBorderColorForConfirmPasswordField();
        softAssert.assertEquals(actualBorderColorFirst, redBorderColor);

        String actualErrorMsgSecond = editProfile.getAlertMessageNewPassword();
        softAssert.assertEquals(actualErrorMsgSecond, errorMsgNewPassword);

        String actualBorderColorSecond = editProfile.getBorderColorForNewPasswordField();
        softAssert.assertEquals(actualBorderColorSecond, redBorderColor);

        String actualErrorMsgThird = editProfile.getAlertMessageCurrentPassword();
        softAssert.assertEquals(actualErrorMsgThird, errorMsgCurrentPassword);

        String actualBorderColorThird = editProfile.getBorderColorForCurrentPasswordField();
        softAssert.assertEquals(actualBorderColorThird, redBorderColor);

        softAssert.assertAll();
    }
    
    @Issue("TUA-343")
    @Test(dataProvider = "dpTestVerifieDataLastName", dataProviderClass = DataProviderProfilePage.class)
    public void testErrorMessagesForChangeLastName (String enteringData, String expectedMessages) {
    	
		EditProfileComponent editProfileComponent = profilePage.clickEditProfileButton();
		
		String actionMessages =  editProfileComponent.enterNewLastName(enteringData).getAlertMessageLastName();
								
		softAssert.assertEquals(actionMessages,expectedMessages);
		softAssert.assertTrue(editProfileComponent.getSaveChangesButton().isDisplayed());
		softAssert.assertAll();
    }
    
    @Issue("TUA-359")
    @Test(dataProvider = "dpTestVerifieDataPhoneNumber", dataProviderClass = DataProviderProfilePage.class)
    public void testErrorMessagesForChangePhoneNumber (String enteringData, String expectedMessages) {
    	
		EditProfileComponent editProfileComponent = profilePage.clickEditProfileButton();
		
		String actionMessages = editProfileComponent.enterNewPhone(enteringData).getAlertMessagePhone();
		
		softAssert.assertEquals(actionMessages, expectedMessages);
		softAssert.assertTrue(editProfileComponent.getSaveChangesButton().isDisplayed());
		softAssert.assertAll();
		
	}

    @Issue("TUA-328")
    @Test(dataProvider = "dpTua328", dataProviderClass = DataProviderTua328.class)
    public void inputWrongNameTest(String insert, String expected) {

        String actualResult = profilePage.getHeader()
                .openAdminProfileMenu()
                .openProfilePage()
                .clickEditProfileButton()
                .enterNewFirstName(insert).getAlertMessageFirstName();

        Assert.assertEquals(actualResult, expected);
    }

    @Issue("TUA-328")
    @Test
    public void deleteNameTest() {

        String actualResult = profilePage.getHeader()
                .openAdminProfileMenu()
                .openProfilePage()
                .clickEditProfileButton()
                .enterNewFirstName("normalName")
                .enterNewFirstName("").getAlertMessageFirstName();

        Assert.assertEquals(actualResult, "Будь ласка введіть Ваше ім'я");
    }
}
