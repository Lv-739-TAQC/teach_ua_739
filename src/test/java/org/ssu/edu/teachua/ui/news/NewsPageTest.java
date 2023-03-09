package org.ssu.edu.teachua.ui.news;

import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.ssu.edu.teachua.utils.providers.DataProviderNews;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsPageTest extends LoginWithAdminRunner {

    @Test(dataProvider = "dpTestButtonsActivity", dataProviderClass = DataProviderNews.class)
    public void testButtonsActivity(String location, String expectedClubsTitle) {
        HomePage homePage = new HomePage(driver);

        List<Boolean> actualNewsButtons = new ArrayList<>();
        int newsAmount = homePage.getHeader().clickNewsButton().getCountAllNews();

        for (int i = 0; i < newsAmount; i++) {
            actualNewsButtons.add(homePage
                    .getHeader()
                    .clickNewsButton()
                    .chooseCertainNews(i)
                    .clickDetailsButton()
                    .isDonateButtonEnabled());
        }

        List<Boolean> actualClubsButtons = new ArrayList<>();
        int clubsAmount = homePage.getHeader().clickNewsButton().getCountAllClubs();

        for (int i = 0; i < clubsAmount; i++) {
            actualClubsButtons.add(homePage
                    .getHeader()
                    .clickNewsButton()
                    .chooseCertainClub(i)
                    .clickDetailsButton()
                    .isSubscribeButtonEnabled());
        }

        String actualClubsTitle = homePage.getHeader()
                .clickLocationButton()
                .chooseLocation(location)
                .clickNewsButton()
                .getClubsTitle();

        softAssert.assertEquals(actualNewsButtons, Arrays.asList(true, true, true, true));
        softAssert.assertEquals(actualClubsButtons, Arrays.asList(true, true, true));
        softAssert.assertEquals(actualClubsTitle, expectedClubsTitle);

        softAssert.assertAll();
    }
}
