package org.ssu.edu.teachua.ui.pages.view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BasePage;

public class ViewChallengePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@class='help-button']//button[contains(@class,'donate-button')]")
    private WebElement donateButton;
    @FindBy(how = How.XPATH, using = "//div[@class='social-info']//span[@aria-label='facebook']")
    private WebElement facebookURL;
    @FindBy(how = How.XPATH, using = "//div[@class='social-info']//span[@aria-label='youtube']")
    private WebElement youtubeURL;
    @FindBy(how = How.XPATH, using = "//div[@class='social-info']//span[@aria-label='instagram']")
    private WebElement instagramURL;
    @FindBy(how = How.XPATH, using = "//div[@class='challenge-day-block']//span[contains(@class,'arrows-prev')]")
    private WebElement previousTask;
    @FindBy(how = How.XPATH, using = "//div[@class='challenge-day-block']//span[contains(@class,'arrows-next')]")
    private WebElement nextTask;
    @FindBy(how = How.XPATH, using = "//div[@class='primitive-card']")
    private WebElement taskLink;


    public ViewChallengePage(WebDriver driver) {
        super(driver);
    }

    public void clickToDonate() {
        donateButton.click();
    }

    public void switchToFacebook() {
        facebookURL.click();
    }

    public void switchToYoutube() {
        youtubeURL.click();
    }

    public void switchToInstagram() {
        instagramURL.click();
    }

    public ViewChallengePage chooseNextTask() {
        nextTask.click();
        return this;
    }

    public ViewChallengePage choosePrevTask() {
        previousTask.click();
        return this;
    }

    public ViewTaskPage clickOnTask() {
        taskURL.click();
        return new ViewTaskPage(driver);
    }


}
