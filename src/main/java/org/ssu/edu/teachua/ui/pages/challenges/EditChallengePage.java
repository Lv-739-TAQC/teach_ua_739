package org.ssu.edu.teachua.ui.pages.challenges;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class EditChallengePage extends AddChallengePage {
    @FindBy(how = How.XPATH, using = "//button[@id='isActive']")
    private WebElement changeStatus;

    @FindBy(how = How.XPATH, using = "(//*[@class='ant-btn ant-btn-default flooded-button'])[3]")
    private WebElement changeDateBtn;

    public EditChallengePage(WebDriver driver) {
        super(driver);
    }

    public EditChallengePage changeStatus() {
        waitForElementToBeClickable(changeStatus).click();
        return this;
    }

    public EditChallengePage clickChangeDate() {
        waitForElementToBeClickable(changeDateBtn).click();
        return new EditChallengePage(driver);
    }
}

