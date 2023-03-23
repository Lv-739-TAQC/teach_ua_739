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

/**
 * This class contains elements and methods that
 * represent the view news page functionality
 */
public class ViewNewsPage extends BasePage {

    /**
     * locator represents news title
     */
    @FindBy(how = How.XPATH, using = "//div[@id='major-title']")
    private WebElement newsTitle;

    /**
     * locator represents 'donate' button
     */
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'donate-button')]")
    private WebElement donateButton;

    /**
     * locator represents news date
     */
    @FindBy(how = How.XPATH, using = "//div[@id='date']")
    private WebElement newsDate;

    /**
     * locator represents news description
     */
    @FindBy(how = How.XPATH, using = "//div[@id='description']")
    private WebElement newsDescription;

    /**
     * locator represents title of other news
     */
    @FindBy(how = How.XPATH, using = "//div[@class='other-news']")
    private WebElement otherNewsTitle;
    /**
     * locator represents news photo
     */
    @FindBy(how = How.XPATH, using = "//div[@class='image']")
    private WebElement newsPhoto;

    /**
     * locator represents list of all other news
     */
    @FindBy(how = How.XPATH, using = "//div[@class='slick-track']/*[position() <= 3]")
    private List<WebElement> otherNewsNodes;

    public ViewNewsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * getting all cards with other news
     * @return List<NewsCardComponent> - list with all other news
     */
    public List<NewsCardComponent> getCardsWithOtherNews() {
        List<NewsCardComponent> otherNewsComponents = new ArrayList<>();
        for (WebElement otherNewsNode : waitForElementsToAppear(otherNewsNodes)) {
            otherNewsComponents.add(new NewsCardComponent(driver, otherNewsNode));
        }
        return otherNewsComponents;
    }

    /**
     * count of all other news in the view news page
     * @return int - count of all other news
     */
    @Step("Get all other news from page")
    public int getCountAllOtherNews() {
        return getCardsWithOtherNews().size();
    }

    /**
     * checks if 'donate' button is enabled
     * @return boolean
     */
    public boolean isDonateButtonEnabled() {
        return waitForElementToAppear(donateButton).isEnabled();
    }

    /**
     * show news title
     * @return String of news title
     */
    public String getNewsTitle() {
        return newsTitle.getText();
    }

    /**
     * show news date
     * @return String of news date
     */
    public String getNewsDate() {
        return newsDate.getText();
    }

    /**
     * show news description
     * @return String of news description
     */
    public String getNewsDescription() {
        return newsDescription.getText();
    }

    /**
     * get count of all other news
     * @return int - count of all other news
     */
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

    /**
     * click on a specific other news
     * @param componentNumber - number of other news card
     * @return opened NewsCardComponent
     */
    @Step("Choose specific other news")
    public NewsCardComponent chooseCertainOtherNews(int componentNumber) {
        return getCardsWithOtherNews().get(componentNumber);
    }
}
