package org.ssu.edu.teachua.api.clients;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.profile.ProfileRequest;

public class ProfileClient extends BaseClient{

    private final String path = "/api/user";

    public ProfileClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }

    public Response updateProfile(String id, String firstName, String lastName, String email, String phone, String roleName, String urlLogo, boolean status) {
        ProfileRequest request = new ProfileRequest(firstName, lastName, email, phone, roleName, urlLogo, status);
        return prepareRequest()
                .body(request)
                .when()
                .put(path + "/" + id);
    }
}
