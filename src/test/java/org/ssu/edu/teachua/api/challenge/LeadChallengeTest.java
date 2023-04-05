package org.ssu.edu.teachua.api.challenge;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.clients.ChallengeClient;
import org.ssu.edu.teachua.api.models.challenge.GetChallengeResponse;
import org.ssu.edu.teachua.utils.runners.LoginWithLeadAPIRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigInteger;

public class LeadChallengeTest extends LoginWithLeadAPIRunner {

    private final int challengeId = 849;
    private ChallengeClient client;

    @BeforeMethod
    private void initClient() {
        client = new ChallengeClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

    @Issue("TUA-437")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user with any rights can view" +
                 "\ninformation about specific challenge (lead rights)")
    @Test
    public void testViewChallengeWithLeadRights() {
        SoftAssert dpSoftAssert = new SoftAssert();

        Response response = client.viewChallenge(challengeId);
        dpSoftAssert.assertEquals(response.getStatusCode(), 200);
        dpSoftAssert.assertEquals(response.as(GetChallengeResponse.class).getId(), BigInteger.valueOf(challengeId));
        dpSoftAssert.assertEquals(response.as(GetChallengeResponse.class).getName(), "Ukrainian");

        dpSoftAssert.assertAll();
    }
}