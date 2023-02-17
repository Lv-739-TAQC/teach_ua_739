package org.ssu.edu.teachua.ui.pages.challenges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditChallengePage extends AddChallengePage {
    @FindBy(how = How.XPATH, using = "//button[@id='isActive']")
    private WebElement editChallengeStatus;
    @FindBy(how = How.XPATH, using = "//*[@class='anticon anticon-eye']")
    private WebElement previewPhoto;
    @FindBy(how = How.XPATH, using = "//*[@class='anticon anticon-delete']")
    private WebElement deletePhoto;
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-btn ant-btn-default flooded-button'])[3]")
    private WebElement changeChallengeDate;
    @FindBy(how = How.XPATH, using = "//*[@class='back-btn'and @href='/dev/challenges/undefined']")
    private WebElement viewChallenge;

    public EditChallengePage(WebDriver driver) {
        super(driver);
    }

    public EditChallengePage clickEditChallengeStatus() {
        editChallengeStatus.click();
        return new EditChallengePage(driver);
    }

    public EditChallengePage clickPreviewPhoto() {
        previewPhoto.click();
        return new EditChallengePage(driver);
    }

    public EditChallengePage clickDeletePhoto() {
        deletePhoto.click();
        return new EditChallengePage(driver);
    }

    public EditChallengePage clickChangeChallengeDate() {
        changeChallengeDate.click();
        return new EditChallengePage(driver);
    }

    public EditChallengePage clickViewChallenge() {
        viewChallenge.click();
        return new EditChallengePage(driver);
    }

    @Override
    public AddChallengePage clickAndFillChallengeSortNumber(String textToSend) {
        getChallengeSortNumber().click();
        getChallengeSortNumber().clear();
        getChallengeSortNumber().sendKeys(textToSend);
        return new AddChallengePage(driver);
    }

    @Override
    public AddChallengePage clickAndFillChallengeName(String textToSend) {
        getChallengeName().click();
        getChallengeName().clear();
        getChallengeName().sendKeys(textToSend);
        return new AddChallengePage(driver);
    }

    @Override
    public AddChallengePage clickAndFillChallengeTitle(String textToSend) {
        getChallengeTitle().click();
        getChallengeTitle().clear();
        getChallengeTitle().sendKeys(textToSend);
        return new AddChallengePage(driver);
    }

    @Override
    public AddChallengePage clickAndFillChallengeDescription(String textToSend) {
        getChallengeDescription().click();
        getChallengeDescription().clear();
        getChallengeDescription().sendKeys(textToSend);
        return new AddChallengePage(driver);
    }

    @Override
    public AddChallengePage clickToChallengeUploadPhoto() {
        getChallengeUploadPhoto().click();
        return new AddChallengePage(driver);
    }

    @Override
    public AddChallengePage clickToChallengeSave() {
        getChallengeSave().click();
        return new AddChallengePage(driver);
    }

    @Override
    public AddChallengePage clickGoToTheListOfChallenges() {
        getGoToTheListOfChallenges().click();
        return new AddChallengePage(driver);
    }
}
