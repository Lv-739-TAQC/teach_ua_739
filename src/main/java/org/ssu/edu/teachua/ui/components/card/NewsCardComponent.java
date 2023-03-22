package org.ssu.edu.teachua.ui.components.card;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.view.ViewNewsPage;

/**
 * This class contains elements and methods that
 * represent the news card functionality
 */
public class NewsCardComponent extends BaseComponent {

    /**
     * locator represents news date
     */
    @FindBy(how = How.XPATH, using = ".//div[@id='newsDate']")
    private WebElement newsDate;

    /**
     * locator represents news title
     */
    @FindBy(how = How.XPATH, using = ".//div[@id='newsTitle']")
    private WebElement newsTitle;

    /**
     * locator represents news image
     */
    @FindBy(how = How.XPATH, using = ".//div[@id='newsImage']")
    private WebElement newsImage;

    /**
     * locator represents 'details' button
     */
    @FindBy(how = How.XPATH, using = ".//span[@aria-label='arrow-right']")
    private WebElement detailsButton;

    public NewsCardComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    /**
     * get news date
     * @return String of this date
     */
    public String getNewsDate() {
        return newsDate.getText();
    }

    /**
     * get title of news
     * @return String of this title
     */
    public String getNewsTitle() {
        return newsTitle.getText();
    }

    /**
     * click 'details' button
     * @return opened ViewNewsPage
     */
    @Step("Click the details button")
    public ViewNewsPage clickDetailsButton() {
        waitForElementToBeClickable(detailsButton).click();
        return new ViewNewsPage(driver);
    }

    /**
     * click on the title
     * @return opened ViewNewsPage
     */
    @Step("Click on the title")
    public ViewNewsPage clickTitle() {
        newsTitle.click();
        return new ViewNewsPage(driver);
    }

    /**
     * click on the date
     * @return opened ViewNewsPage
     */
    @Step("Click on the date")
    public ViewNewsPage clickDate() {
        newsDate.click();
        return new ViewNewsPage(driver);
    }

    /**
     * click on the image
     * @return opened ViewNewsPage
     */
    @Step("Click on the image")
    public ViewNewsPage clickImage() {
        newsImage.click();
        return new ViewNewsPage(driver);
    }
}
