package org.ssu.edu.teachua.api.clients;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.login.SingInRequest;

public class LoginClient extends BaseClient{
    private final String path = "/api/signin";
    public LoginClient(String url, ContentType contentType) {
        super(url, contentType);
    }

    public Response signIn(String email, String password) {
        SingInRequest request = new SingInRequest(email, password);
        return prepareRequest()
                .body(request)
                .when()
                .post(path);
    }
}
