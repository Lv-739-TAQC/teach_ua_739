package org.ssu.edu.teachua.ui.pages.challenges;


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
    private WebElement tasksButton;
    @FindBy(how = How.XPATH, using = "//a[@href='/dev/admin/addChallenge']")
    private WebElement addChallengeButton;
    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'ant-input-group')]//*[@type='text']")
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = "//span[@class='ant-input-group-addon']")
    private WebElement searchButton;
    @FindBy(how = How.XPATH, using = "//*[@class='ant-table-row ant-table-row-level-0 editable-row']")
    private List<WebElement> item;
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
    private WebElement previousPage;
    @FindBy(how = How.XPATH, using = "//*[@title='Next Page']")
    private WebElement nextPage;
    @FindBy(how = How.XPATH, using = "//*[@title='Next 5 Pages']")
    private WebElement stepOverNextFivePages;
    private final List<ChallengeComponent> challengesComponents;

    public ChallengesPage(WebDriver driver) {
        super(driver);
        challengesComponents = initChallenges();
    }

    public ChallengesPage goToListOfTasks() {
        tasksButton.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickToAddChallengeButton() {
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

    public ChallengesPage clickId() {
        id.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickSortNumber() {
        sortNumber.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickName() {
        name.click();
        return new ChallengesPage(driver);
    }

    public ChallengesPage clickTitle() {
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

    public ChallengesPage saveEditedItem() {
        saveChanges.click();
        return this;
    }

    public ChallengesPage cancelEditingOfItem() {
        cancelEditing.click();
        return this;
    }

    public ChallengesPage deleteItem() {
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

    public ChallengesPage goToPreviousPage() {
        previousPage.click();
        return this;
    }

    public ChallengesPage goToNextPage() {
        nextPage.click();
        return this;
    }

    public ChallengesPage stepOverNextFivePages() {
        stepOverNextFivePages.click();
        return this;
    }

    private List<ChallengeComponent> initChallenges() {
        List<WebElement> elements = item;
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
