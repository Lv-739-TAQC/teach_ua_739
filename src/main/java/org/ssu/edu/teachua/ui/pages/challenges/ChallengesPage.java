package org.ssu.edu.teachua.ui.pages.challenges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.challenges.ChallengeComponent;

import java.util.ArrayList;
import java.util.List;

public class ChallengesPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//*[@class='back-btn']")
    private WebElement goToTheListOfTasks;
    @FindBy(how = How.XPATH, using = "//a[@href='/dev/admin/addChallenge']")
    private WebElement addChallenge;
    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'ant-input-group')]//*[@type='text']")
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = "//span[@class='ant-input-group-addon']")
    private WebElement searchButton;
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-table-cell']//a)[1]")
    private WebElement challengeId;
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-table-cell']//a)[2]")
    private WebElement challengeSortNumber;
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-table-cell']//a)[3]")
    private WebElement challengeName;
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-table-cell']//a)[4]")
    private WebElement challengeTitle;
    @FindBy(how = How.XPATH, using = "(//*[text()='Редагувати'])[1]")
    private WebElement editChallenge;
    @FindBy(how = How.XPATH, using = "//input[@id='sortNumber']")
    private WebElement editChallengeSortNumber;
    @FindBy(how = How.XPATH, using = "//input[@id='name']")
    private WebElement editChallengeName;
    @FindBy(how = How.XPATH, using = "//input[@id='title']")
    private WebElement editChallengeTitle;
    @FindBy(how = How.XPATH, using = "(//*[text()='Зберегти'])")
    private WebElement saveEditedChallenge;
    @FindBy(how = How.XPATH, using = "(//*[text()='Відмінити'])")
    private WebElement cancelEditedChallenge;
    @FindBy(how = How.XPATH, using = "(//*[text()='Видалити'])[1]")
    private WebElement deleteChallenge;
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'popConfirm-ok')]")
    private WebElement confirmDeletingChallenge;
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'popConfirm-cancel')]")
    private WebElement cancelDeletingChallenge;
    @FindBy(how = How.XPATH, using = "//*[@title='Previous Page']")
    private WebElement goToPreviousPage;
    @FindBy(how = How.XPATH, using = "//*[@title='Next Page']")
    private WebElement goToNextPage;
    @FindBy(how = How.XPATH, using = "//*[@title='Next 5 Pages']")
    private WebElement stepOverNextFivePages;
    private final List<ChallengeComponent> challenges;

    public ChallengesPage(WebDriver driver) {
        super(driver);
        challenges = initChallenges();
    }

    public ChallengesPage clickGoToTheListOfTasks() {
        goToTheListOfTasks.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickAddChallenge() {
        addChallenge.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickAndFillSearchField(String textToSend) {
        searchField.click();
        searchField.sendKeys(textToSend);
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickSearchButton() {
        searchButton.click();
        return new ChallengesPage(driver);
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

    public ChallengesPage clickEditChallengeSortNumberAndSave(String textToSend) {
        editChallenge.click();
        editChallengeSortNumber.click();
        editChallengeSortNumber.clear();
        editChallengeSortNumber.sendKeys(textToSend);
        saveEditedChallenge.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickEditChallengeNameAndSave(String textToSend) {
        editChallenge.click();
        editChallengeName.click();
        editChallengeName.clear();
        editChallengeName.sendKeys(textToSend);
        saveEditedChallenge.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickEditChallengeTitleAndSave(String textToSend) {
        editChallenge.click();
        editChallengeTitle.click();
        editChallengeTitle.clear();
        editChallengeTitle.sendKeys(textToSend);
        saveEditedChallenge.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickEditChallengeAndCancel() {
        editChallenge.click();
        cancelEditedChallenge.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickDeleteChallengeAndConfirm() {
        deleteChallenge.click();
        confirmDeletingChallenge.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickDeleteChallengeAndCancel() {
        deleteChallenge.click();
        cancelDeletingChallenge.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickGoToPreviousPage() {
        goToPreviousPage.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickGoToNextPage() {
        goToNextPage.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickStepOverNextFivePages() {
        stepOverNextFivePages.click();
        return new ChallengesPage(driver);
    }

    private List<ChallengeComponent> initChallenges() {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='ant-table-row ant-table-row-level-0 editable-row']"));
        List<ChallengeComponent> challenges = new ArrayList<>();
        for (WebElement element : elements) {
            challenges.add(new ChallengeComponent(driver, element));
        }
        return challenges;
    }

}
