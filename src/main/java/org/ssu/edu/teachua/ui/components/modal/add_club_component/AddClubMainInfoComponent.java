package org.ssu.edu.teachua.ui.components.modal.add_club_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.BaseClubComponent;

import java.util.List;

public class AddClubMainInfoComponent extends BaseClubComponent {

    @FindBy(how = How.XPATH, using = ".//div/form[@id='basic']//div/span[contains(@class, 'add-club-input')]")
    private WebElement nameField; // min 5 characters

    @FindBy(how = How.XPATH, using = ".//div/form[@id='basic']//div/label/span[contains(@class, 'ant-checkbox')]")
    private List<WebElement> categoriesCheckBoxes;

    @FindBy(how = How.XPATH, using = ".//div/form[@id='basic']//div/input[@aria-valuemin='2']")
    private WebElement childAgeFrom;

    @FindBy(how = How.XPATH, using = ".//div/form[@id='basic']//div/input[@aria-valuemin='3']")
    private WebElement childAgeFor;

    @FindBy(how = How.XPATH, using = ".//div/form[@id='basic']//div[contains(@class, 'ant-select-in')]")
    private WebElement belongingToCenter; //click for open dropdown

    @FindBy(how = How.XPATH, using = ".//div[@aria-selected='false' and @class]")
    private List<WebElement> centerList;

    public AddClubMainInfoComponent(WebDriver driver) {
        super(driver);
    }

    public AddClubMainInfoComponent enterClubName(String name) {
        this.waitForElementToBeClickable(nameField);
        this.nameField.click();
        this.nameField.sendKeys(name);
        return this;
    }

    public AddClubMainInfoComponent getCategoriesCheckBoxes(int category) {
        waitForElementsToAppear(categoriesCheckBoxes).get(category).click();
        return this;
    }

    public AddClubMainInfoComponent enterChildAgeFrom(String childAge) {
        waitForElementToBeClickable(childAgeFrom);
        this.childAgeFrom.click();
        this.childAgeFrom.sendKeys(childAge);
        return this;
    }

    public AddClubMainInfoComponent enterChildAgeFor(String childAgeTo) {
        waitForElementToBeClickable(childAgeFor);
        this.childAgeFor.click();
        this.childAgeFor.sendKeys(childAgeTo);
        return this;
    }

    public AddClubMainInfoComponent getBelongingToCenter() {
        waitForElementToBeClickable(belongingToCenter);
        this.belongingToCenter.click();
        waitForElementsToAppear(centerList);
        return this;
    }

    public AddClubMainInfoComponent getCenter(int center) {
        waitForElementsToAppear(centerList).get(center).click();
        return this;
    }

    public AddClubContactsComponent clickNextStepButton() {
        waitForElementToBeClickable(nextStepButton);
        nextStepButton.click();
        return new AddClubContactsComponent(driver);
    }

}

