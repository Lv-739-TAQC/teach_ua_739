package org.ssu.edu.teachua.api.challenge;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.ssu.edu.teachua.api.clients.ChallengeClient;
import org.ssu.edu.teachua.api.models.challenge.PostChallengeRequest;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.utils.providers.DataProviderChallenge;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminAPIRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ChallengeTest extends LoginWithAdminAPIRunner {

    private ChallengeClient client;

    @BeforeClass
    private void initClient() {
        client = new ChallengeClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

    @Issue("TUA-751")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that user can not create Challenge after entering invalid data into \"Name\" field")
    @Test(dataProvider = "dpTestIfChallengeIsNotCreated", dataProviderClass = DataProviderChallenge.class)
    public void testIfChallengeNotCreated(String title, String description, String link, String picturePath, int sortNumber, List<String> invalidNames, List<String> expectedMsg, int expectedStatusCode) {

        PostChallengeRequest requestFirst = new PostChallengeRequest(invalidNames.get(0), title, description, link, picturePath, sortNumber);
        ErrorResponse responseFirst = client.createChallenge(requestFirst).as(ErrorResponse.class);

        PostChallengeRequest requestSecond = new PostChallengeRequest(invalidNames.get(1), title, description, link, picturePath, sortNumber);
        ErrorResponse responseSecond = client.createChallenge(requestSecond).as(ErrorResponse.class);

        PostChallengeRequest requestThird = new PostChallengeRequest(invalidNames.get(2), title, description, link, picturePath, sortNumber);
        ErrorResponse responseThird = client.createChallenge(requestThird).as(ErrorResponse.class);

        PostChallengeRequest requestFourth = new PostChallengeRequest(invalidNames.get(3), title, description, link, picturePath, sortNumber);
        ErrorResponse responseFourth = client.createChallenge(requestFourth).as(ErrorResponse.class);

        softAssert.assertEquals(responseFirst.getMessage(), expectedMsg.get(0));
        softAssert.assertEquals(responseFirst.getStatus(), expectedStatusCode);
        softAssert.assertEquals(responseSecond.getMessage(), expectedMsg.get(1));
        softAssert.assertEquals(responseSecond.getStatus(), expectedStatusCode);
        softAssert.assertEquals(responseThird.getMessage(), expectedMsg.get(2));
        softAssert.assertEquals(responseThird.getStatus(), expectedStatusCode);
        softAssert.assertEquals(responseFourth.getMessage(), expectedMsg.get(3));
        softAssert.assertEquals(responseFourth.getStatus(), expectedStatusCode);
        softAssert.assertAll();
    }
}
