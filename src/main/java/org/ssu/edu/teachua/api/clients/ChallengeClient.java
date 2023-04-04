package org.ssu.edu.teachua.api.clients;

import org.ssu.edu.teachua.api.models.challenge.PatchChallengeRequest;
import org.ssu.edu.teachua.api.models.challenge.PostChallengeRequest;
import org.ssu.edu.teachua.api.models.challenge.PutChallengeNewDateRequest;
import org.ssu.edu.teachua.api.models.challenge.PutChallengeRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.qameta.allure.Step;

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

    @Step("Create a request for get full information about {id} challenge using 'GET' method. Enter values in 'parameter Id': {id}")
    public Response viewChallenge(int id) {
        return prepareRequest()
                .when()
                .get(path + "/" + id);
    }

    @Step("Create a request for get information about all challenges using 'GET' method.")
    public Response getAllChallenges() {
        return prepareRequest()
                .when()
                .get(path + "s");
    }

    @Step("Create a request for delete challenge entity using 'DELETE' method. Enter values in 'parameter Id': {id}")
    public Response deleteChallenge(int id) {
        return prepareRequest()
                .when()
                .delete(path + "/" + id);
    }

    @Step("Create a request for update challenge entity using 'PATCH' method. Enter values in 'parameter Id': {id}, 'Body': {request}")
    public Response updateChallengePatch(int id, PatchChallengeRequest request) {
        return prepareRequest()
        		.body(request)
                .when()
                .patch(path + "/" + id);
    }

    @Step("Create a request for update challenge entity using 'PUT' method. Enter values in 'parameter Id': {id}, 'Body': {request}")
    public Response updateChallengePut(int id, PutChallengeRequest request) {
        return prepareRequest()
        		.body(request)
                .when()
                .put(path + "/" + id);
    }

    @Step("Create a request for set new start date of challenge using 'PUT' method. Enter values in 'parameter Id': {id}, 'Body': {request}")
    public Response updateStartDateChallenge(int id, PutChallengeNewDateRequest request) {
        return prepareRequest()
        		.body(request)
                .when()
                .put(path + "/" + id + "/clone");
    }
}

