package org.ssu.edu.teachua.api.clients;

import io.restassured.http.ContentType;

public class ChallengeClient extends BaseClient{

    public ChallengeClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }
}
