package org.ssu.edu.teachua.ui.components.challenge;

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
    public EditChallengePage clickChallengeId() {
        waitForElementToBeClickable(challengeId).click();
        return new EditChallengePage(driver);
    }
    public EditChallengesTableItemComponent clearChallengeSortNumber() {
        waitForElementToBeClickable(editSortNumber).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    public EditChallengesTableItemComponent fillChallengeSortNumber(String sortNumber) {
        waitForElementToBeClickable(editSortNumber).sendKeys(sortNumber);
        return this;
    }

    public EditChallengesTableItemComponent clearChallengeName() {
        waitForElementToBeClickable(editName).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    public EditChallengesTableItemComponent fillChallengeName(String name) {
        waitForElementToBeClickable(editName).sendKeys(name);
        return this;
    }

    public EditChallengesTableItemComponent clearChallengeTitle() {
        waitForElementToBeClickable(editTitle).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    public EditChallengesTableItemComponent fillChallengeTitle(String title) {
        waitForElementToBeClickable(editTitle).sendKeys(title);
        return this;
    }

    public EditChallengesTableItemComponent clickSaveButton() {
        waitForElementToBeClickable(saveChangesBtn).click();
        return this;
    }

    public ChallengesPage clickConfirmSavingButton() {
        waitForElementToBeClickable(confirmSavingChangesBtn).click();
        return new ChallengesPage(driver);
    }

    public EditChallengesTableItemComponent clickCancelSavingButton() {
        waitForElementToBeClickable(cancelSavingChangesBtn).click();
        return this;
    }

    public ChallengesPage clickCancelEditingButton() {
        waitForElementToBeClickable(cancelEditingBtn).click();
        return new ChallengesPage(driver);
    }

}
