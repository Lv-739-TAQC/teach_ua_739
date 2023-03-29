package org.ssu.edu.teachua.api.clients;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.club.ClubRequest;

public class ClubClient extends BaseClient {

    public ClubClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }

    private final String path = "/api/club";

    public Response createClub(int id, int ageFrom, int ageTo, String name, String description, String urlWeb, String urlLogo,
                               String urlBackground, String workTime, double rating, int feedbackCount, boolean isOnline,
                               boolean isApproved, String contacts, int clubExternalId, int centerExternalId) {
        ClubRequest request = new ClubRequest(id, ageFrom, ageTo, name, description, urlWeb, urlLogo, urlBackground, workTime,
                rating, feedbackCount, isOnline, isApproved, contacts, clubExternalId, centerExternalId);
        return prepareRequest()
                .body(request)
                .when()
                .post(path + "/" + id);
    }

    public Response editClub(int id, int ageFrom, int ageTo, String name, String description, String urlWeb, String urlLogo,
                             String urlBackground, String workTime, double rating, int feedbackCount, boolean isOnline,
                             boolean isApproved, String contacts, int clubExternalId, int centerExternalId) {
        ClubRequest request = new ClubRequest(id, ageFrom, ageTo, name, description, urlWeb, urlLogo, urlBackground, workTime,
                rating, feedbackCount, isOnline, isApproved, contacts, clubExternalId, centerExternalId);
        return prepareRequest()
                .body(request)
                .when()
                .put(path + "/" + id);
    }

    public Response viewClub(int id, int ageFrom, int ageTo, String name, String description, String urlWeb, String urlLogo,
                             String urlBackground, String workTime, double rating, int feedbackCount, boolean isOnline,
                             boolean isApproved, String contacts, int clubExternalId, int centerExternalId) {
        ClubRequest request = new ClubRequest(id, ageFrom, ageTo, name, description, urlWeb, urlLogo, urlBackground, workTime,
                rating, feedbackCount, isOnline, isApproved, contacts, clubExternalId, centerExternalId);
        return prepareRequest()
                .body(request)
                .when()
                .get(path + "/" + id);
    }

    public Response deleteClub(int id, int ageFrom, int ageTo, String name, String description, String urlWeb, String urlLogo,
                               String urlBackground, String workTime, double rating, int feedbackCount, boolean isOnline,
                               boolean isApproved, String contacts, int clubExternalId, int centerExternalId) {
        ClubRequest request = new ClubRequest(id, ageFrom, ageTo, name, description, urlWeb, urlLogo, urlBackground, workTime,
                rating, feedbackCount, isOnline, isApproved, contacts, clubExternalId, centerExternalId);
        return prepareRequest()
                .body(request)
                .when()
                .delete(path + "/" + id);
    }

}
