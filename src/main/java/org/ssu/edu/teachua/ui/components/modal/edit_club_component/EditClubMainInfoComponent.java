package org.ssu.edu.teachua.ui.components.modal.edit_club_component;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubMainInfoComponent;

import java.util.List;

public class EditClubMainInfoComponent extends AddClubMainInfoComponent {

    @FindBy(how = How.XPATH, using = ".//input[@id='edit_category_name']")
    private WebElement editNameField; //min 5 characters //need to be clear

    @FindBy(how = How.XPATH, using = ".//div/form[@id='edit_category']//div/label/span[contains(@class, 'ant-checkbox')]")
    private List<WebElement> editCategoriesCheckBoxes;

    @FindBy(how = How.XPATH, using = ".//div/form[@id='edit_category']//div/input[@aria-valuemin='2']")
    private WebElement editChildAgeFrom;

    @FindBy(how = How.XPATH, using = ".//div/form[@id='edit_category']//div/input[@aria-valuemin='3']")
    private WebElement editChildAgeFor;

    @FindBy(how = How.XPATH, using = ".//div/form[@id='edit_category']//div[contains(@class, 'ant-select-in')]")
    private WebElement editBelongingToCenter; //click for open dropdown

    @FindBy(how = How.XPATH, using = ".//div[@aria-selected='false' and @class]")
    private List<WebElement> editCenterList;

    public EditClubMainInfoComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Edit Club name")
    public EditClubMainInfoComponent enterNewClubName(String editName) {
        waitForElementToBeClickable(editNameField);
        this.editNameField.click();
        this.editNameField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.editNameField.sendKeys(editName);
        return this;
    }

    @Step("Edit club categories")
    public EditClubMainInfoComponent editCategoriesCheckBoxes(int editCategory) {
        waitForElementsToAppear(editCategoriesCheckBoxes).get(editCategory).click();
        return this;
    }

    @Step("Edit child min age")
    public EditClubMainInfoComponent enterEditChildAgeFrom(String editChildAge) {
        waitForElementToBeClickable(editChildAgeFrom);
        this.editChildAgeFrom.click();
        this.editChildAgeFrom.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.editChildAgeFrom.sendKeys(editChildAge);
        return this;
    }

    @Step("Edit child max age")
    public EditClubMainInfoComponent enterEditChildAgeFor(String editChildAgeTo) {
        waitForElementToBeClickable(editChildAgeFor);
        this.editChildAgeFor.click();
        this.editChildAgeFor.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.editChildAgeFor.sendKeys(editChildAgeTo);
        return this;
    }

    @Step("Edit center the club belong to")
    public EditClubMainInfoComponent getEditBelongingToCenter() {
        waitForElementToBeClickable(editBelongingToCenter);
        this.editBelongingToCenter.click();
        waitForElementsToAppear(editCenterList);
        return this;
    }

    @Step("Edit center the club belong to")
    public EditClubMainInfoComponent editGetCenter(int editCenter) {
        waitForElementsToAppear(editCenterList).get(editCenter).click();
        return this;
    }

    @Step("Click on the 'Next' button")
    public EditClubContactsComponent clickEditNextStepButton() {
        waitForElementToBeClickable(nextStepButton);
        nextStepButton.click();
        return new EditClubContactsComponent(driver);
    }
}
