package org.ssu.edu.teachua.api.profile;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.ssu.edu.teachua.api.clients.ProfileClient;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import org.ssu.edu.teachua.api.models.profile.ProfilePatchRequest;
import org.ssu.edu.teachua.api.models.profile.ProfilePutRequest;
import org.ssu.edu.teachua.api.models.profile.ProfileResponse;
import org.ssu.edu.teachua.utils.providers.DataProviderProfilePage;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminAPIRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AdminProfileTest extends LoginWithAdminAPIRunner {

	private ProfileClient client;

	@BeforeClass
	private void initClient() {
		client = new ProfileClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
	}

	@Issue("TUA-750")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify that user cannot change password after leaving empty fields in the 'Change password' pop-up")
	@Test(dataProvider = "dpTestIfPasswordNotUpdated", dataProviderClass = DataProviderProfilePage.class)
	public void testIfPasswordNotUpdated(int id, String emptyData, String newPassword, String oldPassword,
			int expectedStatusCode, List<String> expectedMsg) {

		ProfilePatchRequest verifyOldPassword = new ProfilePatchRequest(emptyData, newPassword, newPassword);
		ErrorResponse responseOldPassword = client.updatePassword(id, verifyOldPassword).as(ErrorResponse.class);

		ProfilePatchRequest verifyNewPassword = new ProfilePatchRequest(oldPassword, emptyData, newPassword);
		ErrorResponse responseNewPassword = client.updatePassword(id, verifyNewPassword).as(ErrorResponse.class);

		ProfilePatchRequest verifyNewPasswordConfirm = new ProfilePatchRequest(oldPassword, newPassword, emptyData);
		ErrorResponse responseNewPasswordConfirm = client.updatePassword(id, verifyNewPasswordConfirm)
				.as(ErrorResponse.class);

		softAssert.assertEquals(responseOldPassword.getMessage(), expectedMsg.get(0));
		softAssert.assertEquals(responseOldPassword.getStatus(), expectedStatusCode);
		softAssert.assertEquals(responseNewPassword.getMessage(), expectedMsg.get(1));
		softAssert.assertEquals(responseNewPassword.getStatus(), expectedStatusCode);
		softAssert.assertEquals(responseNewPasswordConfirm.getMessage(), expectedMsg.get(2));
		softAssert.assertEquals(responseNewPasswordConfirm.getStatus(), expectedStatusCode);
		softAssert.assertAll();
	}

	@Issue("TUA-416")
	@Severity(SeverityLevel.NORMAL)
	@Description("The user or manager can change their role")
	@Test(dataProvider = "dpTestVerifyThatUserCanChangeRole", dataProviderClass = DataProviderProfilePage.class)
	public void testVerifyThatUserCanChangeTheirRole(int id, String firstName, String lastName, String email,
			String phone, String roleName, String urlLogo, boolean status) {

		ProfilePutRequest profilePutRequest = new ProfilePutRequest(firstName, lastName, email, phone, roleName,
				urlLogo, status);

		//ProfileResponse profileResponse = client.updateProfile(id, profilePutRequest).as(ProfileResponse.class);
		
		String profileResponse = client.updateProfile(id,profilePutRequest).asPrettyString(); 
		softAssert.assertTrue(profileResponse.contains("ROLE_USER"));
		profilePutRequest.setRoleName("ROLE_MANAGER"); 
		profileResponse = client.updateProfile(id, profilePutRequest).asPrettyString();
		softAssert.assertTrue(profileResponse.contains("ROLE_MANAGER"));;
		softAssert.assertAll();
	}
}

		
	
