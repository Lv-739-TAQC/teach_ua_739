package org.ssu.edu.teachua.api.challenge;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.clients.ChallengeClient;
import org.ssu.edu.teachua.api.models.challenge.GetChallengeResponse;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.utils.runners.LoginWithUserAPIRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigInteger;

public class UserChallengeTest extends LoginWithUserAPIRunner {

    private ChallengeClient client;

    @BeforeClass
    private void initClient() {
        client = new ChallengeClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

    @Issue("TUA-437")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user with any rights can view" +
                 "\ninformation about specific challenge (user rights)")
    @Test
    public void testViewChallengeWithUserRights() {
        Response response = client.viewChallenge(826);
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(response.as(GetChallengeResponse.class).getId(), BigInteger.valueOf(826));
        softAssert.assertEquals(response.as(GetChallengeResponse.class).getName(), "Ukrainian");

        softAssert.assertAll();
    }

    @Issue("TUA-436")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user is not able to delete challenge " +
                 "\nusing non-administrator rights")
    @Test
    public void testDeleteChallengeInvalid() {
        ErrorResponse errorResponse = client.deleteChallenge(826).as(ErrorResponse.class);

        softAssert.assertEquals(errorResponse.getStatus(), 403);
        softAssert.assertEquals(errorResponse.getMessage(), "You are not authenticated");

        softAssert.assertAll();
    }

    @Issue("TUA-438")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user with any rights can view challenge list (user rights)")
    @Test
    public void testViewChallengeListWithUserRights() {
        Response response = client.getAllChallenges();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
