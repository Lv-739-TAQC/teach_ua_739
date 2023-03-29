package org.ssu.edu.teachua.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.clients.LoginClient;
import org.ssu.edu.teachua.api.models.login.SingInResponse;
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
    public void testSingIn() {
        Response response = client.signIn(valueProvider.getAdminEmail(), valueProvider.getAdminPassword());
        SingInResponse singInResponse = response.as(SingInResponse.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(singInResponse.getId(), 1);
        softAssert.assertEquals(singInResponse.getEmail(), valueProvider.getAdminEmail());
        softAssert.assertEquals(singInResponse.getRoleName(),"ROLE_ADMIN");
        softAssert.assertNotNull(singInResponse.getAccessToken());
    }
}
