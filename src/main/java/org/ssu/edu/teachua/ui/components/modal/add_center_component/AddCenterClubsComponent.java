package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;

public class AddCenterClubsComponent extends BaseAddCenterComponent {
    @FindBy(how = How.XPATH, using = "(.//input[@class='ant-checkbox-input'])[2]")
    private WebElement clubToCheck;
    @FindBy(how = How.XPATH, using = ".//button[@class='finish-btn']")
    private WebElement finishButton;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'prev-btn')]")
    private WebElement backButton;

    public AddCenterClubsComponent(WebDriver driver) {
        super(driver);
    }

    public AddCenterClubsComponent checkClub(String club) {
        clubToCheck.click();
        return this;
    }

    public ProfilePage pressFinishButton() {
        finishButton.click();
        return new ProfilePage(driver);
    }

    public AddCenterDescriptionComponent pressBackButton() {
        this.backButton.click();
        return new AddCenterDescriptionComponent(driver);
    }

}
