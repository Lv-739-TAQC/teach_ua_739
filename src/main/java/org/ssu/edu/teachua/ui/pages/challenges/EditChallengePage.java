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
    private WebElement changeChallengeDateButton;
    @FindBy(how = How.XPATH, using = "//*[@class='back-btn'and @href='/dev/challenges/undefined']")
    private WebElement viewChallengeButton;

    public EditChallengePage(WebDriver driver) {
        super(driver);
    }

    public EditChallengePage clickEditChallengeStatus() {
        editChallengeStatus.click();
        return this;
    }

    public EditChallengePage clickPreviewPhoto() {
        previewPhoto.click();
        return this;
    }

    public EditChallengePage clickDeletePhoto() {
        deletePhoto.click();
        return this;
    }

    public EditChallengePage clickChangeChallengeDateButton() {
        changeChallengeDateButton.click();
        return new EditChallengePage(driver);
    }

    public EditChallengePage clickViewChallenge() {
        viewChallengeButton.click();
        return new EditChallengePage(driver);
    }

    @Override
    public AddChallengePage clickToFillChallengeSortNumber(String sortNumber) {
        getChallengeSortNumber().sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return super.clickToFillChallengeSortNumber(sortNumber);
    }

    @Override
    public AddChallengePage clickToFillChallengeName(String name) {
        getChallengeName().sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return super.clickToFillChallengeName(name);
    }

    @Override
    public AddChallengePage clickToFillChallengeTitle(String title) {
        getChallengeTitle().sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return super.clickToFillChallengeTitle(title);
    }

    @Override
    public AddChallengePage clickToFillChallengeDescription(String description) {
        getChallengeDescription().sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return super.clickToFillChallengeDescription(description);
    }

}
