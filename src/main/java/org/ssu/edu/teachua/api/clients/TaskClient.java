package org.ssu.edu.teachua.api.clients;

import io.restassured.http.ContentType;

public class TaskClient extends BaseClient{

    public TaskClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }
}
