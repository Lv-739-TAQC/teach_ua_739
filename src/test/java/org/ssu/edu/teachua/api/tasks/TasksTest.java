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
import org.testng.asserts.SoftAssert;

public class TasksTest extends LoginWithAdminAPIRunner {
    private TaskClient taskClient;
    SoftAssert softAssert = new SoftAssert();


    @BeforeClass
    private void initClient() {
        taskClient = new TaskClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }

    @Issue("TUA-446")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that admin can not edit Task using spaces as values")
    @Test(dataProvider = "testEditTaskWithInvalidData", dataProviderClass = DataProviderTask.class)
    public void testEditTaskWithInvalidData(String name, String headerText, String description, String picture,
                                            String startDate, int challengeId, String expectedErrorMsg) {

        TaskPutRequest invalidPutRequest = new TaskPutRequest(name, headerText, description,
                picture, startDate, challengeId);

        Response putResponse = taskClient.putTask(777, invalidPutRequest);
        ErrorResponse taskPutResponse = putResponse.as(ErrorResponse.class);

        softAssert.assertEquals(putResponse.statusCode(), 400);
        softAssert.assertEquals(taskPutResponse.getStatus(), 400);
        softAssert.assertEquals(taskPutResponse.getMessage(), expectedErrorMsg);

        softAssert.assertAll();
    }

    @Issue("TUA-444")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that admin can edit Task with valid values")
    @Test(dataProvider = "testEditTaskWithValidData", dataProviderClass = DataProviderTask.class)
    public void testEditTaskWithValidData(String name, String headerText, String description, String picture,
                                          String date, int challengeId ) {
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
    public void testCreateTaskWithInvalidData(String name, String headerText, String description, String picture,
                                              String date, String expectedErrorMsg) {
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
    public void testCreateTaskWithValidData(String name, String headerText, String description, String picture,
                                            String date){
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
