package org.ssu.edu.teachua.api.registraton;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.ssu.edu.teachua.api.clients.RegistrationClient;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.api.models.registration.RegistrationRequest;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.UserService;
import org.ssu.edu.teachua.utils.providers.DataProviderRegistration;
import org.ssu.edu.teachua.utils.runners.BaseTestRunnerAPI;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class RegistrationTest extends BaseTestRunnerAPI {

    private RegistrationClient client;

    @BeforeClass
    private void initClient() {
        client = new RegistrationClient(valueProvider.getBaseUiUrl(), ContentType.JSON);
    }

    @Issue("TUA-499")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that user with invalid data in \"Пароль\" field can`t be created")
    @Test(dataProvider = "dpTestIfUserNotCreated", dataProviderClass = DataProviderRegistration.class)
    public void testIfUserNotCreated(String firstName, String lastName, String email, String password, String phone, String roleName,
                                     int expectedStatusCode, List<String> expectedMsg) throws DBException, EntityException {
        UserService userService = entityService.getUserService();
        RegistrationRequest request = new RegistrationRequest(firstName, lastName, email, password, phone, roleName);
        ErrorResponse registrationResponse = client.registerUser(request).as(ErrorResponse.class);

        softAssert.assertTrue(registrationResponse.getMessage().contains(expectedMsg.get(0)));
        softAssert.assertTrue(registrationResponse.getMessage().contains(expectedMsg.get(1)));
        softAssert.assertTrue(registrationResponse.getMessage().contains(expectedMsg.get(2)));
        softAssert.assertEquals(registrationResponse.getStatus(), expectedStatusCode);
        softAssert.assertEquals(userService.getUsersByEmail(email).size(), 0);
        softAssert.assertAll();
    }
}
