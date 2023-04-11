package org.ssu.edu.teachua.api.center;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.clients.CenterClient;
import org.ssu.edu.teachua.api.models.center.CenterPostResponse;
import org.ssu.edu.teachua.api.models.center.CenterPutRequest;
import org.ssu.edu.teachua.api.models.center.CenterRequest;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.api.models.location.Location;
import org.ssu.edu.teachua.utils.StringGenerator;
import org.ssu.edu.teachua.utils.providers.DataProviderCentre;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminAPIRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AdminCenterTest extends LoginWithAdminAPIRunner {
    private CenterClient client;

    @BeforeClass
    private void initClient() {
        client = new CenterClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

    private Integer getNewCenterId() {
        String name = "API testing center edition";
        name += StringGenerator.generateRandomString(5);
        Location location = new Location(0, "location23", "test321", "Київ", "Дарницький", "Вирлиця", "49.829104498711104, 24.005058710351314", "0563339988");
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(location);
        ArrayList<Integer> clubsId = new ArrayList<>();
        clubsId.add(37);
        CenterRequest centerRequestCreate = new CenterRequest();
        centerRequestCreate.setName(name);
        centerRequestCreate.setLocations(locations);
        centerRequestCreate.setDescription("Testing description field of the center.");
        centerRequestCreate.setUserId("1");
        centerRequestCreate.setContacts("0563339988");
        centerRequestCreate.setClubsId(clubsId);
        Response okResponseCreate = client.createCenter(centerRequestCreate);
        softAssert.assertEquals(okResponseCreate.getStatusCode(), 200);
        CenterPostResponse centerResponse = okResponseCreate.as(CenterPostResponse.class);
        Integer id = centerResponse.getId();
        return id;
    }

    @Issue("TUA-754")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that user cannot edit description field with less or more than required amount or invalid symbols")
    @Test(dataProvider = "pdTestCreateCenterDescriptionInvalid", dataProviderClass = DataProviderCentre.class)

    public void testCreateCenterDescriptionInvalid(String name, ArrayList<Location> locations, String description,
                                                   String contacts, ArrayList<Integer> clubsId, String expectedErrorMsg) {
        CenterPutRequest invalidDescriptionRequest = new CenterPutRequest(
                name, locations, description, contacts, clubsId
        );

        Response putResponse = client.editCenter(invalidDescriptionRequest, getNewCenterId());
        ErrorResponse errorResponse = putResponse.as(ErrorResponse.class);

        softAssert.assertEquals(putResponse.statusCode(), 400);
        softAssert.assertEquals(errorResponse.getStatus(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), expectedErrorMsg);
        softAssert.assertAll();

    }
}
