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
import org.ssu.edu.teachua.utils.runners.LoginWithAdminAPIRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigInteger;
import java.util.ArrayList;

public class AdminClubTest extends LoginWithAdminAPIRunner {

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

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorResponse.getStatus(), statusCode);
        softAssert.assertEquals(errorResponse.getMessage(), errorMessage);
        softAssert.assertAll();
    }
}
