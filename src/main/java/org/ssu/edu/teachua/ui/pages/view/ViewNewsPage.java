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

    @FindBy(how = How.XPATH, using = "//div[@id='date']")
    private WebElement newsDate;

    @FindBy(how = How.XPATH, using = "//div[@id='description']")
    private WebElement newsDescription;

    @FindBy(how = How.XPATH, using = "//div[@class='other-news']")
    private WebElement otherNewsTitle;

    @FindBy(how = How.XPATH, using = "//div[@class='slick-track']/*[position() <= 3]")
    private List<WebElement> otherNewsLocators;

    private List<NewsCardComponent> otherNewsComponents;


    public ViewNewsPage(WebDriver driver) {
        super(driver);
        otherNewsComponents = fillComponentsWithOtherNews();
    }

    private List<NewsCardComponent> fillComponentsWithOtherNews() {
        List<NewsCardComponent> components = new ArrayList<>();
        for (WebElement element : waitForElementsToAppear(otherNewsLocators)) {
            components.add(new NewsCardComponent(driver, element));
        }
        return components;
    }

    public int getCountAllOtherNews() {
        return otherNewsComponents.size();
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

    public NewsCardComponent getCertainOtherNews(int componentNumber) {
        return otherNewsComponents.get(componentNumber);
    }
}
