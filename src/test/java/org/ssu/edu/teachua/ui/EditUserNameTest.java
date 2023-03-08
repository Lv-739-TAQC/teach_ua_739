package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.BaseTestRunnerUI;
import org.ssu.edu.teachua.utils.DataProviderTua328;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class EditUserNameTest extends BaseTestRunnerUI {

    @Test(dataProvider = "dpTua328", dataProviderClass = DataProviderTua328.class)
    public void inputWrongNameTest(String insert, String expected) throws IOException {

        TestValueProvider adminCredentials = new TestValueProvider();
        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(adminCredentials.getAdminEmail())
                .enterPassword(adminCredentials.getAdminPassword())
                .clickLoginButton();

        String actualResult = homePage.getHeader()
                .openAdminProfileMenu()
                .openProfilePage()
                .clickEditProfileButton()
                .enterNewFirstName(insert).getAlertMessageFirstName();

        Assert.assertEquals(actualResult, expected);
    }

    @Test
    public void deleteNameTest() throws IOException {

        TestValueProvider adminCredentials = new TestValueProvider();
        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(adminCredentials.getAdminEmail())
                .enterPassword(adminCredentials.getAdminPassword())
                .clickLoginButton();

        String actualResult = homePage.getHeader()
                .openAdminProfileMenu()
                .openProfilePage()
                .clickEditProfileButton()
                .enterNewFirstName("normalName")
                .enterNewFirstName("").getAlertMessageFirstName();

        Assert.assertEquals(actualResult, "Будь ласка введіть Ваше ім'я");
    }
}
