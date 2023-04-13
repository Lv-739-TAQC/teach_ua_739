package org.ssu.edu.teachua.cucumber.steps;

import io.restassured.http.ContentType;
import org.ssu.edu.teachua.api.clients.LoginClient;
import org.ssu.edu.teachua.api.clients.ProfileClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.ssu.edu.teachua.api.models.login.SignInResponse;
import org.ssu.edu.teachua.api.models.profile.ProfilePutRequest;
import org.ssu.edu.teachua.api.models.profile.ProfileResponse;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.asserts.SoftAssert;

public class ProfileServiceAPIStep {
    private ProfileClient client = null;
    private TestValueProvider valueProvider = new TestValueProvider();
    private String accessToken = null;
    private ProfileResponse profileResponse = null;
    private SoftAssert softAssert = new SoftAssert();

    @Given("Sign in use email: {string} and password: {string} and get access token")
    public void logInUserAndGetToken(String email, String password){
        accessToken = new LoginClient(valueProvider.getBaseUiUrl(), ContentType.JSON).
                                signIn(email, password).
                                as(SignInResponse.class).
                                getAccessToken();
        client = new ProfileClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

    @When("Update next user profile id: {int}, firstName: {string}, lastName: {string}, email: {string}, phone: {string}, roleName: {string}")
    public void updateProfile(int id, String firstName, String lastName, String email,
                              String phone, String roleName){
        ProfilePutRequest profilePutRequest = new ProfilePutRequest(firstName, lastName, email, phone, roleName,
                "test.jpg", true);
         profileResponse = client.updateProfile(id, profilePutRequest).as(ProfileResponse.class);
    }

    @Then("Check user role, value: {string}")
    public void checkUserParameter(String value){
        softAssert.assertEquals(profileResponse.getRoleName(), value);
        softAssert.assertAll();
    }
}
