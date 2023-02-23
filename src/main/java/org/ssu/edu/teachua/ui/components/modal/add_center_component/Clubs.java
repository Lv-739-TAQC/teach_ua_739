package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;

public class Clubs extends BaseAddCenterComponent {
    public Clubs(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    @FindBy(how = How.XPATH, using = "(.//input[@class='ant-checkbox-input'])[2]")
    private WebElement clubToCheck;
    @FindBy(how = How.XPATH, using = ".//button[@class='finish-btn']")
    private WebElement finishButton;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'prev-btn')]")
    private WebElement backButton;


    // @Step("Clubs: check a club from the list")
    public Clubs checkClub(String club) {
        clubToCheck.click();
        return this;
    }

    // @Step("Clubs: press Finish button")
    public ProfilePage pressFinishButton() {
        finishButton.click();
        return new ProfilePage(driver);
    }

    // @Step("Clubs: Press Back button")
    public Description pressBackButton() {
        this.backButton.click();
        return new Description(driver, addCenterContainer);
    }

}
