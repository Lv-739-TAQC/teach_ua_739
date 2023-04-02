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

public class UserClubTest extends LoginWithUserAPIRunner{
	private final ClubClient client = new ClubClient(valueProvider.getBaseUiUrl(), ContentType.JSON, accessToken);
	
	
	@Issue("TUA-437")
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify that User  cann`t create new club is in a center if \"Назва\" field contain more than 100 characters")
	@Test
	public void testVerifyThatUserCanNotCreateClubWithNameMoreThan100Characters() {
		ClubRequest request = new ClubRequest(
					0, 
					"Ми поставили перед собою ціль створити мережу найкращих центрів раннього розвитку в Україні, де дітки навчатимуться з задоволенням, а батьки радітимуть від результатів12346578901234657890123465789012346578901234657890123465789012346578901234657890123465789012346578901234657890",
					"{\"blocks\":[{\"key\":\"brl63\",\"text\":\"Ми поставили перед собою ціль створити мережу найкращих центрів раннього розвитку в Україні, де дітки навчатимуться з задоволенням, а батьки радітимуть від результатів.\",\"type\":\"unstyled\",\"depth\":1,\"inlineStyleRanges\":[],\"entityRanges\":[],\"data\":{}}],\"entityMap\":{}}",
					2,
					new ArrayList<String>(Arrays.asList("Вокальна студія, музика, музичні інструменти")),
					new ArrayList<Location>(),
					2,
					18,
					"/dev/static/images/user/avatar/user1.png",
					 "/dev/static/images/user/avatar/user1.png",
					 new ArrayList<UrlGallery>(),
					 true,
					 "{\"1\"::\"ліл\"}",
					 true,
					 264,
					 0,
					 0);
		
		ErrorResponse errorResponse = client.createClub(request).as(ErrorResponse.class);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(errorResponse.getStatus(), 400 );
		softAssert.assertEquals(errorResponse.getMessage(), "name Довжина назви має бути від 5 до 100 символів" );
		softAssert.assertAll();
	}
}
