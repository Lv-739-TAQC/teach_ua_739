package org.ssu.edu.teachua.api.clients;

import io.restassured.http.ContentType;

public class ProfileClient extends BaseClient{

    public ProfileClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }
}
