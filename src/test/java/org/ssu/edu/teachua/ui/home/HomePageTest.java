package org.ssu.edu.teachua.ui.home;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ssu.edu.teachua.db.entities.Club;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.ClubService;
import org.ssu.edu.teachua.ui.pages.clubs.ClubsPage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.runners.BaseTestRunnerUI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends BaseTestRunnerUI {

    @Issue("TUA-226")
    @Severity(SeverityLevel.CRITICAL)
    @Description("[Basic Search] Verify that user can perform basic search by name of a club")
    @Test
    public void testIfClubIsFoundByName() throws DBException, EntityException {

        HomePage homePage = new HomePage(driver);
        ClubService clubService = entityService.getClubService();

        String location = homePage.getHeader().getLocation();
        List<Club> clubs = clubService.getClubsByCity(location);
        String clubToSearch = clubs.get(random.nextInt(clubs.size() - 1)).getName();
        homePage.fillInSearchField(clubToSearch);

        String actualClubName = new ClubsPage(driver).selectCertainClub(0).getClubTitle();
        String expectedClubNameFromDb = clubService.getClubsByPrefix(actualClubName).get(0).getName();

        Assert.assertEquals(actualClubName, expectedClubNameFromDb);
    }
}
