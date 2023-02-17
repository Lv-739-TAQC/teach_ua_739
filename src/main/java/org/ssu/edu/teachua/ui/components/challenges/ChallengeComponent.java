package org.ssu.edu.teachua.ui.components.challenges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;

public class ChallengeComponent extends BaseComponent {
    @FindBy(how = How.XPATH, using = "//*[@class='ant-table-row ant-table-row-level-0 editable-row']")
    private WebElement challengeItem;
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-table-cell']//a)[1]")
    private WebElement challengeId;
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-table-cell']//a)[2]")
    private WebElement challengeSortNumber;
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-table-cell']//a)[3]")
    private WebElement challengeName;
    @FindBy(how = How.XPATH, using = "(//*[@class='ant-table-cell']//a)[4]")
    private WebElement challengeTitle;

    public ChallengeComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

}
