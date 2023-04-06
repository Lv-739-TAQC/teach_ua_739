package org.ssu.edu.teachua.api.club;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AdminClubTest extends LoginWithAdminAPIRunner {

    private ClubClient client;

    @BeforeClass
    private void initClient() {
        client = new ClubClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

//    @Issue("TUA-749")
//    @Severity(SeverityLevel.NORMAL)
//    @Description("This test case verifies that user cannot create club" +
//            "\nentering Russian characters in the 'description field'")
//    @Test(dataProvider = "pdTestCreateClubDescriptionInvalid", dataProviderClass = DataProviderClub.class)
//    public void testCreateClubDescriptionInvalid(ArrayList<String> categoriesName, String name, Integer ageForm,
//                                                 Integer ageTo, boolean isOnline, String contacts,
//                                                 String description, ArrayList<Location> locations, String userId,
//                                                 int expectedStatusCode, String expectedErrorMsg) {
//        ClubRequest clubRequest = new ClubRequest(
//                categoriesName, name, ageForm, ageTo, isOnline, contacts, description, locations, userId
//        );
//        ErrorResponse errorResponse = client.createClub(clubRequest).as(ErrorResponse.class);
//
//        softAssert.assertEquals(errorResponse.getStatus(), expectedStatusCode);
//        softAssert.assertEquals(errorResponse.getMessage(), expectedErrorMsg);
//        softAssert.assertAll();
//    }
//
//    @Issue("TUA-759")
//    @Severity(SeverityLevel.MINOR)
//    @Description("Verify that Admin cannot create club with invalid name data")
//    @Test(dataProvider = "dpApiTestEditClubInvalidData", dataProviderClass = DataProviderClub.class)
//    public void testCreateClubWithInvalidData(ArrayList<String> categoriesName, String name, Integer ageFrom,
//                                              Integer ageTo, boolean isOnline, String contacts,
//                                              String description, ArrayList<Location> locations, String userId, String expectedErrorMsg) {
//
//        ClubRequest invalidDataRequest = new ClubRequest(categoriesName, name, ageFrom, ageTo, isOnline, contacts, description, locations, userId);
//        Response postResponse = client.createClub(invalidDataRequest);
//        ErrorResponse errorResponse = postResponse.as(ErrorResponse.class);
//
//        softAssert.assertEquals(postResponse.statusCode(), 400);
//        softAssert.assertEquals(errorResponse.getStatus(), 400);
//        softAssert.assertEquals(errorResponse.getMessage(), expectedErrorMsg);
//
//        softAssert.assertAll();
//
//    }
}
