package org.ssu.edu.teachua.ui.components.card;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.view.ViewClubPage;

import java.util.List;

public class ClubCardComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = ".//div[@class='name']")
    private WebElement clubTitle;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'details-button')]")
    private WebElement detailsButton;

    @FindBy(how = How.XPATH, using = ".//li[contains(@class , 'ant-rate-star')]")
    private List<WebElement> starsRating;

    public ClubCardComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public String getClubTitle() {
        return clubTitle.getText();
    }

    @Step("Click the details button")
    public ViewClubPage clickDetailsButton() {
        detailsButton.click();
        return new ViewClubPage(driver);
    }

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
