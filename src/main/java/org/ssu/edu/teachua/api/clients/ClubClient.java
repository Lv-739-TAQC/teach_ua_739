package org.ssu.edu.teachua.api.clients;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.club.ClubRequest;

public class ClubClient extends BaseClient {

    public ClubClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }

    private final String path = "/api/club";

    public Response createClub(int id, String name, String description, int centerId, String categoriesName, int ageFrom,
                               int ageTo, String urlBackground, String urlLogo, boolean isOnline, String contacts,
                               boolean isApproved, int userId, int clubExternalId, int centerExternalId) {
        ClubRequest request = new ClubRequest(id, name, description, centerId, categoriesName, ageFrom, ageTo, urlBackground,
                urlLogo, isOnline, contacts, isApproved, userId, clubExternalId, centerExternalId);
        return prepareRequest()
                .body(request)
                .when()
                .post();
    }

    public Response editClub(int id, String name, String description, int centerId, String categoriesName, int ageFrom,
                             int ageTo, String urlBackground, String urlLogo, boolean isOnline, String contacts,
                             boolean isApproved, int userId, int clubExternalId, int centerExternalId) {
        ClubRequest request = new ClubRequest(id, name, description, centerId, categoriesName, ageFrom, ageTo, urlBackground,
                urlLogo, isOnline, contacts, isApproved, userId, clubExternalId, centerExternalId);
        return prepareRequest()
                .body(request)
                .when()
                .put(path + "/" + id);
    }

    public Response viewClub(int id) {
        ClubRequest request = new ClubRequest(id);
        return prepareRequest()
                .body(request)
                .when()
                .get(path + "/" + id);
    }

    public Response deleteClub(int id) {
        ClubRequest request = new ClubRequest(id);
        return prepareRequest()
                .body(request)
                .when()
                .delete(path + "/" + id);
    }

}
