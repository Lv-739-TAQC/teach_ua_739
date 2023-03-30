package org.ssu.edu.teachua.api.clients;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.club.ClubRequest;

public class ClubClient extends BaseClient {

    public ClubClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }

    private final String path = "/api/club";

    public Response createClub(ClubRequest request) {
        return prepareRequest()
                .body(request)
                .when()
                .post(path);
    }

    public Response editClub(ClubRequest request, int id) {
        return prepareRequest()
                .body(request)
                .when()
                .put(path + "/" + id);
    }

    public Response viewClub(int id) {
        return prepareRequest()
                .when()
                .get(path + "/" + id);
    }

    public Response deleteClub(int id) {
        return prepareRequest()
                .when()
                .delete(path + "/" + id);
    }

}
