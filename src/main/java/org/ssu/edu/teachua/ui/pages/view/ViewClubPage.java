package org.ssu.edu.teachua.ui.pages.view;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.FeedbackComponent;
import org.ssu.edu.teachua.ui.components.modal.EnrollClubComponent;
import org.ssu.edu.teachua.ui.components.modal.FeedbackComponent;

public class ViewClubPage extends ViewCenterPage {

    @FindBy(how = How.XPATH, using = "//span[@class='club-name']")
    private WebElement clubName;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'modal SignUpForClub')]")
    private WebElement enrollClubNode;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'comment-modal')]")
    private WebElement leaveFeedbackNode;
    @FindBy(how = How.XPATH, using = "//div[@id='carousel']/span[@aria-label='left']")
    private WebElement previousImage;
    @FindBy(how = How.XPATH, using = "//div[@id='carousel']/span[@aria-label='right']")
    private WebElement nextImage;
    @FindBy(how = How.XPATH, using = "//span[@class='contact-name']/a[@href]")
    private WebElement clubURL;
    @FindBy(how = How.XPATH, using = "//button[@type='button' and contains(@class,'comment-button')]")
    private WebElement feedbackButton;
    @FindBy(how = How.XPATH, using = "//div[@class='similar-clubs']//div[@class='details']")
    private WebElement moreDetailsButton;
    @FindBy(how = How.XPATH, using = "//span[@class='feedback']")
    private WebElement showFeedback;
    @FindBy(how = How.XPATH, using =
            "//div[@class='apply-box']//button[contains(@class, 'apply-button')]"
    )
    private WebElement subscribeButton;

    public ViewClubPage(WebDriver driver) {
        super(driver);
    }

    public EnrollClubComponent clickEnrollClub() {
        enrollButton.click();
        return new EnrollClubComponent(driver, enrollClubNode);
    }

    public ViewClubPage clickOnNextImage() {
        nextImage.click();
        return this;
    }

    public ViewClubPage clickOnPreviousImage() {
        previousImage.click();
        return this;
    }
    public ViewClubPage downloadFile() {
        downloadButton.click();
        return this;
    }

    public FeedbackComponent clickLeaveAFeedback() {
        feedbackButton.click();
        return new FeedbackComponent(driver, leaveFeedbackNode);
    }

    public void clickOnClubURL() {
        clubURL.click();
    }

    public ViewClubPage clickOnMoreDetails() {
        moreDetailsButton.click();
        return this;
    }

    public ViewClubPage clickOnShowFeedback() {
        showFeedback.click();
        return this;
    }

    public boolean isSubscribeButtonEnabled() {
        return waitForElementToAppear(subscribeButton).isEnabled();
    }

    public String getClubName() {
        return clubName.getText();
    }

}
