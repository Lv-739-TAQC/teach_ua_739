package org.ssu.edu.teachua.api.clients;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseClient {
    protected final String baseUrl;
    protected final ContentType contentType;
    protected String accessToken;

    public BaseClient(String url, ContentType contentType) {
        this.baseUrl = url;
        this.contentType = contentType;
        this.accessToken = null;
    }

    public BaseClient(String url, ContentType contentType, String accessToken) {
        this.baseUrl = url;
        this.contentType = contentType;
        this.accessToken = accessToken;
    }

    public RequestSpecification prepareRequest() {
        RequestSpecification requestSpecification = given()
                .relaxedHTTPSValidation()
                .baseUri(baseUrl)
                .contentType(contentType)
                .accept(contentType);
        if (accessToken != null) {
            requestSpecification.header("Authorization", "Bearer " + accessToken);
        }
        return requestSpecification;
    }
}
