package org.ssu.edu.teachua.api.profile;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.utils.providers.DataProviderProfilePage;
import org.ssu.edu.teachua.utils.runners.LoginWithUserAPIRunner;
import org.testng.annotations.Test;

import java.util.List;

public class UserProfileTest extends LoginWithUserAPIRunner {

    @Issue("TUA-750")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that user cannot change password after leaving empty fields in the 'Change password' pop-up")
    @Test (dataProvider = "dpTestIfPasswordIsNotUpdated", dataProviderClass = DataProviderProfilePage.class)
    public void testIfPasswordIsNotUpdated(String newPassword, String oldPassword, String emptyField, int expectedStatusCode, List<String> expectedMsg) {
//API

        softAssert.assertEquals(1, expectedMsg.get(0));
        softAssert.assertEquals(1, expectedMsg.get(1));
        softAssert.assertEquals(1, expectedMsg.get(2));
        softAssert.assertEquals(1, expectedStatusCode);
        softAssert.assertAll();
    }
}
