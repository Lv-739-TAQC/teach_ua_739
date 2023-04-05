package org.ssu.edu.teachua.api.clients;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.registration.RegistrationRequest;

public class RegistrationClient extends BaseClient {

    private final String path = "/api/signup";

    public RegistrationClient(String url, ContentType contentType) {
        super(url, contentType);
    }

    @Step("Create a request for adding user using 'POST' method. Enter values in 'Body': {request}")
    public Response registerUser(RegistrationRequest request) {
        return prepareRequest()
                .body(request)
                .when()
                .post(path);
    }

}
