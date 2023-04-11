package org.ssu.edu.teachua.api.challenge;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.ssu.edu.teachua.api.clients.ChallengeClient;
import org.ssu.edu.teachua.api.models.challenge.PostChallengeRequest;
import org.ssu.edu.teachua.api.models.challenge.GetChallengeResponse;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.challenge.PostChallengeResponse;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.utils.StringGenerator;
import org.ssu.edu.teachua.utils.providers.DataProviderChallenge;
import org.ssu.edu.teachua.utils.providers.DataProviderClub;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminAPIRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.List;

public class AdminChallengeTest extends LoginWithAdminAPIRunner {
    private ChallengeClient client;

    @BeforeMethod
    private void initClient() {
        client = new ChallengeClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

    @Issue("TUA-430")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user is not able to create challenge using invalid data")
    @Test(dataProvider = "dpTestCreateChallengeInvalid", dataProviderClass = DataProviderChallenge.class)
    public void testCreateChallengeInvalid(String name, String title, String description, String registrationLink,
                                           String picture, int sortNumber, int expectedStatusCode) {
        PostChallengeRequest postChallengeRequest = new PostChallengeRequest(
                name, title, description, registrationLink, picture, BigInteger.valueOf(sortNumber)
        );
        ErrorResponse errorResponse = client.createChallenge(postChallengeRequest).as(ErrorResponse.class);

        softAssert.assertFalse(errorResponse.getMessage().isEmpty());
        softAssert.assertEquals(errorResponse.getStatus(), expectedStatusCode);
        softAssert.assertAll();
    }

    @Issue("TUA-437")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user with any rights can view" +
            "\ninformation about specific challenge (admin rights)")
    @Test
    public void testViewChallengeWithAdminRights() {
        Response response = client.viewChallenge(837);
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(response.as(GetChallengeResponse.class).getId(), BigInteger.valueOf(837));
        softAssert.assertEquals(response.as(GetChallengeResponse.class).getName(), "Ukrainian");

        softAssert.assertAll();
    }

    @Issue("TUA-756")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that admin can't create challenge with invalid value that contains Russian letters in 'Назва' field")
    @Test(dataProvider = "dpTestRussianValueNameField", dataProviderClass = DataProviderChallenge.class)
    public void testCreateChallengeWithInvalidName(String name, String title, String description,
                                                   String registrationLink, String picture, BigInteger sortNumber,
                                                   int expectedStatusCode, String expectedErrorMsg) {

        PostChallengeRequest postChallengeRequest = new PostChallengeRequest(
                name, title, description, registrationLink, picture, sortNumber);

        ErrorResponse errorResponse = client.createChallenge(postChallengeRequest).as(ErrorResponse.class);
        softAssert.assertEquals(errorResponse.getStatus(), expectedStatusCode);
        softAssert.assertEquals(errorResponse.getMessage(), expectedErrorMsg);
        softAssert.assertAll();
    }

    @Issue("TUA-757")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that admin can't create challenge leaving empty 'Порядковий номер' field")
    @Test(dataProvider = "dpTestEmptySortNumberField", dataProviderClass = DataProviderChallenge.class)
    public void testCreateChallengeWithEmptySortNumberField(String name, String title, String description,
                                                            String registrationLink, String picture, BigInteger sortNumber,
                                                            int expectedStatusCode, String expectedErrorMsg) {

        PostChallengeRequest postChallengeRequest = new PostChallengeRequest(
                name, title, description, registrationLink, picture, sortNumber);

        ErrorResponse errorResponse = client.createChallenge(postChallengeRequest).as(ErrorResponse.class);
        softAssert.assertEquals(errorResponse.getStatus(), expectedStatusCode);
        softAssert.assertEquals(errorResponse.getMessage(), expectedErrorMsg);
        softAssert.assertAll();
    }

    @Issue("TUA-751")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that user can not create Challenge after entering invalid data into \"Name\" field")
    @Test(dataProvider = "dpTestIfChallengeIsNotCreated", dataProviderClass = DataProviderChallenge.class)
    public void testIfChallengeNotCreated(String title, String description, String link, String picturePath, BigInteger sortNumber, List<String> invalidNames, List<String> expectedMsg, int expectedStatusCode) {

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

    @Issue("TUA-435")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user is able to delete Challenge using administrator rights")
    @Test(dataProvider = "dpTestDeleteChallenge", dataProviderClass = DataProviderChallenge.class)
    public void testDeleteChallenge(String name, String title, String description, String registrationLink,
                                    String picture, BigInteger sortNumber, int expectedStatusCode) {

        name += StringGenerator.generateRandomString(5);
        PostChallengeRequest postChallengeRequest = new PostChallengeRequest(
                name, title, description, registrationLink, picture, sortNumber
        );

        Response okResponseCreate = client.createChallenge(postChallengeRequest);
        PostChallengeResponse challengeResponse = okResponseCreate.as(PostChallengeResponse.class);
        softAssert.assertEquals(okResponseCreate.getStatusCode(), expectedStatusCode);
        Response okResponseDelete = client.deleteChallenge(challengeResponse.getId());
        softAssert.assertEquals(okResponseDelete.getStatusCode(), expectedStatusCode);
        softAssert.assertAll();
    }
}
