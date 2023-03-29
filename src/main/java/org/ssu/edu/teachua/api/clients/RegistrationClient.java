package org.ssu.edu.teachua.api.clients;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.registration.RegistrationRequest;

public class RegistrationClient extends BaseClient {

    private final String path = "/api/signup";

    public RegistrationClient(String url, ContentType contentType) {
        super(url, contentType);
    }

    public Response registerUser(int id, String firstName, String lastName, String email, String password, String phone, String roleName,
                                 String verificationCode, String urlLogo, boolean status) {
        RegistrationRequest request = new RegistrationRequest(firstName, lastName, email, password, phone, roleName);
        return prepareRequest()
                .body(request)
                .when()
                .post(path);
    }

}
