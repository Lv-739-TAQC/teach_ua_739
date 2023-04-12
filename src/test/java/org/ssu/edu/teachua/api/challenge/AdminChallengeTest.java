package org.ssu.edu.teachua.api.challenge;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.ssu.edu.teachua.api.clients.ChallengeClient;
import org.ssu.edu.teachua.api.models.challenge.*;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.challenge.PostChallengeResponse;
import org.ssu.edu.teachua.api.models.challenge.PutChallengeRequest;
import org.ssu.edu.teachua.api.models.challenge.PostChallengeResponse;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.utils.StringGenerator;
import org.ssu.edu.teachua.utils.providers.DataProviderChallenge;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminAPIRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

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


    @Issue("TUA-429")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user is able to create challenge using valid data")
    @Test(dataProvider = "dpTestCreateChallengeWithValidData", dataProviderClass = DataProviderChallenge.class)
    public void testCreateChallengeWithValidData(String name, String title, String description, String registrationLink,
                                           String picture, BigInteger sortNumber, Integer expectedStatusCode) {
        PostChallengeRequest postChallengeRequest = new PostChallengeRequest(
                name, title, description, registrationLink, picture, sortNumber);
        Response response = client.createChallenge(postChallengeRequest);
        softAssert.assertEquals((Integer)response.getStatusCode(), expectedStatusCode);
        softAssert.assertAll();
    }

    @Issue("TUA-432")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user is able to update challenge using valid data")
    @Test(dataProvider = "dpTestUpdateChallengeWithValidData", dataProviderClass = DataProviderChallenge.class)
    public void testUpdateChallengeWithValidData(Integer id, String name, String title, String description, String registrationLink,
                                                 String picture, BigInteger sortNumber, Boolean isActive ,Integer expectedStatusCode) {
        PutChallengeRequest putChallengeRequest = new PutChallengeRequest(
                name, title, description, registrationLink, picture, sortNumber,isActive);
        Response response = client.updateChallengePut(id, putChallengeRequest);
        softAssert.assertEquals((Integer)response.getStatusCode(), expectedStatusCode);}

    @Issue("TUA-431")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user is not able to create Challenge" +
            "\nusing null, spaces or absence of symbols as values")
    @Test(dataProvider = "dpTestCreateChallengeInvalidCharacters", dataProviderClass = DataProviderChallenge.class)
    public void testCreateChallengeInvalidCharacters(String invalidValue, BigInteger sortNum, int statusCode) {

        ErrorResponse errorResponse = client.createChallenge(new PostChallengeRequest(invalidValue,
                invalidValue, invalidValue, invalidValue, invalidValue, sortNum)).as(ErrorResponse.class);

        softAssert.assertFalse(errorResponse.getMessage().isEmpty());
        softAssert.assertEquals(errorResponse.getStatus(), statusCode);
        softAssert.assertAll();
    }

    @Issue("TUA-433")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user is not able to edit information " +
            "\nabout Challenge using invalid values")
    @Test(dataProvider = "dpTestEditChallengeInvalidValues", dataProviderClass = DataProviderChallenge.class)
    public void testEditChallengeInvalidValues(int id, String name, String title, String description,
                                               String registrationLink, String picture, BigInteger sortNum,
                                               boolean isActive, int statusCode) {

        ErrorResponse errorResponse = client.updateChallengePut(id, new PutChallengeRequest(name, title,
                description, registrationLink, picture, sortNum, isActive)).as(ErrorResponse.class);

        softAssert.assertFalse(errorResponse.getMessage().isEmpty());
        softAssert.assertEquals(errorResponse.getStatus(), statusCode);
        softAssert.assertAll();
    }

    @Issue("TUA-434")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user is not able to edit information " +
            "\nabout Challenge using null, spaces or absence of symbols as values")
    @Test(dataProvider = "dpTestEditChallengeInvalidCharacters", dataProviderClass = DataProviderChallenge.class)
    public void testEditChallengeInvalidCharacters(int id, String invalidValue, BigInteger sortNum, boolean isActive, int statusCode) {

        ErrorResponse errorResponse = client.updateChallengePut(id, new PutChallengeRequest(invalidValue,
                invalidValue, invalidValue, invalidValue, invalidValue, sortNum, isActive)).as(ErrorResponse.class);

        softAssert.assertFalse(errorResponse.getMessage().isEmpty());
        softAssert.assertEquals(errorResponse.getStatus(), statusCode);}

    @Issue("TUA-438")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user with any rights can view challenge list (admin rights)")
    @Test
    public void testViewChallengeListWithAdminRights() {
        Response response = client.getAllChallenges();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
