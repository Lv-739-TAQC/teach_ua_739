package org.ssu.edu.teachua.ui.components.challenges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.challenges.ChallengesPage;

public class ChallengeComponent extends BaseComponent {
    private final String challengeId = "challengeId";
    private final String challengeSortNumber = "challengeSortNumber";
    private final String challengeName = "challengeName";
    private final String challengeTitle = "challengeTitle";
    private final String editBtn = "editBtn";
    private final String deleteBtn = "deleteBtn";
    public ChallengeComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }
    public WebElement getCurrentRoot() {
        return componentRoot;
    }
    public String getchallengeId() {
        return getCurrentRoot().findElement(By.className(challengeId)).getText();
    }
    public String getchallengeSortNumber() {
        return getCurrentRoot().findElement(By.className(challengeSortNumber)).getText();
    }
    public String getchallengeName() {
        return getCurrentRoot().findElement(By.className(getchallengeName())).getText();
    }
    public String getChallengeTitle() {
        return getCurrentRoot().findElement(By.className(challengeTitle)).getText();
    }

    public ChallengesPage clickEditButton() {
        getCurrentRoot().findElement(By.className(editBtn)).click();
        return new ChallengesPage(driver);
    }
    public ChallengesPage clickDeleteButton() {
        getCurrentRoot().findElement(By.className(deleteBtn)).click();
        return new ChallengesPage(driver);
    }
}
