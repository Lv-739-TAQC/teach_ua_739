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
import org.ssu.edu.teachua.utils.providers.DataProviderClub;
import org.ssu.edu.teachua.utils.runners.LoginWithLeadAPIRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigInteger;
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
        public void testCreateClubWithInvalidName (ArrayList<String> categoriesName, String name, int ageFrom,
                                                   int ageTo, boolean isOnline, ArrayList<String> contacts,
                                                   String description,ArrayList<String> locations, Integer userId,
                                                   int expectedStatusCode, String expectedErrorMsg) {

            ClubRequest clubRequest = new ClubRequest(
                    categoriesName, name, ageFrom, ageTo, isOnline, contacts, description, locations, userId
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
        public void testDeletePreviouslyCreatedClub(ArrayList<String> categoriesName, String name, int ageFrom,
                                                    int ageTo, boolean isOnline, ArrayList<String> contacts,
                                                    String description, ArrayList<String> locations, Integer userId,
                                                    int expectedStatusCode) {

            ClubRequest clubRequest = new ClubRequest(
                    categoriesName, name, ageFrom, ageTo, isOnline, contacts, description, locations, userId
            );
            Response okResponseCreate = client.createClub(clubRequest);
            ClubResponse clubResponse = okResponseCreate.as(ClubResponse.class);
            softAssert.assertEquals(okResponseCreate.getStatusCode(), expectedStatusCode);
            Response okResponseDelete = client.deleteClub(clubResponse.getId());
            softAssert.assertEquals(okResponseDelete.getStatusCode(), expectedStatusCode);
            softAssert.assertAll();
        }
}
