package org.ssu.edu.teachua.ui.header;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.openqa.selenium.By;
import org.ssu.edu.teachua.ui.components.card.ClubCardComponent;
import org.ssu.edu.teachua.ui.components.header.HeaderComponent;
import org.ssu.edu.teachua.ui.pages.clubs.ClubsPage;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.view.ViewClubPage;
import org.ssu.edu.teachua.utils.runners.BaseTestRunnerUI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderComponentTest extends BaseTestRunnerUI {

    @Issue("TUA-226")
    @Description("[Basic Search] Verify that user can perform basic search by name of a club")
    @Test
    public void testIfClubIsFoundByName() {

        HomePage homePage = new HomePage(driver);
        String currentLocation = homePage.getHeader()
                .getLocation();
        String clubName1 = "Музична студія DAGI"; //later copy from DB 1st query
        homePage.fillInSearchField(clubName1);
        ClubCardComponent clubCard = new ClubsPage(driver).initClubsCard().get(0);
        String clubTitle = clubCard.getClubTitle();
        String clubName2 = "Музична студія DAGI"; //later copy from DB 2nd query
        //clubsPage.getClubsNode();
        //ClubCardComponent clubCard= new ClubCardComponent(driver, clubsPage.getClubsNode());

        //String clubTitle = clubCard.getClubTitle();
//        ClubsPage clubsPage= new ClubsPage(driver);
//        ViewClubPage viewClub= new ViewClubPage(driver);
//        String clubTitle = viewClub.clickOnMoreDetails().getClubName();
        Assert.assertEquals(clubTitle, clubName2);
    }
}

