package org.ssu.edu.teachua.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.clients.LoginClient;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.api.models.login.SignInResponse;
import org.ssu.edu.teachua.utils.runners.BaseTestRunnerAPI;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTestRunnerAPI {
    private LoginClient client;
    @BeforeClass
    private void initClient() {
        client = new LoginClient(valueProvider.getBaseUiUrl(), ContentType.JSON);
    };
    @Test
    public void testSignIn() {
        Response response = client.signIn(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
        SignInResponse signInResponse = response.as(SignInResponse.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(signInResponse.getId(), 1);
        softAssert.assertEquals(signInResponse.getEmail(), valueProvider.getAdminEmail());
        softAssert.assertEquals(signInResponse.getRoleName(),"ROLE_ADMIN");
        softAssert.assertNotNull(signInResponse.getAccessToken());
        softAssert.assertAll();
    }

    @Test
    public void testSignInUnsuccessfulUserNotFound() {
        String email = valueProvider.getAdminEmail() + "foo";
        Response response = client.signIn(email, valueProvider.getAdminPassword());
        ErrorResponse signInResponse = response.as(ErrorResponse.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 404);
        softAssert.assertEquals(signInResponse.getStatus(), 404);
        softAssert.assertEquals(signInResponse.getMessage(), String.format("User not found by email %s", email));
        softAssert.assertAll();
    }
    @Test
    public void testSignInUnsuccessful() {
        String password = valueProvider.getAdminPassword()+"foo";
        Response response = client.signIn(valueProvider.getAdminEmail(), password);
        ErrorResponse signInResponse = response.as(ErrorResponse.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 401);
        softAssert.assertEquals(signInResponse.getStatus(), 401);
        softAssert.assertEquals(signInResponse.getMessage(), "Wrong password");
        softAssert.assertAll();
    }
}
