package org.ssu.edu.teachua.ui.pages.challenges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.challenge.ViewChallengesTableItemComponent;
import org.ssu.edu.teachua.ui.pages.tasks.TasksPage;

import java.util.ArrayList;
import java.util.List;

public class ChallengesPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//*[@class='back-btn']")
    private WebElement tasksBtn;
    @FindBy(how = How.XPATH, using = "//a[@href='/dev/admin/addChallenge']")
    private WebElement addChallengeBtn;
    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'ant-input-group')]//*[@type='text']")
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = "//span[@class='ant-input-group-addon']")
    private WebElement searchBtn;
    @FindBy(how = How.XPATH, using = "//*[@title='Previous Page']")
    private WebElement previousPage;
    @FindBy(how = How.XPATH, using = "//*[@title='Next Page']")
    private WebElement nextPage;
    @FindBy(how = How.XPATH, using = "//*[@title='Next 5 Pages']")
    private WebElement stepOverNextFivePages;
    @FindBy(how = How.XPATH, using = "(//th[@class='ant-table-cell'])[1]")
    private WebElement nameOfFirstTableHeaderElement;
    @FindBy(how = How.XPATH, using = "(//th[@class='ant-table-cell'])[2]")
    private WebElement nameOfSecondTableHeaderElement;
    @FindBy(how = How.XPATH, using = "(//th[@class='ant-table-cell'])[3]")
    private WebElement nameOfThirdTableHeaderElement;
    @FindBy(how = How.XPATH, using = "(//th[@class='ant-table-cell'])[4]")
    private WebElement nameOfFourthTableHeaderElement;

    public ChallengesPage(WebDriver driver) {
        super(driver);
    }

    public TasksPage openTasks() {
        waitForElementToBeClickable(tasksBtn).click();
        return new TasksPage(driver);
    }

    public AddChallengePage addChallenge() {
        waitForElementToBeClickable(addChallengeBtn).click();
        return new AddChallengePage(driver);
    }

    public ChallengesPage fillSearchField(String textToSearch) {
        waitForElementToBeClickable(searchField).sendKeys(textToSearch);
        return this;
    }

    public ChallengesPage clickSearchButton() {
        waitForElementToBeClickable(searchBtn).click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage openPreviousPage() {
        waitForElementToBeClickable(previousPage).click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage openNextPage() {
        waitForElementToBeClickable(nextPage).click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage stepOverNextFivePages() {
        waitForElementToBeClickable(stepOverNextFivePages).click();
        return new ChallengesPage(driver);
    }

    public String getNameOfFirstTableHeaderElement() {
        return waitForElementToAppear(nameOfFirstTableHeaderElement).getText();
    }

    public String getNameOfSecondTableHeaderElement() {
        return waitForElementToAppear(nameOfSecondTableHeaderElement).getText();
    }

    public String getNameOfThirdTableHeaderElement() {
        return waitForElementToAppear(nameOfThirdTableHeaderElement).getText();
    }

    public String getNameOfFourthTableHeaderElement() {
        return waitForElementToAppear(nameOfFourthTableHeaderElement).getText();
    }

    private List<ViewChallengesTableItemComponent> getChallengesTableItems() {
        List<ViewChallengesTableItemComponent> challengesComponents = new ArrayList<>();
        for (WebElement challengeNode : waitForElementsToAppear(driver.findElements(By.xpath("//*[contains(@class, 'level-0 editable-row')]")))) {
            challengesComponents.add(new ViewChallengesTableItemComponent(driver, challengeNode));
        }
        return challengesComponents;
    }

    public int getCountAllChallenges() {
        return getChallengesTableItems().size();
    }

    public ViewChallengesTableItemComponent selectCertainChallenge(int challengeIndex) {
        return getChallengesTableItems().get(challengeIndex);
    }

}


