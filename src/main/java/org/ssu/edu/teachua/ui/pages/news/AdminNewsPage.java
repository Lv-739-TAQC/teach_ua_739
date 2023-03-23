package org.ssu.edu.teachua.ui.pages.news;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.modal.add_news_component.AddNewsComponent;

/**
 * This class represents the admin news page, which extends the BasePage class.
 * It provides methods to interact with the page elements.
 */
public class AdminNewsPage extends BasePage {

    @FindBy(how = How.XPATH, using = ".//button[contains(@class,'add-btn')]")
    private WebElement addNewsButton;

    /**
     * Constructor for the AdminNewsPage class.
     *
     * @param driver The WebDriver object used to control the browser.
     */
    public AdminNewsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks the "Add News" button on the page.
     *
     * @return An AddNewsComponent object to interact with the "Add News" form.
     */
    @Step("Click add news article")
    public AddNewsComponent clickAddNewsArticle() {
        addNewsButton.click();
        return new AddNewsComponent(driver);
    }
}
