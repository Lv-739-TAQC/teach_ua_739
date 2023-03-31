package org.ssu.edu.teachua.utils.runners;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.clients.LoginClient;
import org.ssu.edu.teachua.api.models.login.SignInResponse;
import org.testng.annotations.BeforeClass;


public class LoginWithLeadAPIRunner extends BaseTestRunnerAPI {
    protected String accessToken;
    protected int userId;

    @BeforeClass(description = "Precondition method : get accessToken for Lead account")
    public void getAccessToken() {
        LoginClient client = new LoginClient(valueProvider.getBaseUiUrl(), ContentType.JSON);
        Response response = client.signIn(valueProvider.getLeadEmail(), valueProvider.getLeadPassword());
        SignInResponse signInResponse = response.as(SignInResponse.class);
        accessToken = signInResponse.getAccessToken();
    }

    @BeforeClass (description = "Get 'id' endpoint")
    public void getUserId() {
        LoginClient client = new LoginClient(valueProvider.getBaseUiUrl(), ContentType.JSON);
        Response response = client.signIn(valueProvider.getLeadEmail(), valueProvider.getLeadPassword());
        SignInResponse signInResponse = response.as(SignInResponse.class);
        userId = signInResponse.getId();
    }
}
