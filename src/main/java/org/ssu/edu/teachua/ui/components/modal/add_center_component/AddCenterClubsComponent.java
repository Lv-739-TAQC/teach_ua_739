package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;

public class AddCenterClubsComponent extends BaseAddCenterComponent {

    @FindBy(how = How.XPATH, using = ".//button[@class='finish-btn']")
    private WebElement finishButton;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'prev-btn')]")
    private WebElement backButton;

    public AddCenterClubsComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Tick a club {clubNumber}")
    public AddCenterClubsComponent checkClub(int numberClub) {
        WebElement checkBoxLocation = driver.findElement(By.xpath(
                String.format(".//div[@id='clubs']//div[@class='checkbox-item'][%d]/label", numberClub)));
        checkBoxLocation.click();
        return this;
    }

    @Step("Press 'Завершити' button")
    public ProfilePage pressFinishButton() {
        finishButton.click();
        return new ProfilePage(driver);
    }

    @Step("Press 'Назад' button")
    public AddCenterDescriptionComponent pressBackButton() {
        this.backButton.click();
        return new AddCenterDescriptionComponent(driver);
    }

}
