package org.ssu.edu.teachua.api.profile;

import org.ssu.edu.teachua.api.clients.ProfileClient;
import org.ssu.edu.teachua.api.models.profile.ProfilePutRequest;
import org.ssu.edu.teachua.api.models.profile.ProfileResponse;
import org.ssu.edu.teachua.utils.providers.DataProviderProfilePage;
import org.ssu.edu.teachua.utils.runners.LoginWithUserAPIRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;

public class UserProfileTest extends LoginWithUserAPIRunner {
	private final ProfileClient client = new ProfileClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
	
	@Issue("TUA-416")
	@Severity(SeverityLevel.NORMAL)
	@Description("The user or manager can change their role")
	@Test (dataProvider = "dpTestVerifyThatUserCanChangeTheirRole",
			dataProviderClass = DataProviderProfilePage.class)
	public void testVerifyThatUserCanChangeTheirRole(int id,
			String firstName, String lastName,
     		String email, String phone, String roleName,
     		String urlLogo, boolean status) {
		ProfilePutRequest profilePutRequest = new ProfilePutRequest(
				id, firstName, lastName,
	     		email, phone, roleName,
	     		urlLogo, status);
		ProfileResponse profileResponse = client.updateProfile(id, profilePutRequest).as(ProfileResponse.class);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(profileResponse.getRoleName(), "ROLE_USER");
		profilePutRequest.setRoleName("ROLE_MANAGER");
		profileResponse = client.updateProfile(id, profilePutRequest).as(ProfileResponse.class);
		softAssert.assertEquals(profileResponse.getRoleName(), "ROLE_MANAGER");
		softAssert.assertAll();
	}
}
