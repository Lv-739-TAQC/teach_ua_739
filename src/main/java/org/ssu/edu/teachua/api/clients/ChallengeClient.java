package org.ssu.edu.teachua.api.clients;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.challenge.PostChallengeRequest;

public class ChallengeClient extends BaseClient {

    private final String path = "/api/challenge";

    public ChallengeClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }

    public Response createChallenge(PostChallengeRequest request) {
        return prepareRequest()
                .body(request)
                .when()
                .post(path);
    }

    public Response viewChallenge(int id) {
        return prepareRequest()
                .when()
                .get(path + "/" + id);
    }
}
