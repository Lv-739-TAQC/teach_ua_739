package org.ssu.edu.teachua.ui.pages.news;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.card.ClubCardComponent;
import org.ssu.edu.teachua.ui.components.card.NewsCardComponent;

import java.util.ArrayList;
import java.util.List;

public class NewsPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@class='city-name-box']//h2")
    private WebElement newsTitle;

    @FindBy(how = How.XPATH, using = "//div[@class='sider-header']//h2")
    private WebElement clubsTitle;

    @FindBy(how = How.XPATH, using = "//div[@id='newsContainer']")
    private List<WebElement> newsNodes;

    @FindBy(how = How.XPATH, using = "//div[@class='ant-card-body']")
    private List<WebElement> clubNodes;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public List<NewsCardComponent> getCardsWithNews() {
        List<NewsCardComponent> newsComponents = new ArrayList<>();
        for (WebElement newsNode : waitForElementsToAppear(newsNodes)) {
            newsComponents.add(new NewsCardComponent(driver, newsNode));
        }
        return newsComponents;
    }

    public List<ClubCardComponent> getCardsWithClubs() {
        List<ClubCardComponent> clubComponents = new ArrayList<>();
        for (WebElement clubNode : waitForElementsToAppear(clubNodes)) {
            clubComponents.add(new ClubCardComponent(driver, clubNode));
        }
        return clubComponents;
    }

    public int getCountAllNews() {
        return getCardsWithNews().size();
    }

    public int getCountAllClubs() {
        return getCardsWithClubs().size();
    }

    public String getNewsTitle() {
        return waitForElementToAppear(newsTitle).getText();
    }

    public String getClubsTitle() {
        return waitForElementToAppear(clubsTitle).getText();
    }

    public NewsCardComponent chooseCertainNews(int componentNumber) {
        return getCardsWithNews().get(componentNumber);
    }

    public ClubCardComponent chooseCertainClub(int componentNumber) {
        return getCardsWithClubs().get(componentNumber);
    }
}
