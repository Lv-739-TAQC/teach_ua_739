/**
 * package contains classes
 * related to new center creation functionality
 */

package org.ssu.edu.teachua.ui.components.modal.add_center_component;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.pages.profile.ProfilePage;

/**
 * class contains attributes and methods
 * related to club/clubs selection while creating a center,
 * navigation to the previous page
 * and center creation process completion buttons
 */
public class AddCenterClubsComponent extends BaseAddCenterComponent {

    /**
     * locator for finish club creation process button
     */
    @FindBy(how = How.XPATH, using = ".//button[@class='finish-btn']")
    private WebElement finishButton;

    /**
     * locator for the previous page button
     */
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'prev-btn')]")
    private WebElement backButton;

    /**
     * creation constructor matching super
     */
    public AddCenterClubsComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * choose a club for the center by entering club ordinal number in the list,
     * it is possible to choose several clubs for one center
     *
     * @param numberClub - club ordinal number in the list
     */
    @Step("Tick a club {clubNumber}")
    public AddCenterClubsComponent checkClub(int numberClub) {
        WebElement checkBoxLocation = driver.findElement(By.xpath(
                String.format(".//div[@id='clubs']//div[@class='checkbox-item'][%d]/label", numberClub)));
        checkBoxLocation.click();
        return this;
    }

    /**
     * click center creation process completion button
     *
     * @return opened Profile page
     * with a message shown that the center was successfully created
     */
    @Step("Press 'Завершити' button")
    public ProfilePage pressFinishButton() {
        finishButton.click();
        return new ProfilePage(driver);
    }

    /**
     * click navigation to the previous page button
     *
     * @return opened Description tab of the center creation component
     */
    @Step("Press 'Назад' button")
    public AddCenterDescriptionComponent pressBackButton() {
        this.backButton.click();
        return new AddCenterDescriptionComponent(driver);
    }

}
