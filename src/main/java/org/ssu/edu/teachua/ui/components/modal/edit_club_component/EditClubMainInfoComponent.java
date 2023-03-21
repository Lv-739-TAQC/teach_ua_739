package org.ssu.edu.teachua.ui.components.modal.edit_club_component;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubMainInfoComponent;

import java.util.List;

/**
 * This class contains elements and classes
 * that describe the Main Info page of Edit Club pop-up
 */
public class EditClubMainInfoComponent extends AddClubMainInfoComponent {

    /**
     * This element is finds by xPath the field for entering club name
     */
    @FindBy(how = How.XPATH, using = ".//input[@id='edit_category_name']")
    private WebElement editNameField; //min 5 characters //need to be clear

    /**
     * This list of elements is finds by xPath the checkboxes with possible categories for the club
     */
    @FindBy(how = How.XPATH, using = ".//div/form[@id='edit_category']//div/label/span[contains(@class, 'ant-checkbox')]")
    private List<WebElement> editCategoriesCheckBoxes;

    /**
     * This element is finds by xPath the field for entering min child age
     */
    @FindBy(how = How.XPATH, using = ".//div/form[@id='edit_category']//div/input[@aria-valuemin='2']")
    private WebElement editChildAgeFrom;

    /**
     * This element is finds by xPath the field for entering max child age
     */
    @FindBy(how = How.XPATH, using = ".//div/form[@id='edit_category']//div/input[@aria-valuemin='3']")
    private WebElement editChildAgeFor;

    /**
     * This element is finds by xPath the dropdown with the centers for club
     */
    @FindBy(how = How.XPATH, using = ".//div/form[@id='edit_category']//div[contains(@class, 'ant-select-in')]")
    private WebElement editBelongingToCenter; //click for open dropdown

    /**
     * This list of elements is finds by xPath the center dropdown elements
     */
    @FindBy(how = How.XPATH, using = ".//div[@aria-selected='false' and @class]")
    private List<WebElement> editCenterList;

    public EditClubMainInfoComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * This method is deleting old name and entering new name into 'name' field
     * @param editName name of club
     * @return instance of EditClubMainInfoComponent
     */
    @Step("Edit Club name {editName}")
    public EditClubMainInfoComponent enterNewClubName(String editName) {
        waitForElementToBeClickable(editNameField);
        this.editNameField.click();
        this.editNameField.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.editNameField.sendKeys(editName);
        return this;
    }

    /**
     * This method choose the club categories from the list of categories checkboxes
     * @param editCategory index of checkbox in the list
     * @return instance of EditClubMainInfoComponent
     */
    @Step("Edit club categories {editCategory}")
    public EditClubMainInfoComponent editCategoriesCheckBoxes(int editCategory) {
        waitForElementsToAppear(editCategoriesCheckBoxes).get(editCategory).click();
        return this;
    }

    /**
     * This method is deleting old child min age and entering new child min age for the club
     * @param editChildAge min child age for the club
     * @return instance of EditClubMainInfoComponent
     */
    @Step("Edit child min age {editChildAge}")
    public EditClubMainInfoComponent enterEditChildAgeFrom(String editChildAge) {
        waitForElementToBeClickable(editChildAgeFrom);
        this.editChildAgeFrom.click();
        this.editChildAgeFrom.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.editChildAgeFrom.sendKeys(editChildAge);
        return this;
    }

    /**
     * This method is deleting old child max age and entering new child max age for the club
     * @param editChildAgeTo max child age for the club
     * @return instance of EditClubMainInfoComponent
     */
    @Step("Edit child max age {editChildAgeTo}")
    public EditClubMainInfoComponent enterEditChildAgeFor(String editChildAgeTo) {
        waitForElementToBeClickable(editChildAgeFor);
        this.editChildAgeFor.click();
        this.editChildAgeFor.sendKeys(Keys.chord(Keys.CONTROL + "a" + Keys.DELETE));
        this.editChildAgeFor.sendKeys(editChildAgeTo);
        return this;
    }

    /**
     * This method open the dropdown with centers the club might be related to
     * @return instance of EditClubMainInfoComponent
     */
    @Step("Edit center the club belong to")
    public EditClubMainInfoComponent getEditBelongingToCenter() {
        waitForElementToBeClickable(editBelongingToCenter);
        this.editBelongingToCenter.click();
        waitForElementsToAppear(editCenterList);
        return this;
    }

    /**
     * This method choose the center from dropdown the club belongs to
     * @param editCenter index of center in the list
     * @return instance of EditClubMainInfoComponent
     */
    @Step("Edit center {editCenter} the club belong to")
    public EditClubMainInfoComponent editGetCenter(int editCenter) {
        waitForElementsToAppear(editCenterList).get(editCenter).click();
        return this;
    }

    /**
     * This method click on the 'Next' button
     * @return new instance of EditClubContactsComponent
     */
    @Step("Click on the 'Next' button")
    public EditClubContactsComponent clickEditNextStepButton() {
        waitForElementToBeClickable(nextStepButton);
        nextStepButton.click();
        return new EditClubContactsComponent(driver);
    }
}
