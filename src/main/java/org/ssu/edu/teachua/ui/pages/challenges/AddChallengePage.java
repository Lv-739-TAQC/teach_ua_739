package org.ssu.edu.teachua.ui.pages.challenges;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;
import org.ssu.edu.teachua.ui.pages.view.ViewChallengePage;

/**
 * class contains elements and methods which represents
 * the functionality to create a challenge
 */
public class AddChallengePage extends BasePage {

    /**
     * WebElement represents 'input picture' button
     */
    @FindBy(how = How.XPATH, using = "//input[@id='picture']")
    protected WebElement photoInput;
    /**
     * WebElement represents 'sort number' field of challenge
     */
    @FindBy(how = How.XPATH, using = "//input[@id='sortNumber']")
    private WebElement sortNumber;
    /**
     * WebElement represents 'name' field of challenge
     */
    @FindBy(how = How.XPATH, using = "//input[@id='name']")
    private WebElement name;
    /**
     * WebElement represents 'title' field of challenge
     */
    @FindBy(how = How.XPATH, using = "//input[@id='title']")
    private WebElement title;
    /**
     * WebElement represents 'description' field of challenge
     */
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'ql-editor')]")
    private WebElement description;
    /**
     * WebElement represents verification if uploaded photo appeared
     */
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'ant-upload-list-item-done')]")
    private WebElement photoAppeared;
    /**
     * WebElement represents 'preview photo' button
     */
    @FindBy(how = How.XPATH, using = "//*[@class='anticon anticon-eye']")
    private WebElement previewPhoto;
    /**
     * WebElement represents 'delete photo' button
     */
    @FindBy(how = How.XPATH, using = "//*[@class='anticon anticon-delete']")
    private WebElement deletePhoto;
    /**
     * WebElement represents 'save' button
     */
    @FindBy(how = How.XPATH, using = "//*[@type='submit' and contains(@class,'add-contact-type-button')]")
    private WebElement saveBtn;
    /**
     * WebElement represents 'challenges' button which opens {@link ChallengesPage}
     */
    @FindBy(how = How.XPATH, using = "//*[@class='back-btn'and @href='/dev/admin/challenges']")
    private WebElement challengesBtn;
    /**
     * WebElement represents 'challenges' button which opens {@link ViewChallengePage}
     */
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-btn ant-btn-default flooded-button'])[2]")
    private WebElement viewChallengeBtn;
    /**
     * WebElement represents the text of success message after creating a challenge with valid data
     */
    @FindBy(how = How.XPATH, using = "//div[@class='ant-message-custom-content ant-message-success']")
    private WebElement successMessage;
    /**
     * WebElement represents the text of error message after creating a challenge with invalid data
     */
    @FindBy(how = How.XPATH, using = "//*[@class='ant-message']")
    private WebElement errorMessage;

    /**
     * creation constructor matching super with one parameter
     */
    public AddChallengePage(WebDriver driver) {
        super(driver);
    }

    /**
     * @return WebElement sortNumber
     */
    public WebElement getSortNumber() {
        return sortNumber;
    }

    /**
     * @return WebElement name
     */
    public WebElement getName() {
        return name;
    }

    /**
     * @return WebElement title
     */
    public WebElement getTitle() {
        return title;
    }

    /**
     * @return WebElement description
     */
    public WebElement getDescription() {
        return description;
    }

    /**
     * @return WebElement photoAppeared
     */
    public WebElement getPhotoAppeared() {
        return photoAppeared;
    }

    /**
     * @return WebElement previewPhoto
     */
    public WebElement getPhotoPreview() {
        return previewPhoto;
    }

    /**
     * @return WebElement deletePhoto
     */
    public WebElement getDeletePhoto() {
        return deletePhoto;
    }

    /**
     * @return WebElement saveBtn
     */
    public WebElement getSaveButton() {
        return saveBtn;
    }

    /**
     * @return WebElement challengesBtn
     */
    public WebElement getGoToChallengesBtn() {
        return challengesBtn;
    }

    /**
     * @return WebElement viewChallengeBtn
     */
    public WebElement getViewChallengeBtn() {
        return viewChallengeBtn;
    }

    /**
     * @return WebElement errorMessage
     */
    public WebElement getErrorMessage() {
        return errorMessage;
    }

    /**
     * type sort number for challenge
     * @param sortNumber - sort number of challenge
     * @return AddChallengePage with typed sort number
     */
    @Step("Type '{sortNumber}' into challenge sort number field")
    public AddChallengePage fillSortNumber(String sortNumber) {
        waitForElementToBeClickable(getSortNumber()).sendKeys(sortNumber);
        return this;
    }

    /**
     * clear sort number of challenge
     * @return AddChallengePage with removed sort number
     */
    @Step("Clear challenge sort number field")
    public AddChallengePage clearSortNumber() {
        waitForElementToBeClickable(getSortNumber()).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    /**
     * type name for challenge
     * @param name - name of challenge
     * @return AddChallengePage with typed name
     */
    @Step("Type '{name}' into challenge name field")
    public AddChallengePage fillName(String name) {
        waitForElementToBeClickable(getName()).sendKeys(name);
        return this;
    }

    /**
     * clear name of challenge
     * @return AddChallengePage with removed name
     */
    @Step("Clear challenge name field")
    public AddChallengePage clearName() {
        waitForElementToBeClickable(getName()).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    /**
     * type name title challenge
     * @param title - title of challenge
     * @return AddChallengePage with typed title
     */
    @Step("Type '{title}' into challenge title field")
    public AddChallengePage fillTitle(String title) {
        waitForElementToBeClickable(getTitle()).sendKeys(title);
        return this;
    }

    /**
     * clear title of challenge
     * @return AddChallengePage with removed title
     */
    @Step("Clear challenge title field")
    public AddChallengePage clearTitle() {
        waitForElementToAppear(getTitle()).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    /**
     * type description title challenge
     * @param description - description of challenge
     * @return AddChallengePage with typed description
     */
    @Step("Type '{description}' into challenge description field")
    public AddChallengePage fillDescription(String description) {
        waitForElementToBeClickable(getDescription()).sendKeys(description);
        return this;
    }

    /**
     * clear description of challenge
     * @return AddChallengePage with removed description
     */
    @Step("Clear challenge description field")
    public AddChallengePage clearDescription() {
        waitForElementToAppear(getTitle()).sendKeys(
                Keys.chord(Keys.CONTROL, "a", Keys.DELETE)
        );
        return this;
    }

    /**
     * upload photo for challenge and check if photo appeared
     * @param imagePath -image path from local PC
     * @return AddChallengePage with uploaded photo
     */
    @Step("Upload photo from '{imagePath}'")
    public AddChallengePage addPhoto(String imagePath) {
        photoInput.sendKeys(imagePath);
        waitForElementToAppear(getPhotoAppeared());
        return this;
    }

    /**
     * click 'preview' icon
     * @return AddChallengePage with the viewed photo
     */
    @Step("View photo")
    public AddChallengePage clickPreviewPhoto() {
        waitForElementToBeClickable(getPhotoPreview()).click();
        return this;
    }

    /**
     * click 'delete' icon
     * @return AddChallengePage with deleted photo
     */
    @Step("Delete photo")
    public AddChallengePage clickDeletePhoto() {
        waitForElementToBeClickable(getDeletePhoto()).click();
        return this;
    }

    /**
     * click 'save' button
     * @return AddChallengePage with appropriate success or error message of challenge creation
     */
    @Step("Save challenge")
    public AddChallengePage clickSave() {
        waitForElementToBeClickable(getSaveButton()).click();
        return this;
    }

    /**
     * click 'challenges' button and open {@link ChallengesPage}
     * @return opened {@link ChallengesPage}
     */
    @Step("Open challenges page")
    public ChallengesPage goToChallenges() {
        waitForElementToBeClickable(getGoToChallengesBtn()).click();
        return new ChallengesPage(driver);
    }

    /**
     * click 'view challenge' button and open {@link ViewChallengePage}
     * @return opened {@link ViewChallengePage} with created challenge
     */
    @Step("View created challenge")
    public ViewChallengePage clickViewChallenge() {
        waitForElementToBeClickable(getViewChallengeBtn()).click();
        return new ViewChallengePage(driver);
    }

    /**
     * show success message of created challenge
     * @return text of success message
     */
    @Step("Get success message")
    public String checkSuccessMessage() {
        return waitForElementToAppear(successMessage).getText();
    }

    /**
     * wait until success message disappeared
     * @return AddChallengePage without success message
     */
    @Step("Wait for success message to disappear")
    public AddChallengePage waitForSuccessMessageToDisappear() {
        waitForElementToDisappear(successMessage);
        return this;
    }

    /**
     * show error message after trying to create a challenge with invalid data
     * @return text of error message
     */
    @Step("Get error message")
    public String checkErrorMessage() {
        return waitForElementToAppear(getErrorMessage()).getText();
    }

    /**
     * wait until error message disappeared
     * @return AddChallengePage without error message
     */
    @Step("Wait for error message to disappear")
    public AddChallengePage waitForErrorMessageToDisappear() {
        waitForElementToDisappear(errorMessage);
        return this;
    }

    /**
     * show border color for challenge name field
     * @return border color for name field
     */
    @Step("Get border color for challenge name field")
    public String getBorderColorForNameField() {
        return name.getCssValue("border-color");
    }

    /**
     * show border color for challenge title field
     * @return border color for title field
     */
    @Step("Get border color for challenge title field")
    public String getBorderColorForTitleField() {
        return title.getCssValue("border-color");
    }

    /**
     * show border color for challenge description field
     * @return border color for description field
     */
    @Step("Get border color for challenge description field")
    public String getBorderColorForDescriptionField() {
        return description.getCssValue("border-color");
    }

    /**
     * check field for the presence of entered data
     * @param str = field to check
     * @return true if field is empty; false in other case
     */
    @Step("Check if field is empty")
    public boolean isEmptyString(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * show sort number of challenge
     * @return text of sort number
     */
    @Step("Get challenge sort number")
    public String getValueSortNumber() {
        return sortNumber.getAttribute("value");
    }

    /**
     * show name of challenge
     * @return text of name
     */
    @Step("Get challenge name")
    public String getValueName() {
        return name.getAttribute("value");
    }

    /**
     * show title of challenge
     * @return text of title
     */
    @Step("Get challenge title")
    public String getValueTitle() {
        return title.getAttribute("value");
    }

    /**
     * show description of challenge
     * @return text of description
     */
    @Step("Get challenge description")
    public String getValueDescription() {
        return description.getAttribute("value");
    }

}
