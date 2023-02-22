package org.ssu.edu.teachua.ui.components.card;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.view.ViewClubPage;

public class ClubCardComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = ".//div[@class='name']")
    private WebElement clubTitle;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'details-button')]")
    private WebElement detailsButton;

    public ClubCardComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public String getClubTitle() {
        return clubTitle.getText();
    }

    public ViewClubPage clickDetailsButton() {
        detailsButton.click();
        return new ViewClubPage(driver);
    }
}
