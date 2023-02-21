package org.ssu.edu.teachua.ui.components.challenge;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.challenges.ChallengesPage;

public class ChallengeComponent extends BaseComponent {
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
    @FindBy(how = How.XPATH, using = ".//input[@id='sortNumber']")
    private WebElement editSortNumber;
    @FindBy(how = How.XPATH, using = ".//input[@id='name']")
    private WebElement editName;
    @FindBy(how = How.XPATH, using = ".//input[@id='title']")
    private WebElement editTitle;
    @FindBy(how = How.XPATH, using = "(.//*[text()='Зберегти'])")
    private WebElement saveChangesBtn;
    @FindBy(how = How.XPATH, using = "(.//*[text()='Відмінити'])")
    private WebElement cancelEditingBtn;
    @FindBy(how = How.XPATH, using = ".//*[text()='Видалити']")
    private WebElement deleteBtn;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'popConfirm-ok')]")
    private WebElement confirmDeletingBtn;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'popConfirm-cancel')]")
    private WebElement cancelDeletingBtn;

    public ChallengeComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public ChallengesPage clickChallengeId() {
        challengeId.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickChallengeSortNumber() {
        challengeSortNumber.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickChallengeName() {
        challengeName.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickChallengeTitle() {
        challengeTitle.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickEditButton() {
        editBtn.click();
        return new ChallengesPage(driver); //this
    }

    public ChallengesPage editChallengeSortNumber(String sortNumber) {
        editSortNumber.sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        editSortNumber.sendKeys(sortNumber);
        return new ChallengesPage(driver); //this
    }

    public ChallengesPage editChallengeName(String name) {
        editName.sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        editName.sendKeys(name);
        return new ChallengesPage(driver); //this
    }

    public ChallengesPage editChallengeTitle(String title) {
        editTitle.sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        editTitle.sendKeys(title);
        return new ChallengesPage(driver); //this
    }

    public ChallengesPage clickSaveButton() {
        saveChangesBtn.click();
        return new ChallengesPage(driver); //this
    }

    public ChallengesPage clickCancelEditingButton() {
        cancelEditingBtn.click();
        return new ChallengesPage(driver); //this
    }

    public ChallengesPage clickDeleteButton() {
        deleteBtn.click();
        return new ChallengesPage(driver); //this
    }

    public ChallengesPage clickConfirmDeletingButton() {
        confirmDeletingBtn.click();
        return new ChallengesPage(driver); //this
    }

    public ChallengesPage clickCancelDeletingButton() {
        cancelDeletingBtn.click();
        return new ChallengesPage(driver); //this
    }

    public String readId() {
        return challengeId.getText();
    }

    public String readSortNumber() {
        return challengeSortNumber.getText();
    }

    public String readName() {
        return challengeName.getText();
    }

    public String readTitle() {
        return challengeTitle.getText();
    }
}

