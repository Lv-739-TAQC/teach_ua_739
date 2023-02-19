package org.ssu.edu.teachua.ui.pages.challenges;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.File;

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
    public AddChallengePage clickAndFillChallengeSortNumber(String challengeSortNumber) {
        getChallengeSortNumber().click();
        getChallengeSortNumber().sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        getChallengeSortNumber().sendKeys(challengeSortNumber);
        return new AddChallengePage(driver);
    }

    @Override
    public AddChallengePage clickAndFillChallengeName(String challengeName) {
        getChallengeName().click();
        getChallengeName().sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        getChallengeName().sendKeys(challengeName);
        return new AddChallengePage(driver);
    }

    @Override
    public AddChallengePage clickAndFillChallengeTitle(String challengeTitle) {
        getChallengeTitle().click();
        getChallengeTitle().sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        getChallengeTitle().sendKeys(challengeTitle);
        return new AddChallengePage(driver);
    }

    @Override
    public AddChallengePage clickAndFillChallengeDescription(String challengeDescription) {
        getChallengeDescription().click();
        getChallengeDescription().sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        getChallengeDescription().sendKeys(challengeDescription);
        return new AddChallengePage(driver);
    }

    @Override
    public AddChallengePage clickToChallengeUploadPhoto() {
        getChallengeUploadPhoto().click();
        return new AddChallengePage(driver);
    }

    @Override
    public AddChallengePage clickAddPhoto(File image) {
        getChallengeUploadPhoto().sendKeys(image.getAbsolutePath());
        sleep(3000);
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

    @Override
    public String checkErrorMessage() {
        return getErrorMessage().getText();
    }
}
