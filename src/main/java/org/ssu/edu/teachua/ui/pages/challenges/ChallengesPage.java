package org.ssu.edu.teachua.ui.pages.challenges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.components.challenge.ChallengeComponent;

import java.util.ArrayList;
import java.util.List;

public class ChallengesPage extends BasePage {
    @FindBy(how = How.XPATH, using = ".//*[@class='back-btn']")
    private WebElement tasksBtn;
    @FindBy(how = How.XPATH, using = ".//a[@href='/dev/admin/addChallenge']")
    private WebElement addChallengeBtn;
    @FindBy(how = How.XPATH, using = ".//span[contains(@class, 'ant-input-group')]//*[@type='text']")
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = ".//span[@class='ant-input-group-addon']")
    private WebElement searchBtn;
    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-table-cell']//a)[1]")
    private WebElement challengeId;
    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-table-cell']//a)[2]")
    private WebElement challengeSortNumber;
    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-table-cell']//a)[3]")
    private WebElement challengeName;
    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-table-cell']//a)[4]")
    private WebElement challengeTitle;
    @FindBy(how = How.XPATH, using = ".//*[@title='Previous Page']")
    private WebElement previousPage;
    @FindBy(how = How.XPATH, using = ".//*[@title='Next Page']")
    private WebElement nextPage;
    @FindBy(how = How.XPATH, using = ".//*[@title='Next 5 Pages']")
    private WebElement stepOverNextFivePages;
    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'level-0 editable-row')]")
    private List<WebElement> challengeLocators;
    private List<ChallengeComponent> challengeComponents;

    public ChallengesPage(WebDriver driver) {
        super(driver);
        challengeComponents = fillComponentsWithChallenges();
    }

    public ChallengesPage openTasks() {
        tasksBtn.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage addChallenge() {
        addChallengeBtn.click();
        return new ChallengesPage(driver);
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

    private List<ChallengeComponent> fillComponentsWithChallenges() {
        List<ChallengeComponent> components = new ArrayList<>();
        for (WebElement element : challengeLocators) {
            components.add(new ChallengeComponent(driver, element));
        }
        return components;
    }

    public int countAllChallenges() {
        return challengeComponents.size();
    }

    public ChallengeComponent getChallengeByIndex(int index) {
        return challengeComponents.get(index);
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


