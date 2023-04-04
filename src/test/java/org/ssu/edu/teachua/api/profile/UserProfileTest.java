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
import org.ssu.edu.teachua.utils.runners.LoginWithUserAPIRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserProfileTest extends LoginWithUserAPIRunner {

    private static final String FIRST_NAME = "Nastia";
    private static final String LAST_NAME = "Kukh";
    private static final String EMAIL = "soyec48727@busantei.com";
    private static final String PHONE = "999999922";
    private static final String ROLE_NAME = "ROLE_MANAGER";
    private static final String URL_LOGO = null;
    private static final boolean STATUS = true;

    private LoginClient loginClient;

    @BeforeClass
    private void initClient() {
        loginClient = new LoginClient(valueProvider.getBaseUiUrl(), ContentType.JSON);
    }

    @Issue(value = "TUA-421")
    @Description(value = "Verify that user can not save changes where mandatory fields are empty")
    @Test
    public void verifyThatUserCanNotSaveChangesWhereMandatoryFieldsAreEmpty() {
        Response response = loginClient.signIn(valueProvider.getSomeUserEmail(), valueProvider.getSomeUserPassword());
        SignInResponse signInResponse = response.as(SignInResponse.class);

        ProfileClient profileClient = new ProfileClient(valueProvider.getBaseUiUrl(), ContentType.JSON, signInResponse.getAccessToken());

        ProfilePutRequest profilePutRequest = new ProfilePutRequest(FIRST_NAME, LAST_NAME, EMAIL, PHONE, ROLE_NAME, URL_LOGO, STATUS);
        profilePutRequest.setFirstName(null);
        Response updateResponse = profileClient.updateProfile(signInResponse.getId(), profilePutRequest);
        ErrorResponse errorResponse = updateResponse.as(ErrorResponse.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorResponse.getStatus(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), "\"firstName\" can`t be null");

        profilePutRequest.setFirstName(FIRST_NAME);
        profilePutRequest.setLastName(null);
        updateResponse = profileClient.updateProfile(signInResponse.getId(), profilePutRequest);
        errorResponse = updateResponse.as(ErrorResponse.class);
        softAssert.assertEquals(errorResponse.getStatus(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), "\"lastName\" can`t be null");

        profilePutRequest.setLastName(LAST_NAME);
        profilePutRequest.setPhone(null);
        updateResponse = profileClient.updateProfile(signInResponse.getId(), profilePutRequest);
        errorResponse = updateResponse.as(ErrorResponse.class);
        softAssert.assertEquals(errorResponse.getStatus(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), "phone must not be blank");
        softAssert.assertAll();
    }
}
