package org.ssu.edu.teachua.api.club;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.ssu.edu.teachua.api.clients.ClubClient;
import org.ssu.edu.teachua.api.models.club.ClubRequest;
import org.ssu.edu.teachua.api.models.club.ClubResponse;
import org.ssu.edu.teachua.api.models.location.Location;
import org.ssu.edu.teachua.api.models.ok_response.OkResponse;
import org.ssu.edu.teachua.api.models.url_gallery.UrlGallery;
import org.ssu.edu.teachua.utils.providers.DataProviderClub;
import org.ssu.edu.teachua.utils.runners.LoginWithLeadAPIRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class LeadClubTest extends LoginWithLeadAPIRunner {
    private final ClubClient client = new ClubClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);

    @Issue("TUA-468")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that the club lead can delete a previously created by him club")
    @Test(dataProvider = "dpTestDeletePreviouslyCreatedClub", dataProviderClass = DataProviderClub.class)
    public void testDeletePreviouslyCreatedClub(int id, String name, String description, int centerId, ArrayList<String> categoriesName,
                               ArrayList<Location> locations, int ageFrom, int ageTo, String urlBackground, String urlLogo,
                               ArrayList<UrlGallery> urlGallery, boolean isOnline, String contacts, boolean isApproved,
                               int userId, int clubExternalId, int centerExternalId, int expectedStatusCode) {
        SoftAssert softAssert = new SoftAssert();
        ClubRequest clubRequest = new ClubRequest(id, name, description, centerId, categoriesName, locations, ageFrom,
                ageTo, urlBackground, urlLogo, urlGallery, isOnline, contacts, isApproved, userId, clubExternalId, centerExternalId);
        ClubResponse clubResponse = client.createClub(clubRequest).as(ClubResponse.class);
        OkResponse okResponseCreate = client.createClub(clubRequest).as(OkResponse.class);
        softAssert.assertEquals(okResponseCreate.getStatus(), expectedStatusCode);
        client.deleteClub(clubResponse.getId());
        OkResponse okResponseDelete = client.deleteClub(id).as(OkResponse.class);
        softAssert.assertEquals(okResponseDelete.getStatus(), expectedStatusCode);
        softAssert.assertAll();
    }
}
