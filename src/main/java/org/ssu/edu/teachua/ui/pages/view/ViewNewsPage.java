package org.ssu.edu.teachua.ui.pages.view;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.card.NewsCardComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewNewsPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@id='major-title']")
    private WebElement newsTitle;

    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'donate-button')]")
    private WebElement donateButton;

    @FindBy(how = How.XPATH, using = "//div[@id='date']")
    private WebElement newsDate;

    @FindBy(how = How.XPATH, using = "//div[@id='description']")
    private WebElement newsDescription;

    @FindBy(how = How.XPATH, using = "//div[@class='other-news']")
    private WebElement otherNewsTitle;
    @FindBy(how = How.XPATH, using = "//div[@class='image']")
    private WebElement newsPhoto;

    @FindBy(how = How.XPATH, using = "//div[@class='slick-track']/*[position() <= 3]")
    private List<WebElement> otherNewsNodes;

    public ViewNewsPage(WebDriver driver) {
        super(driver);
    }

    public List<NewsCardComponent> getCardsWithOtherNews() {
        List<NewsCardComponent> otherNewsComponents = new ArrayList<>();
        for (WebElement otherNewsNode : waitForElementsToAppear(otherNewsNodes)) {
            otherNewsComponents.add(new NewsCardComponent(driver, otherNewsNode));
        }
        return otherNewsComponents;
    }

    @Step("Get all other news from page")
    public int getCountAllOtherNews() {
        return getCardsWithOtherNews().size();
    }

    public boolean isDonateButtonEnabled() {
        return waitForElementToAppear(donateButton).isEnabled();
    }

    public String getNewsTitle() {
        return newsTitle.getText();
    }

    public String getNewsDate() {
        return newsDate.getText();
    }

    public String getNewsDescription() {
        return newsDescription.getText();
    }

    public String getOtherNewsTitle() {
        return otherNewsTitle.getText();
    }
    public String getNewsPhotoURL() {
        String rawURL = newsPhoto.getAttribute("style");
        Pattern pattern = Pattern.compile("url\\(\"(.+?)\"\\)");
        Matcher matcher = pattern.matcher(rawURL);
        if (matcher.find()) {
           return matcher.group(1);
        }
        return "";
    }

    @Step("Choose specific other news")
    public NewsCardComponent chooseCertainOtherNews(int componentNumber) {
        return getCardsWithOtherNews().get(componentNumber);
    }
}
