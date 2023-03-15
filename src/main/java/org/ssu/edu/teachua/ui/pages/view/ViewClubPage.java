package org.ssu.edu.teachua.ui.pages.view;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.FeedbackComponent;
import org.ssu.edu.teachua.ui.components.modal.EnrollClubComponent;

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
    private WebElement clubLink;
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


   @Step("Click to enroll the club")
   public EnrollClubComponent clickEnrollClub() {
        enrollButton.click();
        return new EnrollClubComponent(driver, enrollClubNode);
    }

    @Step("Click to get next club image")
    public ViewClubPage clickOnNextImage() {
        nextImage.click();
        return this;
    }

    @Step("Click to get previous club image")
    public ViewClubPage clickOnPreviousImage() {
        previousImage.click();
        return this;
    }
    @Step("Click to download a file with information about the club")
    public ViewClubPage downloadFile() {
        downloadButton.click();
        return this;
    }

    @Step("Click to leave a feedback about the club")
    public FeedbackComponent clickLeaveAFeedback() {
        feedbackButton.click();
        return new FeedbackComponent(driver, leaveFeedbackNode);
    }

    @Step("Click to redirect on club webpage")
    public void clickOnClubLink() {
        clubLink.click();
    }

    @Step("Click to get more details about the club")
    public ViewClubPage clickOnMoreDetails() {
        moreDetailsButton.click();
        return this;
    }

    @Step("Click to show all feedback")
    public ViewClubPage clickOnShowFeedback() {
        showFeedback.click();
        return this;
    }

    public boolean isSubscribeButtonEnabled() {
        return waitForElementToAppear(subscribeButton).isEnabled();
    }

    @Step("Get club name")
    public String getClubName() {
        return clubName.getText();
    }

}
