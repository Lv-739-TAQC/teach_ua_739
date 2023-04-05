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
import org.ssu.edu.teachua.utils.providers.DataProviderClub;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminAPIRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigInteger;
import java.util.ArrayList;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigInteger;
import java.util.ArrayList;

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
    public void testCreateClubDescriptionInvalid(ArrayList<String> categoriesName, String name, int ageForm,
                                                 int ageTo, boolean isOnline, ArrayList<String> contacts,
                                                 String description, ArrayList<String> locations, BigInteger userId,
                                                 int expectedStatusCode, String expectedErrorMsg) {
        ClubRequest clubRequest = new ClubRequest(
                categoriesName, name, ageForm, ageTo, isOnline, contacts, description, locations, userId
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
    public void testCreateClubWithInvalidData(ArrayList<String> categoriesName, String name, int ageFrom,
                                              int ageTo, boolean isOnline, ArrayList<String> contacts,
                                              String description, ArrayList<String> locations, BigInteger userId, String expectedErrorMsg) {

        ClubRequest invalidDataRequest = new ClubRequest(categoriesName, name, ageFrom, ageTo, isOnline, contacts, description, locations, userId);
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
    public void verifyThatTheDuplicateClubCannotBeCreated(
            String category, String name, Integer ageFrom, Integer ageTo, Boolean isOnline, String contacts,
            String description, ArrayList<String> locations, BigInteger userId, int statusCode, String errorMessage
    ) {
        ClubClient clubClient = new ClubClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
        ClubRequest clubRequest = new ClubRequest();
        ArrayList<String> categoriesName = new ArrayList<>();
        categoriesName.add(category);
        clubRequest.setCategoriesName(categoriesName);
        clubRequest.setName(name);
        clubRequest.setAgeFrom(ageFrom);
        clubRequest.setAgeTo(ageTo);
        clubRequest.setOnline(isOnline);
        ArrayList<String> contactsList = new ArrayList<>();
        contactsList.add(contacts);
        clubRequest.setContacts(contactsList);
        clubRequest.setDescription(description);
        clubRequest.setLocations(locations);
        clubRequest.setUserId(userId);

        Response response = clubClient.createClub(clubRequest);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        softAssert.assertEquals(errorResponse.getStatus(), statusCode);
        softAssert.assertEquals(errorResponse.getMessage(), errorMessage);
        softAssert.assertAll();
    }
}
