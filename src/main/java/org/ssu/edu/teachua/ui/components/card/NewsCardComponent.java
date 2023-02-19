package org.ssu.edu.teachua.ui.components.card;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.view.ViewNewsPage;

public class NewsCardComponent extends BaseComponent {

    private final String newsDate = "newsDate";
    private final String newsTitle = "newsTitle";
    private final String detailsButton = "anticon-arrow-right";

    public NewsCardComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public String getNewsDate() {
        return getCurrentRoot().findElement(By.id(newsDate)).getText();
    }

    public String getNewsTitle() {
        return getCurrentRoot().findElement(By.id(newsTitle)).getText();
    }

    public ViewNewsPage clickDetailsButton() {
        getCurrentRoot().findElement(By.className(detailsButton)).click();
        return new ViewNewsPage(driver);
    }
}
