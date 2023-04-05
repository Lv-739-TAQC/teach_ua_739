package org.ssu.edu.teachua.api.challenge;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.ssu.edu.teachua.api.clients.ChallengeClient;
import org.ssu.edu.teachua.api.models.challenge.PostChallengeRequest;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.utils.providers.DataProviderChallenge;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminAPIRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdminChallengeTest extends LoginWithAdminAPIRunner {
    private ChallengeClient client;

    @BeforeMethod
    private void initClient() {
        client = new ChallengeClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

    @Issue("TUA-756")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that admin can't create challenge with invalid value that contains Russian letters in 'Назва' field")
    @Test(dataProvider = "dpTestRussianValueNameField", dataProviderClass = DataProviderChallenge.class)
    public void testCreateChallengeWithInvalidName ( String name, String title, String description,
                                                    String registrationLink, String picture, String sortNumber,
                                                     int expectedStatusCode, String expectedErrorMsg){
        SoftAssert softAssert = new SoftAssert();

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
    public void testCreateChallengeWithEmptySortNumberField ( String name, String title, String description,
                                                     String registrationLink, String picture, String sortNumber,
                                                     int expectedStatusCode, String expectedErrorMsg){
        SoftAssert softAssert = new SoftAssert();

        PostChallengeRequest postChallengeRequest = new PostChallengeRequest(
                name, title, description, registrationLink, picture, sortNumber);

        ErrorResponse errorResponse = client.createChallenge(postChallengeRequest).as(ErrorResponse.class);
        softAssert.assertEquals(errorResponse.getStatus(), expectedStatusCode);
        softAssert.assertEquals(errorResponse.getMessage(), expectedErrorMsg);
        softAssert.assertAll();
    }

}
