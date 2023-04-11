package org.ssu.edu.teachua.api.club;

import java.util.ArrayList;
import org.ssu.edu.teachua.api.clients.ClubClient;
import org.ssu.edu.teachua.api.models.club.ClubRequest;
import org.ssu.edu.teachua.utils.runners.LoginWithUserAPIRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.ssu.edu.teachua.utils.providers.DataProviderClub;

public class UserClubTest extends LoginWithUserAPIRunner{

	private ClubClient client;

    @BeforeClass
    public void initClient() {
        client = new ClubClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
    }


	@Issue("TUA-503")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify that User  cann`t create new club is in a center if \"Назва\" field contain more than 100 characters")
	@Test(dataProvider = "dpVerifyThatUserCanNotCreateClubWithNameMoreThan100Characters",
			dataProviderClass = DataProviderClub.class)
	public void testVerifyThatUserCanNotCreateClubWithNameMoreThan100Characters(
			ArrayList<String> categoriesName, String name, int ageFrom, int ageTo,
			boolean isOnline, String description, Integer userId ) {

		ClubRequest request = new ClubRequest(
				categoriesName, name, ageFrom, ageTo,
				isOnline, null, description, new ArrayList<String>(), userId);

		ErrorResponse errorResponse = client.createClub(request).as(ErrorResponse.class);
		softAssert.assertEquals(errorResponse.getStatus(), 400 );
		softAssert.assertEquals(errorResponse.getMessage(), "name Довжина назви має бути від 5 до 100 символів" );
		softAssert.assertAll();
	}
}
