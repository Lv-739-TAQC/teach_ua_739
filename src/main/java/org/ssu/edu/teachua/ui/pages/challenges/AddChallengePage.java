package org.ssu.edu.teachua.ui.pages.challenges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;

public class AddChallengePage extends BasePage {
    @FindBy(how = How.XPATH, using = "//input[@id='sortNumber']")
    private WebElement challengeSortNumber;
    @FindBy(how = How.XPATH, using = "//input[@id='name']")
    private WebElement challengeName;
    @FindBy(how = How.XPATH, using = "//input[@id='title']")
    private WebElement challengeTitle;
    @FindBy(how = How.XPATH, using = "//*[@class='ql-container ql-snow']")
    private WebElement challengeDescription;
    @FindBy(how = How.XPATH, using = "//span[@class='upload-label']")
    private WebElement challengeUploadPhoto;
    @FindBy(how = How.XPATH, using = "//*[@type='submit' and contains(@class,'add-contact-type-button')]")
    private WebElement challengeSave;
    @FindBy(how = How.XPATH, using = "//*[@class='back-btn'and @href='/dev/admin/challenges']")
    private WebElement goToTheListOfChallenges;

    public AddChallengePage(WebDriver driver) { super(driver); }

    public WebElement getChallengeSortNumber() {
        return challengeSortNumber;
    }

    public WebElement getChallengeName() {
        return challengeName;
    }

    public WebElement getChallengeTitle() {
        return challengeTitle;
    }

    public WebElement getChallengeDescription() {
        return challengeDescription;
    }

    public WebElement getChallengeUploadPhoto() {
        return challengeUploadPhoto;
    }

    public WebElement getChallengeSave() {
        return challengeSave;
    }

    public WebElement getGoToTheListOfChallenges() {
        return goToTheListOfChallenges;
    }

    public AddChallengePage clickAndFillChallengeSortNumber(String textToSend) {
        getChallengeSortNumber().click();
        getChallengeSortNumber().sendKeys(textToSend);
        return new AddChallengePage(driver);
    }

    public AddChallengePage clickAndFillChallengeName(String textToSend) {
        getChallengeName().click();
        getChallengeName().sendKeys(textToSend);
        return new AddChallengePage(driver);
    }

    public AddChallengePage clickAndFillChallengeTitle(String textToSend) {
        getChallengeTitle().click();
        getChallengeTitle().sendKeys(textToSend);
        return new AddChallengePage(driver);
    }

    public AddChallengePage clickAndFillChallengeDescription(String textToSend) {
        getChallengeDescription().click();
        getChallengeDescription().sendKeys(textToSend);
        return new AddChallengePage(driver);
    }

    public AddChallengePage clickToChallengeUploadPhoto() {
        getChallengeUploadPhoto().click();
        return new AddChallengePage(driver);
    }

    public AddChallengePage clickToChallengeSave() {
        getChallengeSave().click();
        return new AddChallengePage(driver);
    }

    public AddChallengePage clickGoToTheListOfChallenges() {
        getGoToTheListOfChallenges().click();
        return new AddChallengePage(driver);
    }
}
