package org.ssu.edu.teachua.api.clients;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.club.ClubRequest;

public class ClubClient extends BaseClient {

    public ClubClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }

    private final String path = "/api/club";

    @Step("Create a request for creating new club entity using 'POST' method. Enter values in 'Body': {request}")
    public Response createClub(ClubRequest request) {
        return prepareRequest()
                .body(request)
                .when()
                .post(path);
    }

    @Step("Create a request for updating an existing club entity using 'PUT' method and club id {id} as parameter. Enter values in 'Body': {request}")
    public Response editClub(ClubRequest request, int id) {
        return prepareRequest()
                .body(request)
                .when()
                .put(path + "/" + id);
    }

    @Step("Create a request for viewing an existing club entity using 'GET' method and club id {id} as parameter")
    public Response viewClub(int id) {
        return prepareRequest()
                .when()
                .get(path + "/" + id);
    }

    @Step("Create a request for deleting an existing club entity using 'DELETE' method and club id {id} as parameter")
    public Response deleteClub(int id) {
        return prepareRequest()
                .when()
                .delete(path + "/" + id);
    }

}
