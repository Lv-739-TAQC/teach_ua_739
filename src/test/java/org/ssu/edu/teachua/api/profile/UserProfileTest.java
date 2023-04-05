package org.ssu.edu.teachua.api.profile;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.clients.LoginClient;
import org.ssu.edu.teachua.api.clients.ProfileClient;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.api.models.login.SignInResponse;
import org.ssu.edu.teachua.api.models.profile.ProfilePutRequest;
import org.ssu.edu.teachua.utils.providers.DataProviderProfilePage;
import org.ssu.edu.teachua.utils.runners.LoginWithUserAPIRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserProfileTest extends LoginWithUserAPIRunner {

    private LoginClient loginClient;

    @BeforeClass
    private void initClient() {
        loginClient = new LoginClient(valueProvider.getBaseUiUrl(), ContentType.JSON);
    }

    @Issue(value = "TUA-421")
    @Description(value = "Verify that user can not save changes where mandatory fields are empty")
    @Test(dataProvider = "dpTestUpdateProfile", dataProviderClass = DataProviderProfilePage.class)
    public void verifyThatUserCanNotSaveChangesWhereMandatoryFieldsAreEmpty(
            String firstName, String lastName, String email, String phone, String roleName, String urlLogo, boolean status,
            int statusCode, String firstNameErrorMessage, String lastNameErrorMessage, String phoneNameErrorMessage
    ) {
        Response response = loginClient.signIn(valueProvider.getSomeUserEmail(), valueProvider.getSomeUserPassword());
        SignInResponse signInResponse = response.as(SignInResponse.class);

        ProfileClient profileClient = new ProfileClient(valueProvider.getBaseUiUrl(), ContentType.JSON, signInResponse.getAccessToken());

        ProfilePutRequest profilePutRequest = new ProfilePutRequest(firstName, lastName, email, phone, roleName, urlLogo, status);
        profilePutRequest.setFirstName(null);
        Response updateResponse = profileClient.updateProfile(signInResponse.getId(), profilePutRequest);
        ErrorResponse errorResponse = updateResponse.as(ErrorResponse.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorResponse.getStatus(), statusCode);
        softAssert.assertEquals(errorResponse.getMessage(), firstNameErrorMessage);

        profilePutRequest.setFirstName(firstName);
        profilePutRequest.setLastName(null);
        updateResponse = profileClient.updateProfile(signInResponse.getId(), profilePutRequest);
        errorResponse = updateResponse.as(ErrorResponse.class);
        softAssert.assertEquals(errorResponse.getStatus(), statusCode);
        softAssert.assertEquals(errorResponse.getMessage(), lastNameErrorMessage);

        profilePutRequest.setLastName(lastName);
        profilePutRequest.setPhone(null);
        updateResponse = profileClient.updateProfile(signInResponse.getId(), profilePutRequest);
        errorResponse = updateResponse.as(ErrorResponse.class);
        softAssert.assertEquals(errorResponse.getStatus(), statusCode);
        softAssert.assertEquals(errorResponse.getMessage(), phoneNameErrorMessage);
        softAssert.assertAll();
    }
}
