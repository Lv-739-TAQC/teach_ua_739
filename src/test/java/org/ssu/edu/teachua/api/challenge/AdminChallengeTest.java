package org.ssu.edu.teachua.api.challenge;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.challenge.GetChallengeResponse;
import org.ssu.edu.teachua.utils.providers.DataProviderChallenge;
import org.testng.annotations.Test;
import org.ssu.edu.teachua.api.clients.ChallengeClient;
import org.ssu.edu.teachua.api.models.challenge.PostChallengeRequest;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminAPIRunner;
import org.testng.asserts.SoftAssert;

import java.math.BigInteger;

public class AdminChallengeTest extends LoginWithAdminAPIRunner {

    private final int viewChallengeId = 837;

    private final ChallengeClient client = new ChallengeClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);

    @Issue("TUA-430")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user is not able to create challenge using invalid data")
    @Test(dataProvider = "dpTestCreateChallengeInvalid", dataProviderClass = DataProviderChallenge.class)
    public void testCreateChallengeInvalid(String name, String title, String description, String registrationLink,
                                           String picture, int sortNumber, int expectedStatusCode) {
        SoftAssert dpSoftAssert = new SoftAssert();

        PostChallengeRequest postChallengeRequest = new PostChallengeRequest(
                name, title, description, registrationLink, picture, sortNumber
        );
        ErrorResponse errorResponse = client.createChallenge(postChallengeRequest).as(ErrorResponse.class);

        dpSoftAssert.assertFalse(errorResponse.getMessage().isEmpty());
        dpSoftAssert.assertEquals(errorResponse.getStatus(), expectedStatusCode);
        dpSoftAssert.assertAll();
    }

    @Issue("TUA-437")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user with any rights can view" +
                 "\ninformation about specific challenge (admin rights)")
    @Test
    public void viewChallengeWithAdminRights() {
        SoftAssert dpSoftAssert = new SoftAssert();

        Response response = client.viewChallenge(viewChallengeId);
        dpSoftAssert.assertEquals(response.getStatusCode(), 200);
        dpSoftAssert.assertEquals(response.as(GetChallengeResponse.class).getId(), BigInteger.valueOf(viewChallengeId));
        dpSoftAssert.assertEquals(response.as(GetChallengeResponse.class).getName(), "Ukrainian");

        dpSoftAssert.assertAll();
    }
}
