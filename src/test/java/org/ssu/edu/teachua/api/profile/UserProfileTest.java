package org.ssu.edu.teachua.api.profile;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.ssu.edu.teachua.api.clients.ProfileClient;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.api.models.profile.ProfilePutRequest;
import org.ssu.edu.teachua.utils.providers.DataProviderProfilePage;
import org.ssu.edu.teachua.utils.runners.LoginWithUserAPIRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserProfileTest extends LoginWithUserAPIRunner {

    private ProfileClient client;

    @BeforeMethod
    public void initClient() {
        client = new ProfileClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

    @Issue("TUA-415")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test case verifies that user can not save changes with invalid" +
                 "\n data where edit profile (fields lastName and firstName)")
    @Test(dataProvider = "dpTestUpdateFirstLastNamesInvalid", dataProviderClass = DataProviderProfilePage.class)
    public void testUpdateFirstLastNamesInvalid(int id, String firstName, String lastName, String email,
                                                String phone, String roleName, String urlLogo, boolean status,
                                                int expectedStatusCode, String expectedErrorMsg) {
        SoftAssert dpSoftAssert = new SoftAssert();

        ProfilePutRequest profilePutRequest = new ProfilePutRequest(
                firstName, lastName, email, phone, roleName, urlLogo, status
        );
        ErrorResponse errorResponse = client.updateProfile(id, profilePutRequest).as(ErrorResponse.class);

        dpSoftAssert.assertEquals(errorResponse.getStatus(), expectedStatusCode);
        dpSoftAssert.assertEquals(errorResponse.getMessage(), expectedErrorMsg);
        dpSoftAssert.assertAll();
    }
}
