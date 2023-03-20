package org.ssu.edu.teachua.ui.components.challenge;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.challenges.ChallengesPage;
import org.ssu.edu.teachua.ui.pages.challenges.EditChallengePage;

public class EditChallengesTableItemComponent extends BaseComponent {
    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-table-cell']//a)[1]")
    private WebElement challengeId;
    @FindBy(how = How.XPATH, using = ".//input[@id='sortNumber']")
    private WebElement editSortNumber;
    @FindBy(how = How.XPATH, using = ".//input[@id='name']")
    private WebElement editName;
    @FindBy(how = How.XPATH, using = ".//input[@id='title']")
    private WebElement editTitle;
    @FindBy(how = How.XPATH, using = ".//*[text()='Зберегти']")
    private WebElement saveChangesBtn;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'popConfirm-ok-button')]")
    private WebElement confirmSavingChangesBtn;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'popConfirm-cancel-button')]")
    private WebElement cancelSavingChangesBtn;
    @FindBy(how = How.XPATH, using = ".//*[text()='Відмінити']")
    private WebElement cancelEditingBtn;

    public EditChallengesTableItemComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    /**
     * click challenge 'id'
     * @return opened EditChallengePage with selected challenge
     */
    @Step("Click to challenge id")
    public EditChallengePage clickChallengeId() {
        waitForElementToBeClickable(challengeId).click();
        return new EditChallengePage(driver);
    }

    /**
     * clear sort number of challenge
     * @return EditChallengesTableItemComponent with removed sort number
     */
    @Step("Clear challenge sort number field")
    public EditChallengesTableItemComponent clearChallengeSortNumber() {
        waitForElementToBeClickable(editSortNumber).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    /**
     * type sort number for challenge
     * @param sortNumber - sort number of challenge
     * @return EditChallengesTableItemComponent with typed sort number
     */
    @Step("Type '{sortNumber}' into challenge sort number field")
    public EditChallengesTableItemComponent fillChallengeSortNumber(String sortNumber) {
        waitForElementToBeClickable(editSortNumber).sendKeys(sortNumber);
        return this;
    }

    /**
     * clear name of challenge
     * @return EditChallengesTableItemComponent with removed name
     */
    @Step("Clear challenge name field")
    public EditChallengesTableItemComponent clearChallengeName() {
        waitForElementToBeClickable(editName).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    /**
     * type name for challenge
     * @param name - name of challenge
     * @return EditChallengesTableItemComponent with typed name
     */
    @Step("Type '{name}' into challenge name field")
    public EditChallengesTableItemComponent fillChallengeName(String name) {
        waitForElementToBeClickable(editName).sendKeys(name);
        return this;
    }

    /**
     * clear title of challenge
     * @return EditChallengesTableItemComponent with removed title
     */
    @Step("Clear challenge title field")
    public EditChallengesTableItemComponent clearChallengeTitle() {
        waitForElementToBeClickable(editTitle).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    /**
     * type title for challenge
     * @param title - title of challenge
     * @return EditChallengesTableItemComponent with typed title
     */
    @Step("Type '{title}' into challenge title field")
    public EditChallengesTableItemComponent fillChallengeTitle(String title) {
        waitForElementToBeClickable(editTitle).sendKeys(title);
        return this;
    }

    /**
     * click 'save' button
     * @return EditChallengesTableItemComponent and pop-up with a confirmation/cancellation message
     */
    @Step("Save challenge")
    public EditChallengesTableItemComponent clickSaveButton() {
        waitForElementToBeClickable(saveChangesBtn).click();
        return this;
    }

    /**
     * click 'confirm' button
     * @return opened ChallengesPage, updated challenge is shown in the page
     */
    @Step("Confirm saving of challenge")
    public ChallengesPage clickConfirmSavingButton() {
        waitForElementToBeClickable(confirmSavingChangesBtn).click();
        return new ChallengesPage(driver);
    }

    /**
     * click 'cancel' button
     * @return opened EditChallengesTableItemComponent, challenge component has returned to the editing stage
     */
    @Step("Cancel saving of challenge")
    public EditChallengesTableItemComponent clickCancelSavingButton() {
        waitForElementToBeClickable(cancelSavingChangesBtn).click();
        return this;
    }

    /**
     * click 'cancel' button
     * @return opened ChallengesPage, edited challenge has not been updated
     */
    @Step("Cancel editing of challenge")
    public ChallengesPage clickCancelEditingButton() {
        waitForElementToBeClickable(cancelEditingBtn).click();
        return new ChallengesPage(driver);
    }

}
