package org.ssu.edu.teachua.ui.pages.view;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;

import java.util.Set;

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

    public ViewChallengePage(WebDriver driver) {
        super(driver);
    }


    @Step("Click donate to support the project")
    public void clickToDonate() {
        donateButton.click();
    }

    @Step("Switch to Facebook page of challenge")
    public void switchToFacebook() {
        facebookLink.click();
    }

    @Step("Switch to Youtube channel of challenge")
    public void switchToYoutube() {
        youtubeLink.click();
    }

    @Step("Switch to Instagram page of challenge")
    public void switchToInstagram() {
        instagramLink.click();
    }

    @Step("Click to get next task of challenge")
    public ViewChallengePage chooseNextTask() {
        nextTask.click();
        return this;
    }

    @Step("Click to get previous task of challenge")
    public ViewChallengePage choosePrevTask() {
        previousTask.click();
        return this;
    }

    @Step("Click to redirect on task view page")
    public ViewTaskPage clickOnTask() {
        taskLink.click();
        return new ViewTaskPage(driver);
    }

    @Step("Get challenge title")
    public String getChallengeTitle() {
        return challengeTitle.getText();
    }

    @Step("Get challenge description")
    public String getChallengeDescription() {
        return challengeDescription.getText();
    }

    @Step("Get total amount of window tabs")
    public int getWindowCount() {
        Set<String> windowHandles = driver.getWindowHandles();
        return windowHandles.size();
    }

    @Step("Get URL of current window tab")
    public String getCurrentTabHandle() {
        return driver.getCurrentUrl();
    }

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
