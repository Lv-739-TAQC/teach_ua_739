package org.ssu.edu.teachua.ui.components.card;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.view.ViewNewsPage;

public class NewsCardComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = ".//div[@id='newsDate']")
    private WebElement newsDate;

    @FindBy(how = How.XPATH, using = ".//div[@id='newsTitle']")
    private WebElement newsTitle;
    @FindBy(how = How.XPATH, using = ".//div[@id='newsImage']")
    private WebElement newsImage;

    @FindBy(how = How.XPATH, using = ".//span[@aria-label='arrow-right']")
    private WebElement detailsButton;

    public NewsCardComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public String getNewsDate() {
        return newsDate.getText();
    }

    public String getNewsTitle() {
        return newsTitle.getText();
    }

    @Step("Click the details button")
    public ViewNewsPage clickDetailsButton() {
        waitForElementToBeClickable(detailsButton).click();
        return new ViewNewsPage(driver);
    }

    @Step("Click on the title")
    public ViewNewsPage clickTitle() {
        newsTitle.click();
        return new ViewNewsPage(driver);
    }

    @Step("Click on the date")
    public ViewNewsPage clickDate() {
        newsDate.click();
        return new ViewNewsPage(driver);
    }

    @Step("Click on the image")
    public ViewNewsPage clickImage() {
        newsImage.click();
        return new ViewNewsPage(driver);
    }
}
