package org.ssu.edu.teachua.ui.components.modal.add_news_component;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.view.ViewNewsPage;

public class AddNewsComponent extends BaseComponent {
    public AddNewsComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = ".//textarea[@id='news-from_title']")
    private WebElement newsTitle;
    @FindBy(how = How.XPATH, using = ".//div[contains(@class,'ql-editor')]")
    private WebElement newsContent;
    @FindBy(how = How.XPATH, using = ".//input[@id='news-from_urlTitleLogo']")
    private WebElement newsPhoto;
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'ant-upload-list-item-done')]")
    private WebElement photoAppeared;
    @FindBy(how = How.XPATH, using = ".//button[@type='submit' and contains(@class,'formButton')]")
    private WebElement submitButton;

    @Step("Add a title {title}")
    public AddNewsComponent addNewsTitle(String title) {
        newsTitle.sendKeys(title);
        return this;
    }

    @Step("Add a content {content}")
    public AddNewsComponent addNewsContent(String content) {
        newsContent.sendKeys(content);
        return this;
    }

    @Step("Add a photo {photoPath}")
    public AddNewsComponent addNewsPhoto(String photoPath) {
        newsPhoto.sendKeys(photoPath);
        waitForElementToAppear(photoAppeared);
        return this;
    }

    @Step("Submit adding news article")
    public ViewNewsPage clickSubmit() {
        submitButton.click();
        return new ViewNewsPage(driver);
    }


}
