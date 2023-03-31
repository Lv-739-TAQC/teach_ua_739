package org.ssu.edu.teachua.api.clients;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.models.task.TaskPostRequest;
import org.ssu.edu.teachua.api.models.task.TaskPutRequest;

public class TaskClient extends BaseClient {

    private final String path = "/api/challenge";

    public TaskClient(String url, ContentType contentType, String accessToken) {
        super(url, contentType, accessToken);
    }

    public Response postTask (int id, TaskPostRequest request){
        return prepareRequest()
                .body(request)
                .when()
                .post(String.format("%s/%d/task", path, id));
    }

    public Response putTask (int id, TaskPutRequest request){
        return prepareRequest()
                .body(request)
                .when()
                .put(String.format("%s/task/%d",path, id));
    }
}
