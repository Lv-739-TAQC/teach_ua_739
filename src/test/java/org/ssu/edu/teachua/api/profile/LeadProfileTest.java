package org.ssu.edu.teachua.api.profile;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.testng.annotations.Test;
import org.ssu.edu.teachua.api.clients.ProfileClient;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.api.models.profile.ProfilePutRequest;
import org.ssu.edu.teachua.utils.providers.DataProviderProfilePage;
import org.ssu.edu.teachua.utils.runners.LoginWithLeadAPIRunner;
import org.testng.asserts.SoftAssert;


public class LeadProfileTest extends LoginWithLeadAPIRunner {
    private final ProfileClient client = new ProfileClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);

    @Issue("TUA-421")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that user can not save changes where enter invalid data in field 'Phone'")
    @Test(dataProvider = "dpTestUpdatePhoneInvalid", dataProviderClass = DataProviderProfilePage.class)
    public void testUpdatePhoneInvalid(int id, String firstName, String lastName, String email, String phone,
                                       String roleName, String urlLogo, boolean status, int expectedStatusCode,
                                       String expectedErrorMsg) throws DBException, EntityException {
        SoftAssert softAssert = new SoftAssert();

        ProfilePutRequest profilePutRequest = new ProfilePutRequest(
                firstName, lastName, email, phone, roleName, urlLogo, status
        );
        ErrorResponse errorResponse = client.updateProfile(id, profilePutRequest).as(ErrorResponse.class);

        softAssert.assertEquals(errorResponse.getStatus(), expectedStatusCode);
        softAssert.assertEquals(errorResponse.getMessage(), expectedErrorMsg);
        softAssert.assertEquals(entityService.getUserService().getUsersById(id).get(0).getPhone(), "380639379992");
        softAssert.assertAll();
    }
}
