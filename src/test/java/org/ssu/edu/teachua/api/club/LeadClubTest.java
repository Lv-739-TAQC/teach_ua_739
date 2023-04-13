package org.ssu.edu.teachua.api.club;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.club.ClubRequest;
import org.ssu.edu.teachua.api.clients.ClubClient;
import org.ssu.edu.teachua.api.models.club.ClubResponse;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.api.models.location.Location;
import org.ssu.edu.teachua.utils.StringGenerator;
import org.ssu.edu.teachua.utils.providers.DataProviderClub;
import org.ssu.edu.teachua.utils.runners.LoginWithLeadAPIRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class LeadClubTest extends LoginWithLeadAPIRunner {
    private ClubClient client;

    @BeforeClass
    public void initClient() {
        client = new ClubClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

    @Issue("TUA-501")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that User as 'Керiвник гуртка' cannot create new club is in " +
            "a center with Russian alphabet for 'Назва' field")
    @Test(dataProvider = "dpTestInvalidNameFieldForClub", dataProviderClass = DataProviderClub.class)
    public void testCreateClubWithInvalidName(ArrayList<String> categoriesName, String name, Integer ageFrom,
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

    @Issue("TUA-468")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that the club lead can delete a previously created by him club")
    @Test(dataProvider = "dpTestDeletePreviouslyCreatedClub", dataProviderClass = DataProviderClub.class)
    public void testDeletePreviouslyCreatedClub(ArrayList<String> categoriesName, String name, Integer ageFrom,
                                                Integer ageTo, Boolean isOnline, String description, String userId,
                                                ArrayList<Location> locations, String contacts, int expectedStatusCode) {

        name += StringGenerator.generateRandomString(5);
        ClubRequest clubRequest = new ClubRequest(
                categoriesName, name, ageFrom, ageTo, isOnline, description, userId, locations, contacts
        );

        Response okResponseCreate = client.createClub(clubRequest);
        ClubResponse clubResponse = okResponseCreate.as(ClubResponse.class);
        softAssert.assertEquals(okResponseCreate.getStatusCode(), expectedStatusCode);
        Response okResponseDelete = client.deleteClub(clubResponse.getId());
        softAssert.assertEquals(okResponseDelete.getStatusCode(), expectedStatusCode);
        softAssert.assertAll();
    }

    @Issue("TUA-502")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that lead cannot create new club if name field contain less than 5 characters")
    @Test(dataProvider = "dpAPITestCreateClub", dataProviderClass = DataProviderClub.class)
    public void testClubCreationWithInvalidData(ArrayList<String> categoriesName, String name, Integer ageFrom,
                                                Integer ageTo, Boolean isOnline, String description, String userId,
                                                ArrayList<Location> locations, String contacts, String expectedErrorMessage, int expectedStatusCode) {
        ClubRequest clubRequest = new ClubRequest(categoriesName, name, ageFrom, ageTo, isOnline, description, userId, locations, contacts);
        Response response = client.createClub(clubRequest);
        Assert.assertEquals(response.statusCode(), expectedStatusCode);

        ErrorResponse errorResponse = response.as(ErrorResponse.class);
        Assert.assertEquals(errorResponse.getStatus(), expectedStatusCode);

        String actualErrorMessage = errorResponse.getMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @Issue("TUA-505")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that User as 'Керiвник гуртка' can create new club is in a center if 'Назва' " +
            "field consists of a word length of 100 characters")
    @Test(dataProvider = "dpTestLengthOfName100CharactersForClub", dataProviderClass = DataProviderClub.class)
    public void testCreateClubWithLengthOfName100Characters(ArrayList<String> categoriesName, Integer ageFrom,
                                                            Integer ageTo, Boolean isOnline, String description,
                                                            String userId, ArrayList<Location> locations, String contacts,
                                                            int expectedStatusCode) {

        ClubRequest clubRequest = new ClubRequest(
                categoriesName, StringGenerator.generateRandomString(100), ageFrom, ageTo,
                isOnline, description, userId, locations, contacts
        );

        Response okResponseCreate = client.createClub(clubRequest);
        softAssert.assertEquals(okResponseCreate.getStatusCode(), expectedStatusCode);
        softAssert.assertAll();

    }

    @Issue("TUA-500")
    @Issue("TUA-463")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that User as 'Керiвник гуртка' can create new club is in " +
            "a center using valid characters for 'Назва' field")
    @Test(dataProvider = "dpTestValidNameFieldForClub", dataProviderClass = DataProviderClub.class)
    public void testCreateClubWithValidName(ArrayList<String> categoriesName, String name, Integer ageFrom,
                                            Integer ageTo, Boolean isOnline, String description, String userId,
                                            ArrayList<Location> locations, String contacts, int expectedStatusCode) {
        ClubRequest clubRequest = new ClubRequest(
                categoriesName, name, ageFrom, ageTo, isOnline, description, userId, locations, contacts
        );
        Response response = client.createClub(clubRequest);

        softAssert.assertEquals(response.statusCode(), expectedStatusCode);
        softAssert.assertAll();
    }
}
