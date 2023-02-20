package org.ssu.edu.teachua.ui.pages.challenges;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    private WebElement goToTheListOfTasksButton;
    @FindBy(how = How.XPATH, using = "//a[@href='/dev/admin/addChallenge']")
    private WebElement addChallengeButton;
    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'ant-input-group')]//*[@type='text']")
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = "//span[@class='ant-input-group-addon']")
    private WebElement searchButton;
    @FindBy(how = How.XPATH, using = "//*[@class='ant-table-row ant-table-row-level-0 editable-row']")
    private List<WebElement> challengeItem;
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-table-cell']//a)[1]")
    private WebElement id;
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-table-cell']//a)[2]")
    private WebElement sortNumber;
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-table-cell']//a)[3]")
    private WebElement name;
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-table-cell']//a)[4]")
    private WebElement title;
    @FindBy(how = How.XPATH, using = "//*[text()='Редагувати']") //"(//*[text()='Редагувати'])[1]"
    private WebElement editItem;
    @FindBy(how = How.XPATH, using = "//input[@id='sortNumber']")
    private WebElement editNumber;
    @FindBy(how = How.XPATH, using = "//input[@id='name']")
    private WebElement editName;
    @FindBy(how = How.XPATH, using = "//input[@id='title']")
    private WebElement editTitle;
    @FindBy(how = How.XPATH, using = "(//*[text()='Зберегти'])")
    private WebElement saveChanges;
    @FindBy(how = How.XPATH, using = "(//*[text()='Відмінити'])")
    private WebElement cancelEditing;
    @FindBy(how = How.XPATH, using = "//*[text()='Видалити']") //"(//*[text()='Видалити'])[1]"
    private WebElement deleteItem;
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'popConfirm-ok')]")
    private WebElement confirmDeleting;
    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'popConfirm-cancel')]")
    private WebElement cancelDeleting;
    @FindBy(how = How.XPATH, using = "//*[@title='Previous Page']")
    private WebElement goToPreviousPage;
    @FindBy(how = How.XPATH, using = "//*[@title='Next Page']")
    private WebElement goToNextPage;
    @FindBy(how = How.XPATH, using = "//*[@title='Next 5 Pages']")
    private WebElement stepOverNextFivePages;
    private final List<ChallengeComponent> challengesComponents;

    public ChallengesPage(WebDriver driver) {
        super(driver);
        challengesComponents = initChallenges();
    }

    public ChallengesPage goToTheListOfTasks() {
        goToTheListOfTasksButton.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickToAddChallengePage() {
        addChallengeButton.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage fillSearchField(String textToSearch) {
        searchField.sendKeys(textToSearch);
        return this;
    }

    public ChallengesPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    public ChallengesPage clickChallengeId() {
        id.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickChallengeSortNumber() {
        sortNumber.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickChallengeName() {
        name.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickChallengeTitle() {
        title.click();
        return new ChallengesPage(driver);
    }
    public String readId() {
        return id.getText();
    }

    public String readSortNumber() {
        return sortNumber.getText();
    }

    public String readName() {
        return name.getText();
    }

    public String readTitle() {
        return title.getText();
    }
    public ChallengesPage editChallenge() {
        editItem.click();
        return this;
    }
    public ChallengesPage editSortNumber(String sortNumber) {
        editNumber.sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        editNumber.sendKeys(sortNumber);
        return this;
    }

    public ChallengesPage editName(String name) {
        editName.sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        editName.sendKeys(name);
        return this;
    }

    public ChallengesPage editTitle(String title) {
        editTitle.sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        editTitle.sendKeys(title);
        return this;
    }
    public ChallengesPage saveEditedChallenge() {
        saveChanges.click();
        return this;
    }

    public ChallengesPage cancelEditingOfChallenge() {
        cancelEditing.click();
        return this;
    }
    public ChallengesPage deleteChallenge() {
        deleteItem.click();
        return this;
    }

    public ChallengesPage confirmDeletion() {
        confirmDeleting.click();
        return this;
    }

    public ChallengesPage cancelDeletion() {
        cancelDeleting.click();
        return this;
    }

    public ChallengesPage clickGoToPreviousPage() {
        goToPreviousPage.click();
        return this;
    }

    public ChallengesPage clickGoToNextPage() {
        goToNextPage.click();
        return this;
    }

    public ChallengesPage clickStepOverNextFivePages() {
        stepOverNextFivePages.click();
        return this;
    }

    private List<ChallengeComponent> initChallenges() {
        List<WebElement> elements = challengeItem;
        List<ChallengeComponent> challenges = new ArrayList<>();
        for (WebElement element : elements) {
            challenges.add(new ChallengeComponent(driver, element));
        }
        return challenges;
    }
    public int countChallengeItems() {
        return challengesComponents.size();
    }
    public ChallengeComponent moveGoSomeChallenge(int challengeComponentNumber) {
        return challengesComponents.get(challengeComponentNumber);
    }
}
