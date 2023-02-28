package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.components.card.NewsCardComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TestCasesTetiana extends TestRunnerUI {

    @Test
    public void testTua146 () throws IOException {
        HomePage homePage = new HomePage(driver);

        List<Date> newsDates = new ArrayList<>();
        List<Date> descNewsDates = new ArrayList<>();

        List<NewsCardComponent> newsCards = homePage.getHeader()
               .clickNewsButton()
               .getCardsWithNews();
        for (NewsCardComponent newsCard : newsCards) {
            try {
                newsDates.add(new SimpleDateFormat("dd.MM.yyyy").parse(newsCard.getNewsDate()));
                descNewsDates.add(new SimpleDateFormat("dd.MM.yyyy").parse(newsCard.getNewsDate()));
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }

        Collections.sort(descNewsDates, Collections.reverseOrder());

        Assert.assertEquals(newsDates, descNewsDates);
    }

    @Test
    public void testTua71 () throws IOException {
        HomePage homePage = new HomePage(driver);

        String expected = "https://speak-ukrainian.org.ua/dev/challenges/561";

        String testChallengePage = homePage.getHeader()
                .clickChallengesButton()
                .getChallengeUrl(5);

        Assert.assertEquals(testChallengePage, expected);
    }
}
