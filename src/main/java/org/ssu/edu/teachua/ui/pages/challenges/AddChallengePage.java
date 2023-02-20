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
    @FindBy(how = How.XPATH, using = "//*[@class='ql-container ql-snow']")
    private WebElement description;
    @FindBy(how = How.XPATH, using = "//span[@class='upload-label']")
    private WebElement uploadPhoto;
    @FindBy(how = How.XPATH, using = "//*[@type='submit' and contains(@class,'add-contact-type-button')]")
    private WebElement saveButton;
    @FindBy(how = How.XPATH, using = "//*[@class='back-btn'and @href='/dev/admin/challenges']")
    private WebElement goToTheListOfChallengesButton;
    @FindBy(how = How.XPATH, using = "//*[@class='ant-message']")
    private WebElement errorMessage;

    public AddChallengePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getChallengeSortNumber() {
        return sortNumber;
    }

    public WebElement getChallengeName() { return name; }

    public WebElement getChallengeTitle() {
        return title;
    }

    public WebElement getChallengeDescription() {
        return description;
    }

    public WebElement getChallengeUploadPhoto() {
        return uploadPhoto;
    }

    public WebElement getChallengeSaveButton() {
        return saveButton;
    }

    public WebElement getGoToTheListOfChallengesButton() {
        return goToTheListOfChallengesButton;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public AddChallengePage clickToFillChallengeSortNumber(String sortNumber) {
        getChallengeSortNumber().sendKeys(sortNumber);
        return this;
    }

    public AddChallengePage clickToFillChallengeName(String name) {
        getChallengeName().sendKeys(name);
        return this;
    }

    public AddChallengePage clickToFillChallengeTitle(String title) {
        getChallengeTitle().sendKeys(title);
        return this;
    }

    public AddChallengePage clickToFillChallengeDescription(String description) {
        getChallengeDescription().sendKeys(description);
        return this;
    }


    public AddChallengePage clickAddPhoto(File image) {
        getChallengeUploadPhoto().sendKeys(image.getAbsolutePath());
        return this;
    }

    public AddChallengePage clickToChallengeSaveButton() {
        getChallengeSaveButton().click();
        return new AddChallengePage(driver);
    }

    public AddChallengePage clickGoToTheListOfChallengesButton() {
        getGoToTheListOfChallengesButton().click();
        return new AddChallengePage(driver);
    }

    public String checkErrorMessage() {
        return getErrorMessage().getText();
    }
}
