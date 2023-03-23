package org.ssu.edu.teachua.ui.pages.news;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.card.ClubCardComponent;
import org.ssu.edu.teachua.ui.components.card.NewsCardComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains elements and methods that
 * represent the news page functionality
 */
public class NewsPage extends BasePage {

    /**
     * locator for getting news title
     */
    @FindBy(how = How.XPATH, using = "//div[@class='city-name-box']//h2")
    private WebElement newsTitle;

    /**
     * locator for getting clubs title
     */
    @FindBy(how = How.XPATH, using = "//div[@class='sider-header']//h2")
    private WebElement clubsTitle;

    /**
     * locator represent list of all news in the news page
     */
    @FindBy(how = How.XPATH, using = "//div[@id='newsContainer']")
    private List<WebElement> newsNodes;

    /**
     * locator represent list of all clubs in the news page
     */
    @FindBy(how = How.XPATH, using = "//div[@class='ant-card-body']")
    private List<WebElement> clubNodes;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * getting all cards with news
     *
     * @return {@link List<NewsCardComponent>} - list with all news
     */
    public List<NewsCardComponent> getCardsWithNews() {
        List<NewsCardComponent> newsComponents = new ArrayList<>();
        for (WebElement newsNode : waitForElementsToAppear(newsNodes)) {
            newsComponents.add(new NewsCardComponent(driver, newsNode));
        }
        return newsComponents;
    }

    /**
     * getting all cards with clubs
     *
     * @return {@link List<ClubCardComponent>} - list with all clubs
     */
    public List<ClubCardComponent> getCardsWithClubs() {
        List<ClubCardComponent> clubComponents = new ArrayList<>();
        for (WebElement clubNode : waitForElementsToAppear(clubNodes)) {
            clubComponents.add(new ClubCardComponent(driver, clubNode));
        }
        return clubComponents;
    }

    /**
     * count of all news in the news page
     *
     * @return int - count of all news
     */
    @Step("Get all clubs from page")
    public int getCountAllNews() {
        return getCardsWithNews().size();
    }

    /**
     * count of all clubs in the news page
     *
     * @return int - count of all clubs
     */
    @Step("Get all news from page")
    public int getCountAllClubs() {
        return getCardsWithClubs().size();
    }

    /**
     * show news title
     *
     * @return String of news title
     */
    public String getNewsTitle() {
        return waitForElementToAppear(newsTitle).getText();
    }

    /**
     * show clubs title
     *
     * @return String of clubs title
     */
    public String getClubsTitle() {
        return waitForElementToAppear(clubsTitle).getText();
    }

    /**
     * click on a specific news
     *
     * @param componentNumber - number of news card
     * @return opened NewsCardComponent
     */
    @Step("Move to certain news")
    public NewsCardComponent chooseCertainNews(int componentNumber) {
        return getCardsWithNews().get(componentNumber);
    }

    /**
     * click on a specific club
     *
     * @param componentNumber - number of club card
     * @return opened ClubCardComponent
     */
    @Step("Move to certain club")
    public ClubCardComponent chooseCertainClub(int componentNumber) {
        return getCardsWithClubs().get(componentNumber);
    }
}
