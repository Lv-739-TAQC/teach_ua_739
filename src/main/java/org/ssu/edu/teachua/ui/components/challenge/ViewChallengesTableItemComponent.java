package org.ssu.edu.teachua.ui.components.challenge;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.challenges.ChallengesPage;
import org.ssu.edu.teachua.ui.pages.challenges.EditChallengePage;

public class ViewChallengesTableItemComponent extends BaseComponent {
    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-table-cell']//a)[1]")
    private WebElement challengeId;
    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-table-cell']//a)[2]")
    private WebElement challengeSortNumber;
    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-table-cell']//a)[3]")
    private WebElement challengeName;
    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-table-cell']//a)[4]")
    private WebElement challengeTitle;
    @FindBy(how = How.XPATH, using = ".//*[text()='Редагувати']")
    private WebElement editBtn;
    @FindBy(how = How.XPATH, using = ".//*[text()='Видалити']")
    private WebElement deleteBtn;
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'popConfirm-ok')]")
    private WebElement confirmDeletingBtnNode;
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'popConfirm-cancel')]")
    private WebElement cancelDeletingBtnNode;

    public ViewChallengesTableItemComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    @Step("Click to challenge id")
    public EditChallengePage clickChallengeId() {
        waitForElementToBeClickable(challengeId).click();
        return new EditChallengePage(driver);
    }

    @Step("Click to challenge sort number")
    public EditChallengePage clickChallengeSortNumber() {
        waitForElementToBeClickable(challengeSortNumber).click();
        return new EditChallengePage(driver);
    }

    @Step("Click to challenge name")
    public EditChallengePage clickChallengeName() {
        waitForElementToBeClickable(challengeName).click();
        return new EditChallengePage(driver);
    }

    @Step("Click to challenge title")
    public EditChallengePage clickChallengeTitle() {
        waitForElementToBeClickable(challengeTitle).click();
        return new EditChallengePage(driver);
    }

    @Step("Edit challenge")
    public ViewChallengesTableItemComponent clickEditButton() {
        waitForElementToBeClickable(editBtn).click();
        return this;
    }

    @Step("Delete challenge")
    public ViewChallengesTableItemComponent clickDeleteButton() {
        waitForElementToBeClickable(deleteBtn).click();
        return this;
    }

    @Step("Confirm deleting of challenge")
    public ChallengesPage clickConfirmDeletingButton() {
        waitForElementToAppear(confirmDeletingBtnNode).click();
        return new ChallengesPage(driver);
    }

    @Step("Cancel deleting of challenge")
    public ChallengesPage clickCancelDeletingButton() {
        waitForElementToBeClickable(cancelDeletingBtnNode).click();
        return new ChallengesPage(driver);
    }

    @Step("Get challenge id")
    public String getIdValue() {
        return waitForElementToBeClickable(challengeId).getText();
    }

    @Step("Get challenge sort number")
    public String getSortNumberValue() {
        return waitForElementToAppear(challengeSortNumber).getText();
    }

    @Step("Get challenge name")
    public String getNameValue() {
        return waitForElementToAppear(challengeName).getText();
    }

    @Step("Get challenge title")
    public String getTitleValue() {
        return waitForElementToAppear(challengeTitle).getText();
    }
}

