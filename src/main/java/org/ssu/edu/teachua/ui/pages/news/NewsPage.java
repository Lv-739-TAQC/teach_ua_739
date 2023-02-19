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
    private List<WebElement> newsLocators;

    @FindBy(how = How.XPATH, using = "//div[@class='ant-card-body']")
    private List<WebElement> clubLocators;

    private List<NewsCardComponent> newsComponents;

    private List<ClubCardComponent> clubComponents;


    public NewsPage(WebDriver driver) {
        super(driver);
        newsComponents = fillComponentsWithNews();
        clubComponents = fillComponentsWithClubs();
    }

    private List<NewsCardComponent> fillComponentsWithNews() {
        List<NewsCardComponent> components = new ArrayList<>();
        for (WebElement element : waitForElementsToAppear(newsLocators)) {
            components.add(new NewsCardComponent(driver, element));
        }
        return components;
    }

    private List<ClubCardComponent> fillComponentsWithClubs() {
        List<ClubCardComponent> components = new ArrayList<>();
        for (WebElement element : waitForElementsToAppear(clubLocators)) {
            components.add(new ClubCardComponent(driver, element));
        }
        return components;
    }

    public int getCountAllNews() {
        return newsComponents.size();
    }

    public int getCountAllClubs() {
        return clubComponents.size();
    }

    public String getNewsTitle() {
        return waitForElementToAppear(newsTitle).getText();
    }

    public String getClubsTitle() {
        return waitForElementToAppear(clubsTitle).getText();
    }

    public NewsCardComponent getCertainNews(int componentNumber) {
        return newsComponents.get(componentNumber);
    }

    public ClubCardComponent getCertainClub(int componentNumber) {
        return clubComponents.get(componentNumber);
    }
}
