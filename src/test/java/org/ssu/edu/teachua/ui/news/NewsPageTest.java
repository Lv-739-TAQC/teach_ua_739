package org.ssu.edu.teachua.ui.news;

import io.qameta.allure.*;
import org.ssu.edu.teachua.ui.components.card.NewsCardComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.news.NewsPage;
import org.ssu.edu.teachua.ui.runners.LoginWithAdminRunner;
import org.ssu.edu.teachua.utils.providers.DataProviderNews;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NewsPageTest extends LoginWithAdminRunner {

    private static final int NEWS_INDEX = 1;

    @Issue("TUA-31")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test case verifies that the user can click on all available" +
                 "\nbuttons on the News page and all corresponding pages will be opened.")
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
    @Issue("TUA-146")
    @Description("Verify that news blocks are in descending order")
    @Test
    public void newsOrderTest() throws IOException, ParseException {
        HomePage homePage = new HomePage(driver);

        List<Date> newsDates = new ArrayList<>();

        List<NewsCardComponent> newsCards = homePage.getHeader()
                .clickNewsButton()
                .getCardsWithNews();
        for (NewsCardComponent newsCard : newsCards) {
            newsDates.add(new SimpleDateFormat("dd.MM.yyyy").parse(newsCard.getNewsDate()));
        }
        List<Date> descNewsDates = new ArrayList<>(newsDates);

        Collections.sort(descNewsDates, Collections.reverseOrder());

        Assert.assertEquals(newsDates, descNewsDates);
    }

    @Test
    public void testClickOnNewsArticle() {
        HomePage homePage = new HomePage(driver);
        homePage.getHeader().clickNewsButton();

        NewsPage news = new NewsPage(driver);

        String expectedNewsTitle = news.chooseCertainNews(NEWS_INDEX)
                .getNewsTitle();
        String actualNewsTitle = news.chooseCertainNews(NEWS_INDEX)
                .clickDate()
                .getNewsTitle();
        Assert.assertEquals(actualNewsTitle, expectedNewsTitle);

        homePage.getHeader().clickNewsButton();
        String expectedNewsTitle1 = news.chooseCertainNews(NEWS_INDEX)
                .getNewsTitle();
        String actualNewsTitle1 = news.chooseCertainNews(NEWS_INDEX)
                .clickImage()
                .getNewsTitle();
        Assert.assertEquals(actualNewsTitle1, expectedNewsTitle1);

        homePage.getHeader().clickNewsButton();
        String expectedNewsTitle2 = news.chooseCertainNews(NEWS_INDEX)
                .getNewsTitle();
        String actualNewsTitle2 = news.chooseCertainNews(NEWS_INDEX)
                .clickTitle()
                .getNewsTitle();
        Assert.assertEquals(actualNewsTitle2, expectedNewsTitle2);

        homePage.getHeader().clickNewsButton();
        String expectedNewsTitle3 = news.chooseCertainNews(NEWS_INDEX)
                .getNewsTitle();
        String actualNewsTitle3 = news.chooseCertainNews(NEWS_INDEX)
                .clickDetailsButton()
                .getNewsTitle();
        Assert.assertEquals(actualNewsTitle3, expectedNewsTitle3);
    }
}
