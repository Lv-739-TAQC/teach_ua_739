package org.ssu.edu.teachua.api.club;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.clients.ClubClient;
import org.ssu.edu.teachua.api.models.club.ClubRequest;
import org.ssu.edu.teachua.api.models.club.ClubResponse;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.api.models.location.Location;
import org.ssu.edu.teachua.api.models.url_gallery.UrlGallery;
import org.ssu.edu.teachua.utils.providers.DataProviderClub;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminAPIRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigInteger;
import java.util.ArrayList;

public class AdminClubTest extends LoginWithAdminAPIRunner {

    private ClubClient clubClient;
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    private void initClient() {
        clubClient = new ClubClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

    @Issue("TUA-759")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify that Admin cannot create club with invalid name data")
    @Test(dataProvider = "dpApiTestEditClubInvalidData", dataProviderClass = DataProviderClub.class)
    public void testCreateClubWithInvalidData(ArrayList<String> categoriesName, String name, int ageFrom,
                                              int ageTo, boolean isOnline, ArrayList<String> contacts,
                                              String description, ArrayList<String> locations, BigInteger userId, String expectedErrorMsg) {

        ClubRequest invalidDataRequest = new ClubRequest(categoriesName, name, ageFrom, ageTo, isOnline, contacts, description, locations, userId);
        Response postResponse = clubClient.createClub(invalidDataRequest);
        ErrorResponse errorResponse = postResponse.as(ErrorResponse.class);

        softAssert.assertEquals(postResponse.statusCode(), 400);
        softAssert.assertEquals(errorResponse.getStatus(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), expectedErrorMsg);

        softAssert.assertAll();

    }
}
