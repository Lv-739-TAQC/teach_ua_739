package org.ssu.edu.teachua.api.clients;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.challenge.PostChallengeRequest;

public class ChallengeClient extends BaseClient{

    private final String path = "/api/challenge";

    public ChallengeClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }
    @Step("Create a request for creating new challenge entity using 'POST' method. Enter values in 'Body': {request}")
    public Response createChallenge(PostChallengeRequest request) {
        return prepareRequest()
                .body(request)
                .when()
                .post(path);
    }
}
