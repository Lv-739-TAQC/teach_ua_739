package org.ssu.edu.teachua.ui.club;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.ssu.edu.teachua.db.entities.Club;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.ClubService;
import org.ssu.edu.teachua.ui.components.modal.edit_club_component.EditClubMainInfoComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;
import org.ssu.edu.teachua.utils.providers.DataProviderClub;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminRunner;
import org.ssu.edu.teachua.utils.runners.LoginWithLeadRunner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class EditClubComponentTest extends LoginWithLeadRunner {

    private EditClubMainInfoComponent editClubComponent;

    @BeforeMethod
    void openEditClubForm() {
        driver.navigate().refresh();
        editClubComponent = new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openProfilePage()
                .clickClubDots(0)
                .clickEditClubButton();
    }

    @Issue("TUA-508")
    @Description("Verify that user as 'Керiвник гуртка' after edditing club is in a center " +
            "can find eddited information about it on the website and database")
    @Test
    public void testEditClubNameAsLead() throws DBException {
        ClubService clubService = new ClubService(valueProvider.getDbUrl(), valueProvider.getDbUserName(), valueProvider.getUDbUserPassword());
        String newName = "new club name";

      editClubComponent.enterNewClubName(newName)
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

        Assert.assertEquals(club != null ? club.getName() : "errorClub",newName);
    }
}
