package org.ssu.edu.teachua.ui.pages.challenges;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * class contains elements and methods which represents
 * the functionality to edit a challenge
 */
public class EditChallengePage extends AddChallengePage {

    /**
     * WebElement represents 'change status' button
     */
    @FindBy(how = How.XPATH, using = "//button[@id='isActive']")
    private WebElement changeStatus;
    /**
     * WebElement represents 'change date' button
     */
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-btn ant-btn-default flooded-button'])[3]")
    private WebElement changeDateBtn;

    /**
     * creation constructor matching super with one parameter
     */
    public EditChallengePage(WebDriver driver) {
        super(driver);
    }

    /**
     * click 'change status'
     * @return EditChallengePage with changed status
     */
    @Step("Change challenge status")
    public EditChallengePage changeStatus() {
        waitForElementToBeClickable(changeStatus).click();
        return this;
    }

    /**
     * click 'change date'
     * @return EditChallengePage with selected date
     */
    @Step("Change challenge date")
    public EditChallengePage clickChangeDate() {
        waitForElementToBeClickable(changeDateBtn).click();
        return new EditChallengePage(driver);
    }
}

