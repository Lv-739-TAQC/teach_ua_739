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

//    public ChallengesPage clickId() {
//        challengeId.click();
//        return new ChallengesPage(driver);
//    }
//
//    public ChallengesPage clickSortNumber() {
//        challengeSortNumber.click();
//        return new ChallengesPage(driver);
//    }
//
//    public ChallengesPage clickName() {
//        challengeName.click();
//        return new ChallengesPage(driver);
//    }
//
//    public ChallengesPage clickTitle() {
//        challengeTitle.click();
//        return new ChallengesPage(driver);
//    }

//    public ChallengesPage editChallenge() {
//        editBtn.click();
//        return this;
//    }
//
//    public ChallengesPage editChallengeSortNumber(String sortNumber) {
//        editSortNumber.sendKeys(
//                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
//        );
//        editSortNumber.sendKeys(sortNumber);
//        return this;
//    }
//
//    public ChallengesPage editChallengeName(String name) {
//        editName.sendKeys(
//                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
//        );
//        editName.sendKeys(name);
//        return this;
//    }
//
//    public ChallengesPage editChallengeTitle(String title) {
//        editTitle.sendKeys(
//                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
//        );
//        editTitle.sendKeys(title);
//        return this;
//    }
//
//    public ChallengesPage saveEditedItem() {
//        saveChangesBtn.click();
//        return this;
//    }
//
//    public ChallengesPage cancelEditingOfItem() {
//        cancelEditingBtn.click();
//        return this;
//    }
//
//    public ChallengesPage deleteItem() {
//        deleteBtn.click();
//        return this;
//    }
//
//    public ChallengesPage confirmDeletion() {
//        confirmDeletingBtn.click();
//        return this;
//    }
//
//    public ChallengesPage cancelDeletion() {
//        cancelDeletingBtn.click();
//        return this;
//    }

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
        List<ChallengeComponent> components = new ArrayList<>();
        for (WebElement element : challengeLocators) {
            components.add(new ChallengeComponent(driver, element));
        }
        return components;
    }

    public int countAllChallenges() {
        return challengeComponents.size();
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

    public ChallengeComponent getChallengeByIndex(int componentNumber) {
        return challengeComponents.get(componentNumber);
    }
}


