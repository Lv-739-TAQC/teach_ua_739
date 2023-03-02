package org.ssu.edu.teachua.ui.pages.view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.card.NewsCardComponent;

import java.util.ArrayList;
import java.util.List;

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

    public NewsCardComponent chooseCertainOtherNews(int componentNumber) {
        return getCardsWithOtherNews().get(componentNumber);
    }
}
