package org.ssu.edu.teachua.api.clients;

import io.restassured.http.ContentType;

public class ClubClient extends BaseClient {

    public ClubClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }
}
