package org.ssu.edu.teachua.ui.pages.challenges;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.pages.view.ViewChallengePage;

public class AddChallengePage extends BasePage {
    @FindBy(how = How.XPATH, using = "//input[@id='sortNumber']")
    private WebElement sortNumber;
    @FindBy(how = How.XPATH, using = "//input[@id='name']")
    private WebElement name;
    @FindBy(how = How.XPATH, using = "//input[@id='title']")
    private WebElement title;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'ql-editor')]")
    private WebElement description;
    @FindBy(how = How.XPATH, using = "//input[@id='picture']")
    private WebElement uploadPhoto;
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'ant-upload-list-item-done')]")
    private WebElement photoAppeared;
    @FindBy(how = How.XPATH, using = "//*[@class='anticon anticon-eye']")
    private WebElement previewPhoto;
    @FindBy(how = How.XPATH, using = "//*[@class='anticon anticon-delete']")
    private WebElement deletePhoto;
    @FindBy(how = How.XPATH, using = "//*[@type='submit' and contains(@class,'add-contact-type-button')]")
    private WebElement saveBtn;
    @FindBy(how = How.XPATH, using = "//*[@class='back-btn'and @href='/dev/admin/challenges']")
    private WebElement challengesBtn;
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-btn ant-btn-default flooded-button'])[2]")
    private WebElement viewChallengeBtn;
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

    public WebElement getPhotoAppeared() {
        return photoAppeared;
    }

    public WebElement getPhotoPreview() {
        return previewPhoto;
    }

    public WebElement getDeletePhoto() {
        return deletePhoto;
    }

    public WebElement getSaveButton() {
        return saveBtn;
    }

    public WebElement getGoToChallengesBtn() {
        return challengesBtn;
    }

    public WebElement getViewChallengeBtn() {
        return viewChallengeBtn;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public AddChallengePage fillSortNumber(String sortNumber) {
        waitForElementToBeClickable(getSortNumber()).sendKeys(sortNumber);
        return this;
    }

    public AddChallengePage clearSortNumber() {
        waitForElementToBeClickable(getSortNumber()).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    public AddChallengePage fillName(String name) {
        waitForElementToBeClickable(getName()).sendKeys(name);
        return this;
    }

    public AddChallengePage clearName() {
        waitForElementToBeClickable(getName()).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    public AddChallengePage fillTitle(String title) {
        waitForElementToBeClickable(getTitle()).sendKeys(title);
        return this;
    }

    public AddChallengePage clearTitle() {
        waitForElementToAppear(getTitle()).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    public AddChallengePage fillDescription(String description) {
        waitForElementToBeClickable(getDescription()).sendKeys(description);
        return this;
    }

    public AddChallengePage clearDescription() {
        waitForElementToAppear(getTitle()).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }


    public AddChallengePage addPhoto(String imagePath) {
        getUploadPhoto().sendKeys(imagePath);
        waitForElementToAppear(getPhotoAppeared());
        return this;
    }

    public AddChallengePage clickPreviewPhoto() {
        waitForElementToBeClickable(getPhotoPreview()).click();
        return this;
    }

    public AddChallengePage clickDeletePhoto() {
        waitForElementToBeClickable(getDeletePhoto()).click();
        return this;
    }

    public AddChallengePage clickSave() {
        waitForElementToBeClickable(getSaveButton()).click();
        return this;
    }

    public ChallengesPage goToChallenges() {
        waitForElementToBeClickable(getGoToChallengesBtn()).click();
        return new ChallengesPage(driver);
    }

    public ViewChallengePage clickViewChallenge() {
        waitForElementToBeClickable(getViewChallengeBtn()).click();
        return new ViewChallengePage(driver);
    }

    public String checkErrorMessage() {
        return waitForElementToAppear(getErrorMessage()).getText();
    }
    public AddChallengePage waitForErrorMessageToDisappear() {
        waitForElementToDisappear(errorMessage);
        return this;
    }
    public String getBorderColorForNameField() {
        String borderColor= name.getCssValue("border-color");
        return borderColor;
    }
    public String getBorderColorForTitleField() {
        String borderColor= title.getCssValue("border-color");
        return borderColor;
    }
    public String getBorderColorForDescriptionField() {
        String borderColor= description.getCssValue("border-color");
        return borderColor;
    }
}
