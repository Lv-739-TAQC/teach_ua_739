package org.ssu.edu.teachua.api.profile;

import org.ssu.edu.teachua.api.clients.ProfileClient;
import org.ssu.edu.teachua.api.models.profile.ProfilePutRequest;
import org.ssu.edu.teachua.api.models.profile.ProfileResponse;
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
	@Description("he user or manager can change their role")
	@Test
	public void testVerifyThatUserCanChangeTheirRole() {
		ProfilePutRequest profilePutRequest = new ProfilePutRequest(
				"Nastia",
				"Kukh",
				"soyec48727@busantei.com",
				"0999999922",
				"ROLE_USER",
				null,
				true
				);
		ProfileResponse profileResponse = client.updateProfile(203, profilePutRequest).as(ProfileResponse.class);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(profileResponse.getRoleName(), "ROLE_USER");
		profilePutRequest.setRoleName("ROLE_MANAGER");
		profileResponse = client.updateProfile(203, profilePutRequest).as(ProfileResponse.class);
		softAssert.assertEquals(profileResponse.getRoleName(), "ROLE_MANAGER");
		softAssert.assertAll();
	}
}
