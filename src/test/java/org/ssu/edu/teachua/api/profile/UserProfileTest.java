package org.ssu.edu.teachua.api.profile;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.clients.LoginClient;
import org.ssu.edu.teachua.api.clients.ProfileClient;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.api.models.login.SignInResponse;
import org.ssu.edu.teachua.api.models.profile.ProfilePutRequest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.utils.providers.DataProviderProfilePage;
import org.ssu.edu.teachua.utils.runners.LoginWithUserAPIRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class UserProfileTest extends LoginWithUserAPIRunner {

    private ProfileClient client;

    @BeforeClass
    private void initClient() {
        client = new ProfileClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

    @Issue(value = "TUA-421")
    @Description(value = "Verify that user can not save changes where mandatory fields are empty")
    @Test(dataProvider = "dpTestUpdateProfile", dataProviderClass = DataProviderProfilePage.class)
    public void verifyThatUserCanNotSaveChangesWhereMandatoryFieldsAreEmpty(
            String firstName, String lastName, String email, String phone, String roleName, String urlLogo, boolean status,
            int statusCode, String firstNameErrorMessage, String lastNameErrorMessage, String phoneNameErrorMessage
    ) {
        ProfileClient profileClient = new ProfileClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);

        ProfilePutRequest profilePutRequest = new ProfilePutRequest(firstName, lastName, email, phone, roleName, urlLogo, status);
        profilePutRequest.setFirstName(null);
        Response updateResponse = profileClient.updateProfile(userId, profilePutRequest);
        ErrorResponse errorResponse = updateResponse.as(ErrorResponse.class);
        softAssert.assertEquals(errorResponse.getStatus(), statusCode);
        softAssert.assertEquals(errorResponse.getMessage(), firstNameErrorMessage);

        profilePutRequest.setFirstName(firstName);
        profilePutRequest.setLastName(null);
        updateResponse = profileClient.updateProfile(userId, profilePutRequest);
        errorResponse = updateResponse.as(ErrorResponse.class);
        softAssert.assertEquals(errorResponse.getStatus(), statusCode);
        softAssert.assertEquals(errorResponse.getMessage(), lastNameErrorMessage);

        profilePutRequest.setLastName(lastName);
        profilePutRequest.setPhone(null);
        updateResponse = profileClient.updateProfile(userId, profilePutRequest);
        errorResponse = updateResponse.as(ErrorResponse.class);
        softAssert.assertEquals(errorResponse.getStatus(), statusCode);
        softAssert.assertEquals(errorResponse.getMessage(), phoneNameErrorMessage);
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

    @Issue("TUA-415")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test case verifies that user can not save changes with invalid" +
            "\n data where edit profile (fields lastName and firstName)")
    @Test(dataProvider = "dpTestUpdateFirstLastNamesInvalid", dataProviderClass = DataProviderProfilePage.class)
    public void testUpdateFirstLastNamesInvalid(int id, String firstName, String lastName, String email,
                                                String phone, String roleName, String urlLogo, boolean status,
                                                int expectedStatusCode, String expectedErrorMsg) {
        ProfilePutRequest profilePutRequest = new ProfilePutRequest(
                firstName, lastName, email, phone, roleName, urlLogo, status
        );
        ErrorResponse errorResponse = client.updateProfile(id, profilePutRequest).as(ErrorResponse.class);

        softAssert.assertEquals(errorResponse.getStatus(), expectedStatusCode);
        softAssert.assertEquals(errorResponse.getMessage(), expectedErrorMsg);
        softAssert.assertAll();
    }

    @Issue("TUA-417")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifies that the user cannot change its role to admin role")
    @Test(dataProvider = "dpAPITestChangeRole", dataProviderClass = DataProviderProfilePage.class)
    public void testRoleChange(int id, String firstName, String lastName, String email, String phone, String roleName, String urlLogo, boolean status,int expectedStatusCode) {
        ProfilePutRequest putRequest = new ProfilePutRequest(firstName, lastName, email, phone, roleName, urlLogo, status);
        Response response = client.updateProfile(id, putRequest);

        Assert.assertEquals(response.statusCode(), expectedStatusCode);
    }
}

