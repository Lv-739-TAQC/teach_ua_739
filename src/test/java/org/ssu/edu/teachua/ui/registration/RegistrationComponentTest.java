package org.ssu.edu.teachua.ui.registration;

import org.ssu.edu.teachua.ui.runners.BaseTestRunnerUI;

import org.ssu.edu.teachua.ui.components.modal.SignUpComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.providers.DataProviderRegistration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationComponentTest extends BaseTestRunnerUI {

    @BeforeMethod
    void openRegistrationForm() {
        HomePage homePage = new HomePage(driver);
        homePage.getHeader()
                .openGuestProfileMenu()
                .openRegistrationForm();
    }

    @Test(dataProvider = "registrationData", dataProviderClass = DataProviderRegistration.class)
    public void testRegistrationForm(String lastName, String firstName, String phone,
                                     String email, String password, String confirmPassword) {
        SignUpComponent signUp = new SignUpComponent(driver);
        signUp.enterLastName(lastName)
                .enterFirstName(firstName)
                .enterPhone(phone)
                .enterEmail(email)
                .enterPassword(password)
                .enterConfirmPassword(confirmPassword)
                .clickCloseButton();

        openRegistrationForm();

        Assert.assertEquals(signUp.getLastNameFieldValue(), lastName);
        Assert.assertEquals(signUp.getFirstNameFieldValue(), firstName);
        Assert.assertEquals(signUp.getEmailFieldValue(), email);
        Assert.assertEquals(signUp.getPasswordFieldValue(), password);
        Assert.assertEquals(signUp.getConfirmPasswordFieldValue(), confirmPassword);
    }
}
