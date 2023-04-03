package org.ssu.edu.teachua.api.club;

import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.clients.ClubClient;
import org.ssu.edu.teachua.api.models.club.ClubRequest;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminAPIRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class AdminClubTest extends LoginWithAdminAPIRunner {

    @Description(value = "Verify that the duplicate club cannot be created")
    @Test
    public void verifyThatTheDuplicateClubCannotBeCreated() {
        ClubClient clubClient = new ClubClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
        ClubRequest clubRequest = new ClubRequest();
        ArrayList<String> categoriesName = new ArrayList<>();
        categoriesName.add("Спортивні секції");
        clubRequest.setCategoriesName(categoriesName);
        clubRequest.setName("Спроба1");
        clubRequest.setAgeFrom(2);
        clubRequest.setAgeTo(18);
        clubRequest.setOnline(true);
        clubRequest.setContacts("{}");
        clubRequest.setDescription("{\\\"blocks\\\":[{\\\"key\\\":\\\"brl63\\\",\\\"text\\\":\\\"йййййййййййййййййййййййййййййййййййййййййййййййййййййййййй\\\",\\\"type\\\":\\\"unstyled\\\",\\\"depth\\\":0,\\\"inlineStyleRanges\\\":[],\\\"entityRanges\\\":[],\\\"data\\\":{}}],\\\"entityMap\\\":{}}");
        clubRequest.setLocations(new ArrayList<>());
        clubRequest.setUserId(272);

        Response response = clubClient.createClub(clubRequest);
        ErrorResponse errorResponse = response.as(ErrorResponse.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorResponse.getStatus(), 409);
        softAssert.assertEquals(errorResponse.getMessage(), "Club already exist with name: Спроба1");
        softAssert.assertAll();
    }
}
