package org.ssu.edu.teachua.ui.club;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.db.entities.Club;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.service.ClubService;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubMainInfoComponent;
import org.ssu.edu.teachua.ui.components.modal.edit_club_component.EditClubMainInfoComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;
import org.ssu.edu.teachua.utils.providers.DataProviderClub;
import org.ssu.edu.teachua.utils.runners.LoginWithLeadRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.Timestamp;
import java.util.List;

public class ClubModalAsLeadTest extends LoginWithLeadRunner {

    private ProfilePage profilePage;
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());


    @BeforeMethod
    void openEditClubForm() {
        driver.navigate().refresh();
        profilePage = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openProfilePage();

    }

    @Issue("TUA-508")
    @Description("Verify that user as 'Керiвник гуртка' after editing club is in a center " +
            "can find edited information about it on the website and database")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testEditClubNameAsLead() throws DBException {
        ClubService clubService = new ClubService(valueProvider.getDbUrl(), valueProvider.getDbUserName(), valueProvider.getUDbUserPassword());
        String newName = "new club name";

        profilePage.clickClubDots(0)
                .clickEditClubButton()
                .enterNewClubName(newName)
                .editCategoriesCheckBoxes(8)
                .enterEditChildAgeFrom("5")
                .enterEditChildAgeFor("8")
                .clickEditNextStepButton()
                .enterEditContactPhone("0543456789")
                .clickEditNextStepButton()
                .editEnterDescription("some text for test club description field just for testing")
                .clickEditEndButton();

        driver.navigate().refresh();

        List<Club> listClubByName = clubService.getClubsByName(newName);
        Club club = null;
        if (!listClubByName.isEmpty()) {
            club = listClubByName.get(0);
        }

        Assert.assertEquals(club != null ? club.getName() : "errorClub", newName);
    }

    @Issue("TUA-506")
    @Description("This test-case verifies that having created a club on UI, it is possible to locate it in the DB")
    @Test(dataProvider = "dpTestAllFieldsValidCenter", dataProviderClass = DataProviderClub.class)
    public void testAllFieldsValidCenter(String nameField, int categoriesNumber, String childAgeFrom,
                                         String childAgeFor, int centerNumber, String contactPhone, String description) {
        String generatedClubName = nameField + timestamp.getTime();
        profilePage
                .clickAddButton()
                .clickAddClubButton()
                .enterClubName(generatedClubName)
                .getCategoriesCheckBoxes(categoriesNumber)
                .enterChildAgeFrom(childAgeFrom)
                .enterChildAgeFor(childAgeFor)
                .getBelongingToCenter()
                .getCertainCenter(centerNumber)
                .clickNextStepButton()
                .enterContactPhone(contactPhone)
                .clickNextStepButton()
                .enterDescription(description)
                .clickEndButton();

        Club club = entityService.getClubService().getClubsByName(generatedClubName).get(0);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(club.getName(), generatedClubName);
        softAssert.assertEquals(club.getAgeFrom().toString(), childAgeFrom);
        softAssert.assertEquals(club.getAgeTo().toString(), childAgeFor);
        softAssert.assertEquals(club.getDescriptionText(), description);

        softAssert.assertAll();
    }

}
