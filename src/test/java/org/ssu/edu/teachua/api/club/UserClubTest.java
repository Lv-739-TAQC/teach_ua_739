package org.ssu.edu.teachua.api.club;

import java.util.ArrayList;
import java.util.Arrays;
import org.ssu.edu.teachua.api.models.location.Location;
import org.ssu.edu.teachua.api.clients.ClubClient;
import org.ssu.edu.teachua.api.models.club.ClubRequest;
import org.ssu.edu.teachua.api.models.url_gallery.UrlGallery;
import org.ssu.edu.teachua.utils.runners.LoginWithUserAPIRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.ssu.edu.teachua.api.models.error.ErrorResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.ssu.edu.teachua.utils.providers.DataProviderClub;

public class UserClubTest extends LoginWithUserAPIRunner{
	
	private final ClubClient client = new ClubClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
	
	
	@Issue("TUA-437")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify that User  cann`t create new club is in a center if \"Назва\" field contain more than 100 characters")
	@Test(dataProvider = "dpVerifyThatUserCanNotCreateClubWithNameMoreThan100Characters",
			dataProviderClass = DataProviderClub.class)
	public void testVerifyThatUserCanNotCreateClubWithNameMoreThan100Characters(
			int id, String name, String description, int centerId,
		    ArrayList<String> categoriesName, ArrayList<Location> locations,
		    int ageFrom, int ageTo, String urlBackground, String urlLogo, ArrayList<UrlGallery> urlGallery,
		    boolean isOnline, String contacts, boolean isApproved, int userId, int clubExternalId, int centerExternalId) {
		
		ClubRequest request = new ClubRequest(
				id, name, description, centerId,
			    categoriesName, locations,
			    ageFrom, ageTo, urlBackground, urlLogo, urlGallery,
			    isOnline, contacts, isApproved, userId, clubExternalId, centerExternalId);
		
		ErrorResponse errorResponse = client.createClub(request).as(ErrorResponse.class);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(errorResponse.getStatus(), 400 );
		softAssert.assertEquals(errorResponse.getMessage(), "name Довжина назви має бути від 5 до 100 символів" );
		softAssert.assertAll();
	}
}
