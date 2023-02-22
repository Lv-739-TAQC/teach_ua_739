package org.ssu.edu.teachua.ui.pages.challenges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.challenge.ChallengesTableItemComponent;
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
    @FindBy(how = How.XPATH, using = "//*[contains(@class, 'level-0 editable-row')]")
    private List<WebElement> challengeLocators;
    private List<ChallengesTableItemComponent> challengeComponents;

    public ChallengesPage(WebDriver driver) {
        super(driver);
        challengeComponents = fillComponentsWithChallenges();
    }

    public TasksPage openTasks() {
        tasksBtn.click();
        return new TasksPage(driver);
    }

    public AddChallengePage addChallenge() {
        addChallengeBtn.click();
        return new AddChallengePage(driver);
    }

    public ChallengesPage fillSearchField(String textToSearch) {
        searchField.sendKeys(textToSearch);
        return this;
    }

    public ChallengesPage clickSearchButton() {
        searchBtn.click();
        return this;
    }

    public ChallengesPage openPreviousPage() {
        previousPage.click();
        return this;
    }

    public ChallengesPage openNextPage() {
        nextPage.click();
        return this;
    }

    public ChallengesPage stepOverNextFivePages() {
        stepOverNextFivePages.click();
        return this;
    }

    private List<ChallengesTableItemComponent> fillComponentsWithChallenges() {
        List<ChallengesTableItemComponent> components = new ArrayList<>();
        for (WebElement element : challengeLocators) {
            components.add(new ChallengesTableItemComponent(driver, element));
        }
        return components;
    }

    public int countAllChallenges() {
        return challengeComponents.size();
    }

    public ChallengesTableItemComponent getChallengeByIndex(int index) {
        return challengeComponents.get(index);
    }

}


