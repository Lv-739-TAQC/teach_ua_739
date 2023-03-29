package org.ssu.edu.teachua.api.clients;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.profile.ProfilePatchRequest;
import org.ssu.edu.teachua.api.models.profile.ProfilePutRequest;

public class ProfileClient extends BaseClient{

    private final String path = "/api/user";

    public ProfileClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }

    public Response updateProfile(String id, String firstName, String lastName, String email, String phone, String roleName, String urlLogo, boolean status) {
        ProfilePutRequest request = new ProfilePutRequest(firstName, lastName, email, phone, roleName, urlLogo, status);
        return prepareRequest()
                .body(request)
                .when()
                .put(path + "/" + id);
    }

    public Response updatePassword(int id, String oldPassword, String newPassword, String newPasswordVerify) {
        ProfilePatchRequest request = new ProfilePatchRequest(oldPassword, newPassword, newPasswordVerify);
        return prepareRequest()
                .body(request)
                .when()
                .patch(path + "/" + id);
    }
}
