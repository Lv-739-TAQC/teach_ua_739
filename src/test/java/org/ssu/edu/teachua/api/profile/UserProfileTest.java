package org.ssu.edu.teachua.api.profile;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.clients.ProfileClient;
import org.ssu.edu.teachua.api.models.profile.ProfilePutRequest;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.utils.providers.DataProviderProfilePage;
import org.ssu.edu.teachua.utils.runners.LoginWithUserAPIRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class UserProfileTest extends LoginWithUserAPIRunner {

    private ProfileClient client;

    @BeforeClass
    private void initClient() {
        client = new ProfileClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

    @Issue("TUA-408")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that user can edit profile with valid data")
    @Test(dataProvider = "dpTestIfProfileUpdated", dataProviderClass = DataProviderProfilePage.class)
    public void testIfProfileUpdated(int id, List<String> data, boolean status, String firstName, String lastName, String phone, int expectedStatusCode) throws DBException, EntityException {

        ProfilePutRequest requestEditFirstName = new ProfilePutRequest(firstName, data.get(1), data.get(2), data.get(3), data.get(4), data.get(5), status);
        Response responseEditFirstName = client.updateProfile(id, requestEditFirstName);

        ProfilePutRequest requestEditLastName = new ProfilePutRequest(firstName, lastName, data.get(2), data.get(3), data.get(4), data.get(5), status);
        Response responseEditLastName = client.updateProfile(id, requestEditLastName);

        ProfilePutRequest requestEditPhone = new ProfilePutRequest(firstName, lastName, data.get(2), phone, data.get(4), data.get(5), status);
        Response responseEditPhone = client.updateProfile(id, requestEditPhone);

        softAssert.assertEquals(responseEditFirstName.statusCode(), expectedStatusCode);
        softAssert.assertEquals(responseEditLastName.statusCode(), expectedStatusCode);
        softAssert.assertEquals(responseEditPhone.statusCode(), expectedStatusCode);
        softAssert.assertEquals(entityService.getUserService().getUsersByEmail(data.get(2)).get(0).getFirstName(), firstName);
        softAssert.assertAll();
    }
}
