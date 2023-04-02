package org.ssu.edu.teachua.api.club;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.ssu.edu.teachua.api.clients.ClubClient;
import org.ssu.edu.teachua.api.models.club.ClubRequest;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.utils.providers.DataProviderClub;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminAPIRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigInteger;
import java.util.ArrayList;

public class AdminClubTest extends LoginWithAdminAPIRunner {

    private final ClubClient client = new ClubClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);

    @Issue("TUA-749")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user cannot create club" +
            "\nentering Russian characters in the 'description field'")
    @Test(dataProvider = "pdTestCreateClubDescriptionInvalid", dataProviderClass = DataProviderClub.class)
    public void testCreateClubDescriptionInvalid(ArrayList<String> categoriesName, String name, int ageForm,
                                                 int ageTo, boolean isOnline, ArrayList<String> contacts,
                                                 String description, ArrayList<String> locations, BigInteger userId,
                                                 int expectedStatusCode, String expectedErrorMsg) {
        SoftAssert dpSoftAssert = new SoftAssert();

        ClubRequest clubRequest = new ClubRequest(
                categoriesName, name, ageForm, ageTo, isOnline, contacts, description, locations, userId
        );
        ErrorResponse errorResponse = client.createClub(clubRequest).as(ErrorResponse.class);

        dpSoftAssert.assertEquals(errorResponse.getStatus(), expectedStatusCode);
        dpSoftAssert.assertEquals(errorResponse.getMessage(), expectedErrorMsg);
        dpSoftAssert.assertAll();
    }
}
