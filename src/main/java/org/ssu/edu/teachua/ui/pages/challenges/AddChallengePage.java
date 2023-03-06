package org.ssu.edu.teachua.ui.pages.challenges;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.pages.view.ViewChallengePage;

public class AddChallengePage extends BasePage {
    @FindBy(how = How.XPATH, using = "//input[@id='picture']")
    protected WebElement photoInput;
    @FindBy(how = How.XPATH, using = "//input[@id='sortNumber']")
    private WebElement sortNumber;
    @FindBy(how = How.XPATH, using = "//input[@id='name']")
    private WebElement name;
    @FindBy(how = How.XPATH, using = "//input[@id='title']")
    private WebElement title;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'ql-editor')]")
    private WebElement description;
    @FindBy(how = How.XPATH, using = "//span[@class='ant-upload'][@role='button']")
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
    @FindBy(how = How.XPATH, using = "//div[@class='ant-message-custom-content ant-message-success']")
    private WebElement successMessage;
    @FindBy(how = How.XPATH, using = "//*[@class='ant-message']")
    private WebElement errorMessage;

    public AddChallengePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSortNumber() {return sortNumber;}

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
        photoInput.sendKeys(imagePath);
        waitForElementToAppear(getPhotoAppeared());
        sleep(5);
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

    public String checkSuccessMessage() {
        return waitForElementToAppear(successMessage).getText();
    }

    public AddChallengePage waitForSuccessMessageToDisappear() {
        waitForElementToDisappear(successMessage);
        return this;
    }

    public String checkErrorMessage() {
        return waitForElementToAppear(getErrorMessage()).getText();
    }

    public AddChallengePage waitForErrorMessageToDisappear() {
        waitForElementToDisappear(errorMessage);
        return this;
    }

    public String getBorderColorForNameField() {
        return name.getCssValue("border-color");
    }

    public String getBorderColorForTitleField() {
        return title.getCssValue("border-color");
    }

    public String getBorderColorForDescriptionField() {
        return description.getCssValue("border-color");
    }


    public boolean isEmptyString(String str) {
        return str == null || str.isEmpty();
    }

    public String getValueSortNumber() {
        return sortNumber.getAttribute("value");
    }

    public String getValueName() {
        return name.getAttribute("value");
    }

    public String getValueTitle() {
        return title.getAttribute("value");
    }

    public String getValueDescription() {return description.getAttribute("value");}

}
