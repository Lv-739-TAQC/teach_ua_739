package org.ssu.edu.teachua.ui.profile;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.UserService;
import org.ssu.edu.teachua.ui.components.modal.EditProfileComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.providers.DataProviderProfilePage;
import org.ssu.edu.teachua.utils.runners.LoginWithUserUIRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProfilePageUserTest extends LoginWithUserUIRunner {

    private EditProfileComponent editProfile;

    @BeforeMethod(description = "Precondition: open Profile Page")
    void openProfilePagePrecondition() {
        driver.navigate().refresh();
        editProfile = new HomePage(driver)
                .getHeader()
                .openUserProfileMenu()
                .openProfilePage()
                .clickEditProfileButton();
    }

    @Issue("TUA-408")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that user can edit profile with valid data")
    @Test(dataProvider = "dpTestIfProfileIsUpdated", dataProviderClass = DataProviderProfilePage.class)
    public void testIfProfileIsUpdated(List<String> givenData, String firstName, String lastName, String phone, int expectedStatusCode) throws DBException, EntityException {

        UserService userService = entityService.getUserService();

///API
        List<String> actualProfileData = new ArrayList<String>(Arrays.asList(editProfile.getUserFirstName(), editProfile.getUserLastName(), editProfile.getUserPhone()));
        List<String> expectedProfileData = new ArrayList<String>(Arrays.asList(firstName, lastName, phone));

        softAssert.assertEquals(1, expectedStatusCode);
        softAssert.assertEquals(1, expectedStatusCode);
        softAssert.assertEquals(1, expectedStatusCode);
        softAssert.assertEquals(actualProfileData, expectedProfileData);
        softAssert.assertEquals(entityService.getUserService().getUsersByEmail(givenData.get(2)).get(0).getFirstName(), firstName);
        softAssert.assertAll();
    }
}
