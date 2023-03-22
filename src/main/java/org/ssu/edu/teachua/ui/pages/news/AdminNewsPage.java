package org.ssu.edu.teachua.ui.pages.news;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.modal.add_news_component.AddNewsComponent;

public class AdminNewsPage extends BasePage {

    @FindBy(how = How.XPATH, using = ".//button[contains(@class,'add-btn')]")
    private WebElement addNewsButton;

    public AdminNewsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click add news article")
    public AddNewsComponent clickAddNewsArticle() {
        addNewsButton.click();
        return new AddNewsComponent(driver);
    }
}
