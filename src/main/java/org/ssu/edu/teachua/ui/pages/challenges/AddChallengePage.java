package org.ssu.edu.teachua.ui.pages.challenges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;

import java.io.File;

public class AddChallengePage extends BasePage {
    @FindBy(how = How.XPATH, using = "//input[@id='sortNumber']")
    private WebElement sortNumber;
    @FindBy(how = How.XPATH, using = "//input[@id='name']")
    private WebElement name;
    @FindBy(how = How.XPATH, using = "//input[@id='title']")
    private WebElement title;
    @FindBy(how = How.XPATH, using = "(//*[@class='quill ']//*[@class='ql-editor'])")
    private WebElement description;
    @FindBy(how = How.XPATH, using = "//span[@class='ant-upload'][@role='button']")
    private WebElement uploadPhoto;
    @FindBy(how = How.XPATH, using = "//*[@type='submit' and contains(@class,'add-contact-type-button')]")
    private WebElement saveButton;
    @FindBy(how = How.XPATH, using = "//*[@class='back-btn'and @href='/dev/admin/challenges']")
    private WebElement challengesButton;
    @FindBy(how = How.XPATH, using = "//*[@class='ant-message']")
    private WebElement errorMessage;

    public AddChallengePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSortNumber() {
        return sortNumber;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getUploadPhoto() {
        return uploadPhoto;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getGoToListOfChallengesButton() {
        return challengesButton;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public AddChallengePage fillSortNumber(String sortNumber) {
        getSortNumber().sendKeys(sortNumber);

        return this;
    }

    public AddChallengePage fillName(String name) {
        getName().sendKeys(name);
        return this;
    }

    public AddChallengePage fillTitle(String title) {
        getTitle().sendKeys(title);
        return this;
    }

    public AddChallengePage fillDescription(String description) {
        getDescription().sendKeys(description);
        return this;
    }


    public AddChallengePage addPhoto(File image) {
        getUploadPhoto().sendKeys(image.getAbsolutePath());
        return this;
    }

    public AddChallengePage clickToSaveButton() {
        getSaveButton().click();
        return new AddChallengePage(driver);
    }

    public AddChallengePage goToListOfChallengesButton() {
        getGoToListOfChallengesButton().click();
        return new AddChallengePage(driver);
    }

    public String checkErrorMessage() {
        return getErrorMessage().getText();
    }
}
