package org.ssu.edu.teachua.api.clients;

import io.restassured.http.ContentType;

public class RegistrationClient extends BaseClient{

    public RegistrationClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }
}
