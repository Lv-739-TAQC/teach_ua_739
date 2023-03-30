package org.ssu.edu.teachua.api.registraton;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.ClubService;
import org.ssu.edu.teachua.db.service.UserService;
import org.ssu.edu.teachua.utils.providers.DataProviderRegistration;
import org.ssu.edu.teachua.utils.runners.BaseTestRunnerAPI;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegistrationTest extends BaseTestRunnerAPI {

    protected SoftAssert softAssert = new SoftAssert();

    @Issue("TUA-499")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that user with invalid data in \"Пароль\" field can`t be created")
    @Test(dataProvider = "dpTestIfUserNotCreated", dataProviderClass = DataProviderRegistration.class)
    public void testIfUserNotCreated(String firstName, String lastName, String email, String password, String phone, String roleName,
                                     int expectedStatusCode, String expectedMsg) throws DBException, EntityException {
///API
        UserService userService = entityService.getUserService();

        softAssert.assertEquals(1, expectedMsg);
        softAssert.assertEquals(1, expectedStatusCode);
        softAssert.assertEquals(entityService.getUserService().getUsersByEmail(email).size(), 0);
        softAssert.assertAll();
    }
}
