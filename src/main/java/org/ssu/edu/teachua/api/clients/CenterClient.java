package org.ssu.edu.teachua.api.clients;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.center.CenterPutRequest;
import org.ssu.edu.teachua.api.models.center.CenterRequest;

public class CenterClient extends BaseClient {

    private final String path = "/api/center";

    public CenterClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }

    @Step("Create a request for creating new center entity using 'POST' method. Enter values in 'Body': {request}")
    public Response createCenter(CenterRequest request) {
        return prepareRequest()
                .body(request)
                .when()
                .post(path);
    }

    @Step("Create a request for updating an existing center entity using 'PUT' method and center id {id} as parameter. Enter values in 'Body': {request}")
    public Response editCenter(CenterPutRequest request, int id) {
        return prepareRequest()
                .body(request)
                .when()
                .put(path + "/" + id);
    }

    @Step("Create a request for delete center entity using 'DELETE' method. Enter values in 'parameter Id': {id}")
    public Response deleteCenter(int id) {
        return prepareRequest()
                .when()
                .delete(path + "/" + id);
    }

}
