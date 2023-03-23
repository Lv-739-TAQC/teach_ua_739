/**
 * package contains classes
 * related to challenges page, creating & editing of challenge
 */
package org.ssu.edu.teachua.ui.pages.challenges;

import io.qameta.allure.Step;
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

/**
 * class contains elements and methods which represents
 * the Challenges page
 */
public class ChallengesPage extends BasePage {

    /**
     * WebElement represents 'tasks' button which opens {@link TasksPage}
     */
    @FindBy(how = How.XPATH, using = "//*[@class='back-btn']")
    private WebElement tasksBtn;
    /**
     * WebElement represents 'add challenge' button which opens {@link AddChallengePage}
     */
    @FindBy(how = How.XPATH, using = "//a[@href='/dev/admin/addChallenge']")
    private WebElement addChallengeBtn;
    /**
     * WebElement represents search field
     */
    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'ant-input-group')]//*[@type='text']")
    private WebElement searchField;
    /**
     * WebElement represents 'click to search' button
     */
    @FindBy(how = How.XPATH, using = "//span[@class='ant-input-group-addon']")
    private WebElement searchBtn;
    /**
     * WebElement represents 'previous page' button in pagination
     */
    @FindBy(how = How.XPATH, using = "//*[@title='Previous Page']")
    private WebElement previousPage;
    /**
     * WebElement represents 'next page' button in pagination
     */
    @FindBy(how = How.XPATH, using = "//*[@title='Next Page']")
    private WebElement nextPage;
    /**
     * WebElement represents 'step oer next five pages' button in pagination
     */
    @FindBy(how = How.XPATH, using = "//*[@title='Next 5 Pages']")
    private WebElement stepOverNextFivePages;
    /**
     * WebElement represents text of first table header element
     */
    @FindBy(how = How.XPATH, using = "(//th[@class='ant-table-cell'])[1]")
    private WebElement nameOfFirstTableHeaderElement;
    /**
     * WebElement represents text of second table header element
     */
    @FindBy(how = How.XPATH, using = "(//th[@class='ant-table-cell'])[2]")
    private WebElement nameOfSecondTableHeaderElement;
    /**
     * WebElement represents text of third table header element
     */
    @FindBy(how = How.XPATH, using = "(//th[@class='ant-table-cell'])[3]")
    private WebElement nameOfThirdTableHeaderElement;
    /**
     * WebElement represents text of fourth table header element
     */
    @FindBy(how = How.XPATH, using = "(//th[@class='ant-table-cell'])[4]")
    private WebElement nameOfFourthTableHeaderElement;

    /**
     * creation constructor matching super with one parameter
     */
    public ChallengesPage(WebDriver driver) {
        super(driver);
    }

    /**
     * click 'to the list of tasks' button and open {@link TasksPage}
     * @return opened {@link TasksPage}
     */
    @Step("Open tasks page")
    public TasksPage openTasks() {
        waitForElementToBeClickable(tasksBtn).click();
        return new TasksPage(driver);
    }

    /**
     * click 'add challenge' button and open {@link AddChallengePage}
     * @return opened {@link AddChallengePage}
     */
    @Step("Add challenge")
    public AddChallengePage addChallenge() {
        waitForElementToBeClickable(addChallengeBtn).click();
        return new AddChallengePage(driver);
    }

    /**
     * type text into search field
     * @param textToSearch -  text to search for
     * @return ChallengesPage with typed text in search field
     */
    @Step("Type '{textToSearch}' into search field")
    public ChallengesPage fillSearchField(String textToSearch) {
        waitForElementToBeClickable(searchField).sendKeys(textToSearch);
        return this;
    }

    /**
     * click to 'search' button
     * @return found challenge in the ChallengesPage
     */
    @Step("Click search button")
    public ChallengesPage clickSearchButton() {
        waitForElementToBeClickable(searchBtn).click();
        return new ChallengesPage(driver);
    }

    /**
     * click to 'previous page' button in the pagination bar
     * @return opened previous ChallengesPage
     */
    @Step("Open previous page")
    public ChallengesPage openPreviousPage() {
        waitForElementToBeClickable(previousPage).click();
        return new ChallengesPage(driver);
    }

    /**
     * click to 'next page' button in the pagination bar
     * @return opened next ChallengesPage
     */
    @Step("Open next page")
    public ChallengesPage openNextPage() {
        waitForElementToBeClickable(nextPage).click();
        return new ChallengesPage(driver);
    }

    /**
     * click to 'step over next five pages' button in the pagination bar
     * @return opened fifth ChallengesPage
     */
    @Step("Step over next five pages")
    public ChallengesPage stepOverNextFivePages() {
        waitForElementToBeClickable(stepOverNextFivePages).click();
        return new ChallengesPage(driver);
    }

    /**
     * show name of first table header element
     * @return text of first table header element name from the ChallengesPage
     */
    @Step("Get name of first table header element")
    public String getNameOfFirstTableHeaderElement() {
        return waitForElementToAppear(nameOfFirstTableHeaderElement).getText();
    }

    /**
     * show name of second table header element
     * @return text of second table header element name from the ChallengesPage
     */
    @Step("Get name of second table header element")
    public String getNameOfSecondTableHeaderElement() {
        return waitForElementToAppear(nameOfSecondTableHeaderElement).getText();
    }

    /**
     * show name of third table header element
     * @return text of third table header element name from the ChallengesPage
     */
    @Step("Get name of third table header element")
    public String getNameOfThirdTableHeaderElement() {
        return waitForElementToAppear(nameOfThirdTableHeaderElement).getText();
    }

    /**
     * show name of fourth table header element
     * @return text of fourth table header element name from the ChallengesPage
     */
    @Step("Get name of fourth table header element")
    public String getNameOfFourthTableHeaderElement() {
        return waitForElementToAppear(nameOfFourthTableHeaderElement).getText();
    }

    /**
     * show the list with all challenges
     * @return list with challenge components from the ChallengesPage
     */
    @Step("Get all challenges")
    private List<ViewChallengesTableItemComponent> getChallengesTableItems() {
        List<ViewChallengesTableItemComponent> challengesComponents = new ArrayList<>();
        for (WebElement challengeNode : waitForElementsToAppear(driver.findElements(By.xpath("//*[contains(@class, 'level-0 editable-row')]")))) {
            challengesComponents.add(new ViewChallengesTableItemComponent(driver, challengeNode));
        }
        return challengesComponents;
    }

    /**
     * count challenges
     * @return quantity of challenges from the ChallengesPage
     */
    @Step("Count challenges")
    public int getCountAllChallenges() {
        return getChallengesTableItems().size();
    }

    /**
     * select by index from all challenges
     * @param challengeIndex - choose certain challenge index
     * @return challenge component from the ChallengesPage
     */
    @Step("Select challenge by index: '{challengeIndex}'")
    public ViewChallengesTableItemComponent selectCertainChallenge(int challengeIndex) {
        return getChallengesTableItems().get(challengeIndex);
    }

}


