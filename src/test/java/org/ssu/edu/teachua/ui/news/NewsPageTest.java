package org.ssu.edu.teachua.ui.news;

import io.qameta.allure.*;
import org.ssu.edu.teachua.db.entities.News;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.NewsService;
import org.ssu.edu.teachua.ui.components.card.NewsCardComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.news.NewsPage;
import org.ssu.edu.teachua.ui.pages.view.ViewNewsPage;
import org.ssu.edu.teachua.utils.runners.LoginWithAdminUIRunner;
import org.ssu.edu.teachua.utils.providers.DataProviderNews;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.ssu.edu.teachua.utils.Helper.checkFileSize;

public class NewsPageTest extends LoginWithAdminUIRunner {

    private static final int NEWS_INDEX = 1;
    private static final long EXPECTED_FILE_SIZE = 300000;
    private static final String IMG_NAME = "heart.png";

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

    @Issue("TUA-33")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verifies that elements of a news article, such as date, image, title and details button are clickable " +
            "and redirect to appropriate news article")
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
        String actualNewsTitle1 = news.chooseCertainNews(NEWS_INDEX)
                .clickImage()
                .getNewsTitle();
        Assert.assertEquals(actualNewsTitle1, expectedNewsTitle);

        homePage.getHeader().clickNewsButton();

        String actualNewsTitle2 = news.chooseCertainNews(NEWS_INDEX)
                .clickTitle()
                .getNewsTitle();
        Assert.assertEquals(actualNewsTitle2, expectedNewsTitle);

        homePage.getHeader().clickNewsButton();

        String actualNewsTitle3 = news.chooseCertainNews(NEWS_INDEX)
                .clickDetailsButton()
                .getNewsTitle();
        Assert.assertEquals(actualNewsTitle3, expectedNewsTitle);
    }

    @Issue(value = "TUA-782")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verifies that image of a news article which is bigger than 300KB was compressed to 300KB")
    @Test(dataProvider = "newsData", dataProviderClass = DataProviderNews.class)
    public void testFileCompression(String title, String content, String photoPath) throws DBException, EntityException {
        new HomePage(driver)
                .getHeader()
                .openAdminProfileMenu()
                .openPageMenu()
                .clickNews()
                .clickAddNewsArticle()
                .addNewsTitle(title)
                .addNewsContent(content)
                .addNewsPhoto(valueProvider.getFilePath(photoPath))
                .clickSubmit();
        NewsService newsService = entityService.getNewsService();

        News news = newsService.getNewsByURLTitleLogo(IMG_NAME);
        String newsLogoURL = news.getUrlTitleLogo();
        String webNewsLogoURL = valueProvider.getBaseUiUrl() + newsLogoURL;

        long actualFileSize = checkFileSize(webNewsLogoURL);
        Assert.assertTrue(actualFileSize <= EXPECTED_FILE_SIZE, "File size was not compressed");
    }

}
