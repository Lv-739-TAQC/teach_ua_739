package org.ssu.edu.teachua.ui.home;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.ssu.edu.teachua.db.entities.Club;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.ClubService;
import org.ssu.edu.teachua.ui.components.card.ClubCardComponent;
import org.ssu.edu.teachua.ui.pages.clubs.ClubsPage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.runners.BaseTestRunnerUI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends BaseTestRunnerUI {

    private ClubService clubService;

    @Issue("TUA-226")
    @Description("[Basic Search] Verify that user can perform basic search by name of a club")
    @Test
    public void testIfClubIsFoundByName() throws DBException, EntityException {

        HomePage homePage = new HomePage(driver);
        clubService = new ClubService(valueProvider.getDbUrl(), valueProvider.getDbUserName(), valueProvider.getUDbUserPassword());

        String location = homePage.getHeader()
                .getLocation();

        List<Club> clubs = clubService.getNameOfClubByCity(location);
        String clubToSearch = clubs.get(random.nextInt(clubs.size() - 1)).getName();
        homePage.fillInSearchField(clubToSearch);

        ClubCardComponent clubCard = new ClubsPage(driver).selectCertainClub(0);
        String clubName = clubCard.getClubTitle();

        String clubFromDb = clubService.getNameOfClubByPrefix(clubName).get(0).getName();

        Assert.assertEquals(clubName, clubFromDb);
    }
}
