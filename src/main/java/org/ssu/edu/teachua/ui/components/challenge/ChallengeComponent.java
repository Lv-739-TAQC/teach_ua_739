package org.ssu.edu.teachua.ui.components.challenges;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.challenges.ChallengesPage;

public class ChallengeComponent extends BaseComponent {
    private final String challengeId = "challengeId";
    private final String challengeSortNumber = "challengeSortNumber";
    private final String challengeName = "challengeName";
    private final String challengeTitle = "challengeTitle";
    private final String editSortNumber = "editSortNumber";
    private final String editName = "editName";
    private final String editTitle = "editTitle";
    private final String editBtn = "editBtn";
    private final String deleteBtn = "deleteBtn";
    private final String saveChangesBtn = "saveChangesBtn";
    private final String cancelEditingBtn = "cancelEditingBtn";
    private final String confirmDeletingBtn = "confirmDeletingBtn";
    private final String cancelDeletingBtn = "cancelDeletingBtn";
    public ChallengeComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }
    //delete later the next two lines:
    public WebElement getCurrentRoot() {
        return componentRoot;
    }
    public ChallengesPage clickChallengeId() {
        getCurrentRoot().findElement(By.className(challengeId)).click();
        return new ChallengesPage(driver);
    }
    public ChallengesPage clickChallengeSortNumber() {
        getCurrentRoot().findElement(By.className(challengeSortNumber)).click();
        return new ChallengesPage(driver);
    }
    public ChallengesPage clickChallengeName() {
        getCurrentRoot().findElement(By.className(challengeName)).click();
        return new ChallengesPage(driver);
    }
    public ChallengesPage clickChallengeTitle() {
        getCurrentRoot().findElement(By.className(challengeTitle)).click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickEditButton() {
        getCurrentRoot().findElement(By.className(editBtn)).click();
        return new ChallengesPage(driver); //this
    }
    public ChallengesPage editChallengeSortNumber(String sortNumber) {
        getCurrentRoot().findElement(By.className(editSortNumber)).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        getCurrentRoot().findElement(By.className(editSortNumber)).sendKeys(sortNumber);
        return new ChallengesPage(driver); //this
    }
    public ChallengesPage editChallengeName(String name) {
        getCurrentRoot().findElement(By.className(editName)).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        getCurrentRoot().findElement(By.className(editName)).sendKeys(name);
        return new ChallengesPage(driver); //this
    }
    public ChallengesPage editChallengeTitle(String title) {
        getCurrentRoot().findElement(By.className(editTitle)).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        getCurrentRoot().findElement(By.className(editTitle)).sendKeys(title);
        return new ChallengesPage(driver); //this
    }
    public ChallengesPage clickSaveButton() {
        getCurrentRoot().findElement(By.className(saveChangesBtn)).click();
        return new ChallengesPage(driver); //this
    }
    public ChallengesPage clickCancelEditingButton() {
        getCurrentRoot().findElement(By.className(cancelEditingBtn)).click();
        return new ChallengesPage(driver); //this
    }
    public ChallengesPage clickDeleteButton() {
        getCurrentRoot().findElement(By.className(deleteBtn)).click();
        return new ChallengesPage(driver); //this
    }
    public ChallengesPage clickConfirmDeletingButton() {
        getCurrentRoot().findElement(By.className(confirmDeletingBtn)).click();
        return new ChallengesPage(driver); //this
    }
    public ChallengesPage clickCancelDeletingButton() {
        getCurrentRoot().findElement(By.className(cancelDeletingBtn)).click();
        return new ChallengesPage(driver); //this
    }
}

