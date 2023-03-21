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
     * click 'challenges' button and open ChallengesPage
     * @return opened ChallengesPage
     */
    @Step("Open challenges page")
    public ChallengesPage goToChallenges() {
        waitForElementToBeClickable(getGoToChallengesBtn()).click();
        return new ChallengesPage(driver);
    }

    /**
     * click 'view challenge' button and open ViewChallengePage
     * @return opened ViewChallengePage with created challenge
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
