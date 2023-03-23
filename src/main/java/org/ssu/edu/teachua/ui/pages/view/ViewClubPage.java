package org.ssu.edu.teachua.ui.pages.view;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.FeedbackComponent;
import org.ssu.edu.teachua.ui.components.modal.EnrollClubComponent;

/**
 * This class represents the page that displays information about a particular club.
 * It extends the ViewCenterPage class.
 * The class contains WebElements and methods for interacting with the elements on the page.
 */
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

    /**
     * Constructs a new ViewClubPage object with the given WebDriver.
     *
     * @param driver the WebDriver instance to use
     */
    public ViewClubPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks the enroll club button and returns a new instance of the EnrollClubComponent class.
     *
     * @return The EnrollClubComponent instance.
     */
    @Step("Click to enroll the club")
    public EnrollClubComponent clickEnrollClub() {
        enrollButton.click();
        return new EnrollClubComponent(driver, enrollClubNode);
    }

    /**
     * Clicks the next club image button and returns the current instance of the ViewClubPage class.
     *
     * @return The current instance of the ViewClubPage class.
     */
    @Step("Click to get next club image")
    public ViewClubPage clickOnNextImage() {
        nextImage.click();
        return this;
    }

    /**
     * Clicks the previous club image button and returns the current instance of the ViewClubPage class.
     *
     * @return The current instance of the ViewClubPage class.
     */
    @Step("Click to get previous club image")
    public ViewClubPage clickOnPreviousImage() {
        previousImage.click();
        return this;
    }

    /**
     * Clicks the download file button and returns the current instance of the ViewClubPage class.
     *
     * @return The current instance of the ViewClubPage class.
     */
    @Step("Click to download a file with information about the club")
    public ViewClubPage downloadFile() {
        downloadButton.click();
        return this;
    }

    /**
     * Clicks the leave feedback button and returns a new instance of the FeedbackComponent class.
     *
     * @return The FeedbackComponent instance.
     */
    @Step("Click to leave a feedback about the club")
    public FeedbackComponent clickLeaveAFeedback() {
        feedbackButton.click();
        return new FeedbackComponent(driver, leaveFeedbackNode);
    }

    /**
     * Clicks on the link to redirect to the club's webpage.
     */
    @Step("Click to redirect on club webpage")
    public void clickOnClubLink() {
        clubLink.click();
    }

    /**
     * Clicks on the button to get more details about the club.
     *
     * @return The ViewClubPage after clicking on the button.
     */
    @Step("Click to get more details about the club")
    public ViewClubPage clickOnMoreDetails() {
        moreDetailsButton.click();
        return this;
    }

    /**
     * Clicks on the button to show all feedback
     *
     * @return The ViewClubPage after clicking on the button.
     */
    @Step("Click to show all feedback")
    public ViewClubPage clickOnShowFeedback() {
        showFeedback.click();
        return this;
    }

    public boolean isSubscribeButtonEnabled() {
        return waitForElementToAppear(subscribeButton).isEnabled();
    }

    /**
     * Gets the name of the club.
     *
     * @return The name of the club.
     */
    @Step("Get club name")
    public String getClubName() {
        return clubName.getText();
    }

}
