package org.ssu.edu.teachua.api.club;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.ssu.edu.teachua.api.models.club.ClubRequest;
import org.ssu.edu.teachua.api.clients.ClubClient;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.api.models.location.Location;
import org.ssu.edu.teachua.api.models.url_gallery.UrlGallery;
import org.ssu.edu.teachua.utils.providers.DataProviderClub;
import org.ssu.edu.teachua.utils.runners.LoginWithLeadAPIRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class LeadClubTest extends LoginWithLeadAPIRunner {
    private final ClubClient client = new ClubClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);

    @Issue("TUA-501")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that User as 'Керiвник гуртка' cannot create new club is in " +
            "a center with Russian alphabet for 'Назва' field")
    @Test(dataProvider = "dpTestInvalidNameFieldForClub", dataProviderClass = DataProviderClub.class)
    public void testCreateClubWithInvalidName (int id, ArrayList<String> categoriesName, String name, int ageFrom,
                                               int ageTo, String urlLogo, String urlBackground, boolean status,
                                               String description, int userId, ArrayList<Location> locations,
                                               ArrayList<UrlGallery> urlGallery, String contacts, int centerId,
                                               int centerExternalId, int clubExternalId, boolean isApproved,
                                               int expectedStatusCode, String expectedErrorMsg) {
        SoftAssert softAssert = new SoftAssert();

        ClubRequest request = new ClubRequest( id, name, description, centerId,
                categoriesName, locations, ageFrom, ageTo, urlBackground, urlLogo, urlGallery,
                status, contacts, isApproved, userId, clubExternalId, centerExternalId
        );
        ErrorResponse errorResponse = client.createClub(request).as(ErrorResponse.class);

        softAssert.assertEquals(errorResponse.getStatus(), expectedStatusCode);
        softAssert.assertEquals(errorResponse.getMessage(), expectedErrorMsg);
        softAssert.assertAll();
    }
}
