package org.ssu.edu.teachua.api.club;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.clients.ClubClient;
import org.ssu.edu.teachua.api.models.club.ClubRequest;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.api.models.location.Location;
import org.ssu.edu.teachua.utils.providers.DataProviderClub;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.clients.ClubClient;
import org.ssu.edu.teachua.api.models.club.ClubRequest;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.api.models.location.Location;
import org.ssu.edu.teachua.utils.providers.DataProviderClub;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminAPIRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigInteger;
import java.util.ArrayList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AdminClubTest extends LoginWithAdminAPIRunner {

    private ClubClient client;

    @BeforeClass
    private void initClient() {
        client = new ClubClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

    @Issue("TUA-749")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user cannot create club" +
            "\nentering Russian characters in the 'description field'")
    @Test(dataProvider = "pdTestCreateClubDescriptionInvalid", dataProviderClass = DataProviderClub.class)
    public void testCreateClubDescriptionInvalid(ArrayList<String> categoriesName, String name, Integer ageFrom,
                                                 Integer ageTo, Boolean isOnline, String description, String userId,
                                                 ArrayList<Location> locations, String contacts,
                                                 int expectedStatusCode, String expectedErrorMsg) {
        ClubRequest clubRequest = new ClubRequest(
                categoriesName, name, ageFrom, ageTo, isOnline, description, userId, locations, contacts
        );
        ErrorResponse errorResponse = client.createClub(clubRequest).as(ErrorResponse.class);

        softAssert.assertEquals(errorResponse.getStatus(), expectedStatusCode);
        softAssert.assertEquals(errorResponse.getMessage(), expectedErrorMsg);
        softAssert.assertAll();
    }

    @Issue("TUA-759")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that Admin cannot create club with invalid name data")
    @Test(dataProvider = "dpApiTestEditClubInvalidData", dataProviderClass = DataProviderClub.class)
    public void testCreateClubWithInvalidData(List<String> categoriesName, String name, int ageFrom,
                                              int ageTo, boolean isOnline, List<String> contacts,
                                              String description, List<String> locations, Integer userId, String expectedErrorMsg) {

        ClubRequest invalidDataRequest = new ClubRequest(categoriesName, name, ageFrom, ageTo, isOnline, contacts, description, locations, userId);
    public void testCreateClubWithInvalidData(ArrayList<String> categoriesName, String name, Integer ageFrom,
                                              Integer ageTo, Boolean isOnline, String description, String userId,
                                              ArrayList<Location> locations, String contacts, String expectedErrorMsg) {
        ClubRequest invalidDataRequest = new ClubRequest(categoriesName, name, ageFrom, ageTo, isOnline, description, userId, locations, contacts);
        Response postResponse = client.createClub(invalidDataRequest);
        ErrorResponse errorResponse = postResponse.as(ErrorResponse.class);

        softAssert.assertEquals(postResponse.statusCode(), 400);
        softAssert.assertEquals(errorResponse.getStatus(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), expectedErrorMsg);

        softAssert.assertAll();

    }

    @Issue(value = "TUA-469")
    @Description(value = "Verify that the duplicate club cannot be created")
    @Test(dataProvider = "dpTestDuplicateClubCannotBeCreated", dataProviderClass = DataProviderClub.class)
    public void verifyThatTheDuplicateClubCannotBeCreated(String category, String name, Integer ageFrom, Integer ageTo,
                                                          String description, int statusCode, String errorMessage) {

        ClubRequest clubRequest = new ClubRequest();
        clubRequest.setName(name);
        clubRequest.setDescription(description);
        clubRequest.setAgeFrom(ageFrom);
        clubRequest.setAgeTo(ageTo);

        ArrayList<String> categoriesName = new ArrayList<>();
        categoriesName.add(category);
        clubRequest.setCategoriesName(categoriesName);

        Response response = client.createClub(clubRequest);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        softAssert.assertEquals(errorResponse.getStatus(), statusCode);
        softAssert.assertEquals(errorResponse.getMessage(), errorMessage);
        softAssert.assertAll();
    }
}
