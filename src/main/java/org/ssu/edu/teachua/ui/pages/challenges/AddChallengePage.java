package org.ssu.edu.teachua.ui.pages.challenges;

import io.qameta.allure.Step;
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

    @Step("Type '{sortNumber}' into challenge sort number field")
    public AddChallengePage fillSortNumber(String sortNumber) {
        waitForElementToBeClickable(getSortNumber()).sendKeys(sortNumber);
        return this;
    }

    @Step("Clear challenge sort number field")
    public AddChallengePage clearSortNumber() {
        waitForElementToBeClickable(getSortNumber()).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    @Step("Type '{name}' into challenge name field")
    public AddChallengePage fillName(String name) {
        waitForElementToBeClickable(getName()).sendKeys(name);
        return this;
    }

    @Step("Clear challenge name field")
    public AddChallengePage clearName() {
        waitForElementToBeClickable(getName()).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    @Step("Type '{title}' into challenge title field")
    public AddChallengePage fillTitle(String title) {
        waitForElementToBeClickable(getTitle()).sendKeys(title);
        return this;
    }

    @Step("Clear challenge title field")
    public AddChallengePage clearTitle() {
        waitForElementToAppear(getTitle()).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    @Step("Type '{description}' into challenge description field")
    public AddChallengePage fillDescription(String description) {
        waitForElementToBeClickable(getDescription()).sendKeys(description);
        return this;
    }

    @Step("Clear challenge description field")
    public AddChallengePage clearDescription() {
        waitForElementToAppear(getTitle()).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    @Step("Upload photo")
    public AddChallengePage addPhoto(String imagePath) {
        photoInput.sendKeys(imagePath);
        waitForElementToAppear(getPhotoAppeared());
        return this;
    }

    @Step("View photo")
    public AddChallengePage clickPreviewPhoto() {
        waitForElementToBeClickable(getPhotoPreview()).click();
        return this;
    }

    @Step("Delete photo")
    public AddChallengePage clickDeletePhoto() {
        waitForElementToBeClickable(getDeletePhoto()).click();
        return this;
    }

    @Step("Save challenge")
    public AddChallengePage clickSave() {
        waitForElementToBeClickable(getSaveButton()).click();
        return this;
    }

    @Step("Open challenges page")
    public ChallengesPage goToChallenges() {
        waitForElementToBeClickable(getGoToChallengesBtn()).click();
        return new ChallengesPage(driver);
    }

    @Step("View created challenge")
    public ViewChallengePage clickViewChallenge() {
        waitForElementToBeClickable(getViewChallengeBtn()).click();
        sleep(1);
        return new ViewChallengePage(driver);
    }

    @Step("Get success message")
    public String checkSuccessMessage() {
        return waitForElementToAppear(successMessage).getText();
    }

    @Step("Wait for success message to disappear")
    public AddChallengePage waitForSuccessMessageToDisappear() {
        waitForElementToDisappear(successMessage);
        return this;
    }

    @Step("Get error message")
    public String checkErrorMessage() {
        return waitForElementToAppear(getErrorMessage()).getText();
    }

    @Step("Wait for error message to disappear")
    public AddChallengePage waitForErrorMessageToDisappear() {
        waitForElementToDisappear(errorMessage);
        return this;
    }

    @Step("Get border color for challenge name field")
    public String getBorderColorForNameField() {
        return name.getCssValue("border-color");
    }

    @Step("Get border color for challenge title field")
    public String getBorderColorForTitleField() {
        return title.getCssValue("border-color");
    }

    @Step("Get border color for challenge description field")
    public String getBorderColorForDescriptionField() {
        return description.getCssValue("border-color");
    }

    @Step("Check if field is empty")
    public boolean isEmptyString(String str) {
        return str == null || str.isEmpty();
    }

    @Step("Get challenge sort number")
    public String getValueSortNumber() {
        return sortNumber.getAttribute("value");
    }

    @Step("Get challenge name")
    public String getValueName() {
        return name.getAttribute("value");
    }

    @Step("Get challenge title")
    public String getValueTitle() {
        return title.getAttribute("value");
    }

    @Step("Get challenge description")
    public String getValueDescription() {
        return description.getAttribute("value");
    }

}
