package org.ssu.edu.teachua.ui.components.card;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.view.ViewClubPage;

import java.util.List;

/**
 * This class contains elements and methods that
 * represent the club card functionality
 */
public class ClubCardComponent extends BaseComponent {

    /**
     * locator represents club title
     */
    @FindBy(how = How.XPATH, using = ".//div[@class='name']")
    private WebElement clubTitle;

    /**
     * locator represents center title
     */
    @FindBy(how = How.XPATH, using = ".//div[@class='center-name']")
    private WebElement centerTitle;

    /**
     * locator represents 'details' button
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'details-button')]")
    private WebElement detailsButton;

    /**
     * locator represents a list of star rating
     */
    @FindBy(how = How.XPATH, using = ".//li[contains(@class , 'ant-rate-star')]")
    private List<WebElement> starsRating;

    public ClubCardComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    /**
     * get title of club
     * @return String of this title
     */
    @Step("Get club title")
    public String getClubTitle() {
        return clubTitle.getText();
    }

    /**
     * get title of center
     * @return String of this title
     */
    public String getCenterTitle() {
        return centerTitle.getText();
    }

    /**
     * click 'details' button
     * @return opened ViewClubPage
     */
    @Step("Click the details button")
    public ViewClubPage clickDetailsButton() {
        detailsButton.click();
        return new ViewClubPage(driver);
    }

    /**
     * get rating of club
     * @return int - club's rating
     */
    public int getRating() {
        int count = 0;
        for (WebElement star : starsRating) {
            if (star.getAttribute("class").contains("ant-rate-star-full")) {
                count++;
            }
        }
        return count;
    }
}
