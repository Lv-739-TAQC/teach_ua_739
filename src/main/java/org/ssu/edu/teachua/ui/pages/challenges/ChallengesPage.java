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
    @FindBy(how = How.XPATH, using = ".//*[@class='back-btn']")
    private WebElement tasksBtn;
    @FindBy(how = How.XPATH, using = ".//a[@href='/dev/admin/addChallenge']")
    private WebElement addChallengeBtn;
    @FindBy(how = How.XPATH, using = ".//span[contains(@class, 'ant-input-group')]//*[@type='text']")
    private WebElement searchField;
    @FindBy(how = How.XPATH, using = ".//span[@class='ant-input-group-addon']")
    private WebElement searchBtn;
    @FindBy(how = How.XPATH, using = ".//*[contains(@class, 'level-0 editable-row')]")
    private List<WebElement> item;
    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-table-cell']//a)[1]")
    private WebElement id;
    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-table-cell']//a)[2]")
    private WebElement sortNumber;
    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-table-cell']//a)[3]")
    private WebElement name;
    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-table-cell']//a)[4]")
    private WebElement title;
    @FindBy(how = How.XPATH, using = ".//*[text()='Редагувати']")
    private WebElement editItem;
    @FindBy(how = How.XPATH, using = ".//input[@id='sortNumber']")
    private WebElement editNumber;
    @FindBy(how = How.XPATH, using = ".//input[@id='name']")
    private WebElement editName;
    @FindBy(how = How.XPATH, using = ".//input[@id='title']")
    private WebElement editTitle;
    @FindBy(how = How.XPATH, using = "(.//*[text()='Зберегти'])")
    private WebElement saveChanges;
    @FindBy(how = How.XPATH, using = "(.//*[text()='Відмінити'])")
    private WebElement cancelEditing;
    @FindBy(how = How.XPATH, using = ".//*[text()='Видалити']")
    private WebElement deleteItem;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'popConfirm-ok')]")
    private WebElement confirmDeleting;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'popConfirm-cancel')]")
    private WebElement cancelDeleting;
    @FindBy(how = How.XPATH, using = ".//*[@title='Previous Page']")
    private WebElement previousPage;
    @FindBy(how = How.XPATH, using = ".//*[@title='Next Page']")
    private WebElement nextPage;
    @FindBy(how = How.XPATH, using = ".//*[@title='Next 5 Pages']")
    private WebElement stepOverNextFivePages;
    private final List<ChallengeComponent> challengesComponents;

    public ChallengesPage(WebDriver driver) {
        super(driver);
        challengesComponents = initChallenges();
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

    public ChallengesPage editChallenge() {
        editItem.click();
        return this;
    }

    public ChallengesPage editChallengeSortNumber(String sortNumber) {
        editNumber.sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        editNumber.sendKeys(sortNumber);
        return this;
    }

    public ChallengesPage editChallengeName(String name) {
        editName.sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        editName.sendKeys(name);
        return this;
    }

    public ChallengesPage editChallengeTitle(String title) {
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

    public ChallengeComponent getSomeChallenge(int componentNumber) {
        return challengesComponents.get(componentNumber);
    }
}
