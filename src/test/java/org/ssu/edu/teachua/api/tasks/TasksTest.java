package org.ssu.edu.teachua.api.tasks;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ssu.edu.teachua.api.clients.TaskClient;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.api.models.task.TaskPostRequest;
import org.ssu.edu.teachua.api.models.task.TaskPutRequest;
import org.ssu.edu.teachua.api.models.task.TaskResponse;
import org.ssu.edu.teachua.utils.providers.DataProviderTask;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminAPIRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

public class TasksTest extends LoginWithAdminAPIRunner {
    private TaskClient taskClient;

    @BeforeClass
    private void initClient() {
        taskClient = new TaskClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

    @Issue("TUA-446")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that admin can not edit Task using spaces as values")
    @Test(dataProvider = "testEditTaskWithInvalidData", dataProviderClass = DataProviderTask.class)
    public void testEditTaskWithInvalidData(String name, String headerText, String description, String picture, String startDate, int challengeId) {

        List<String> expectedMsg = Arrays.asList("name must contain a minimum of 5 and a maximum of 255 letters", "name must not be blank", "description must contain a maximum of 10000 letters");

        TaskPutRequest invalidPutRequest = new TaskPutRequest(name, headerText, description, picture, startDate, challengeId);

        Response putResponse = taskClient.putTask(777, invalidPutRequest);
        ErrorResponse taskPutResponse = putResponse.as(ErrorResponse.class);

        softAssert.assertEquals(putResponse.statusCode(), 400, "status code");
        softAssert.assertEquals(taskPutResponse.getStatus(), 400);
        softAssert.assertTrue(taskPutResponse.getMessage().contains(expectedMsg.get(0)));
        softAssert.assertTrue(taskPutResponse.getMessage().contains(expectedMsg.get(1)));
        softAssert.assertTrue(taskPutResponse.getMessage().contains(expectedMsg.get(2)));
        softAssert.assertAll();
    }

    @Issue("TUA-444")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that admin can edit Task with valid values")
    @Test(dataProvider = "testEditTaskWithValidData", dataProviderClass = DataProviderTask.class)
    public void testEditTaskWithValidData(String name, String headerText, String description, String picture, String date, int challengeId) {
        TaskPutRequest validDataPutRequest = new TaskPutRequest(name, headerText, description, picture, date, challengeId);

        Response validDataResponse = taskClient.putTask(777, validDataPutRequest);
        TaskResponse taskResponse = validDataResponse.as(TaskResponse.class);
        softAssert.assertEquals(validDataResponse.statusCode(), 200);
        softAssert.assertEquals(taskResponse.getId(), 777);
        softAssert.assertEquals(taskResponse.getName(), name);
        softAssert.assertEquals(taskResponse.getHeaderText(), headerText);
        softAssert.assertEquals(taskResponse.getDescription(), description);
        softAssert.assertEquals(taskResponse.getPicture(), picture);
        softAssert.assertEquals(taskResponse.getStartDate(), date);
        softAssert.assertEquals(taskResponse.getChallengeId(), challengeId);
        softAssert.assertAll();
    }

    @Issue("TUA-442")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that admin can not create Task with invalid values")
    @Test(dataProvider = "testCreateTaskWithInvalidData", dataProviderClass = DataProviderTask.class)
    public void testCreateTaskWithInvalidData(String name, String headerText, String description, String picture, String date, String expectedErrorMsg) {
        TaskPostRequest invalidDataPostRequest = new TaskPostRequest(name, headerText, description, picture, date);
        Response postResponse = taskClient.postTask(777, invalidDataPostRequest);
        ErrorResponse errorResponse = postResponse.as(ErrorResponse.class);

        softAssert.assertEquals(postResponse.statusCode(), 400);
        softAssert.assertEquals(errorResponse.getStatus(), 400);
        softAssert.assertEquals(errorResponse.getMessage(), expectedErrorMsg);
        softAssert.assertAll();
    }

    @Issue("TUA-441")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that admin can create Task with valid values")
    @Test(dataProvider = "testCreateTaskWithValidData", dataProviderClass = DataProviderTask.class)
    public void testCreateTaskWithValidData(String name, String headerText, String description, String picture, String date) {

        TaskPostRequest validDataPostRequest = new TaskPostRequest(name, headerText, description, picture, date);

        Response validDataResponse = taskClient.postTask(777, validDataPostRequest);
        TaskResponse taskResponse = validDataResponse.as(TaskResponse.class);

        softAssert.assertEquals(validDataResponse.statusCode(), 200);
        softAssert.assertEquals(taskResponse.getName(), name);
        softAssert.assertEquals(taskResponse.getHeaderText(), headerText);
        softAssert.assertEquals(taskResponse.getPicture(), picture);
        softAssert.assertEquals(taskResponse.getStartDate(), date);
        softAssert.assertEquals(taskResponse.getChallengeId(), 777);
        softAssert.assertAll();
    }
}
