package org.ssu.edu.teachua.ui.pages.view;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;

import java.util.Set;

/**
 * Represents the View Challenge Page of the website.
 * This page contains elements related to a challenge, such as the title, description, and social media links.
 * It also provides functionality to navigate between tasks and view them.
 */
public class ViewChallengePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//span[@class='title']")
    private WebElement challengeTitle;
    @FindBy(how = How.XPATH, using = "//div[@class='challenge-description']/p")
    private WebElement challengeDescription;
    @FindBy(how = How.XPATH, using = "//div[@class='help-button']//button[contains(@class,'donate-button')]")
    private WebElement donateButton;
    @FindBy(how = How.XPATH, using = "//div[@class='social-info']//span[@aria-label='facebook']")
    private WebElement facebookLink;
    @FindBy(how = How.XPATH, using = "//div[@class='social-info']//span[@aria-label='youtube']")
    private WebElement youtubeLink;
    @FindBy(how = How.XPATH, using = "//div[@class='social-info']//span[@aria-label='instagram']")
    private WebElement instagramLink;
    @FindBy(how = How.XPATH, using = "//div[@class='challenge-day-block']//span[contains(@class,'arrows-prev')]")
    private WebElement previousTask;
    @FindBy(how = How.XPATH, using = "//div[@class='challenge-day-block']//span[contains(@class,'arrows-next')]")
    private WebElement nextTask;
    @FindBy(how = How.XPATH, using = "//div[@class='primitive-card']")
    private WebElement taskLink;

    /**
     * Constructor for ViewChallengePage class.
     *
     * @param driver the WebDriver object to use for interacting with the web page.
     */
    public ViewChallengePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks the Donate button on the page.
     */
    @Step("Click donate to support the project")
    public void clickToDonate() {
        donateButton.click();
    }

    /**
     * Clicks the Facebook link on the page.
     */
    @Step("Switch to Facebook page of challenge")
    public void switchToFacebook() {
        facebookLink.click();
    }

    /**
     * Clicks the YouTube link on the page.
     */
    @Step("Switch to Youtube channel of challenge")
    public void switchToYoutube() {
        youtubeLink.click();
    }

    /**
     * Clicks the Instagram link on the page.
     */
    @Step("Switch to Instagram page of challenge")
    public void switchToInstagram() {
        instagramLink.click();
    }

    /**
     * Clicks the Next Task button on the page.
     *
     * @return this ViewChallengePage object.
     */
    @Step("Click to get next task of challenge")
    public ViewChallengePage chooseNextTask() {
        nextTask.click();
        return this;
    }

    /**
     * Clicks the Previous Task button on the page.
     *
     * @return this ViewChallengePage object.
     */
    @Step("Click to get previous task of challenge")
    public ViewChallengePage choosePrevTask() {
        previousTask.click();
        return this;
    }

    /**
     * Clicks the Task Link on the page and returns a new ViewTaskPage object.
     *
     * @return a new ViewTaskPage object.
     */
    @Step("Click to redirect on task view page")
    public ViewTaskPage clickOnTask() {
        taskLink.click();
        return new ViewTaskPage(driver);
    }

    /**
     * Gets the challenge title text.
     *
     * @return a String containing the challenge title.
     */
    @Step("Get challenge title")
    public String getChallengeTitle() {
        return challengeTitle.getText();
    }

    /**
     * Gets the challenge description text from the page.
     *
     * @return A String representing the challenge description.
     */
    @Step("Get challenge description")
    public String getChallengeDescription() {
        return challengeDescription.getText();
    }

    /**
     * Gets the total number of currently open window tabs.
     *
     * @return An integer representing the number of open window tabs.
     */
    @Step("Get total amount of window tabs")
    public int getWindowCount() {
        Set<String> windowHandles = driver.getWindowHandles();
        return windowHandles.size();
    }

    /**
     * Retrieves the URL of the currently active window tab.
     *
     * @return A String representing the URL of the currently active window tab.
     */
    @Step("Get URL of current window tab")
    public String getCurrentTabHandle() {
        return driver.getCurrentUrl();
    }

    /**
     * Retrieves the URL of a newly opened window tab.
     *
     * @return A String representing the URL of the newly opened window tab.
     */
    @Step("Get URL of newly opened window tab")
    public String getNewlyOpenedTabHandle() {
        String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
        }
        String newTabUrl = driver.getCurrentUrl();
        driver.switchTo().window(currentHandle);
        return newTabUrl;
    }


}
