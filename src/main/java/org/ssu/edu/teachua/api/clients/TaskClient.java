package org.ssu.edu.teachua.api.clients;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.task.TaskPostRequest;
import org.ssu.edu.teachua.api.models.task.TaskPutRequest;

public class TaskClient extends BaseClient {

    private final String path = "/api/challenge";

    public TaskClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }

    @Step("Create a request for creating new task entity using 'POST' method. Enter values in " +
            "'parameter Id': {id}, 'Body': {request}")
    public Response postTask (int id, TaskPostRequest request){
        return prepareRequest()
                .body(request)
                .when()
                .post(String.format("%s/%d/task", path, id));
    }

    @Step("Create a request for update task entity using 'PUT' method. Enter values in " +
            "'parameter Id': {id}, 'Body': {request}")
    public Response putTask (int id, TaskPutRequest request){
        return prepareRequest()
                .body(request)
                .when()
                .put(String.format("%s/task/%d",path, id));
    }
}
