package org.ssu.edu.teachua.ui.components.card;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.view.ViewClubPage;

public class ClubCardComponent extends BaseComponent {

    private final String clubTitle = "name";
    private final String detailsButton = "details-button";

    public ClubCardComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public String getClubTitle() {
        return getCurrentRoot().findElement(By.className(clubTitle)).getText();
    }

    public ViewClubPage clickDetailsButton() {
        getCurrentRoot().findElement(By.className(detailsButton)).click();
        return new ViewClubPage(driver);
    }
}
