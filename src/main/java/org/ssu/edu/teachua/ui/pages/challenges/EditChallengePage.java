package org.ssu.edu.teachua.ui.pages.challenges;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class EditChallengePage extends AddChallengePage {
    @FindBy(how = How.XPATH, using = ".//button[@id='isActive']")
    private WebElement changeStatus;
    @FindBy(how = How.XPATH, using = ".//*[@class='anticon anticon-eye']")
    private WebElement previewPhoto;
    @FindBy(how = How.XPATH, using = ".//*[@class='anticon anticon-delete']")
    private WebElement deletePhoto;
    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-btn ant-btn-default flooded-button'])[3]")
    private WebElement changeDateBtn;
    @FindBy(how = How.XPATH, using = "(.//*[@class='ant-btn ant-btn-default flooded-button'])[2]")
    private WebElement viewChallengeBtn;

    public EditChallengePage(WebDriver driver) {
        super(driver);
    }

    public EditChallengePage changeStatus() {
        changeStatus.click();
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

    public EditChallengePage clickChangeDate() {
        changeDateBtn.click();
        return new EditChallengePage(driver);
    }

    public EditChallengePage clickViewChallenge() {
        viewChallengeBtn.click();
        return new EditChallengePage(driver);
    }

    @Override
    public AddChallengePage fillSortNumber(String sortNumber) {
        getSortNumber().sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return super.fillSortNumber(sortNumber);
    }

    @Override
    public AddChallengePage fillName(String name) {
        getName().sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return super.fillName(name);
    }

    @Override
    public AddChallengePage fillTitle(String title) {
        getTitle().sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return super.fillTitle(title);
    }

    @Override
    public AddChallengePage fillDescription(String description) {
        getDescription().sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return super.fillDescription(description);
    }

}
