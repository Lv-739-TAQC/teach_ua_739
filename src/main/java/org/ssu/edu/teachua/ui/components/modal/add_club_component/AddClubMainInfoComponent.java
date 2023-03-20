package org.ssu.edu.teachua.ui.components.modal.add_club_component;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.BaseClubComponent;

import java.util.List;

public class AddClubMainInfoComponent extends BaseClubComponent {

    @FindBy(how = How.XPATH, using = ".//input[@id='basic_name']")
    private WebElement nameField;

    @FindBy(how = How.XPATH, using = ".//div/form[@id='basic']//div/label/span[contains(@class, 'ant-checkbox')]")
    private List<WebElement> categoriesCheckBoxes;

    @FindBy(how = How.XPATH, using = ".//div/form[@id='basic']//div/input[@aria-valuemin='2']")
    private WebElement childAgeFrom;

    @FindBy(how = How.XPATH, using = ".//div/form[@id='basic']//div/input[@aria-valuemin='3']")
    private WebElement childAgeFor;

    @FindBy(how = How.XPATH, using = ".//div/form[@id='basic']//div[contains(@class, 'ant-select-in')]")
    private WebElement belongingToCenter;

    @FindBy(how = How.XPATH, using = ".//div[@aria-selected='false' and @class]")
    private List<WebElement> centerList;

    public AddClubMainInfoComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * This method is entering name into 'name' field
     * @param name name of club
     * @return instance of AddClubMainInfoComponent
     */
    @Step("Enter club name {name} into 'name' field")
    public AddClubMainInfoComponent enterClubName(String name) {
        this.waitForElementToBeClickable(nameField);
        this.nameField.click();
        this.nameField.sendKeys(name);
        return this;
    }

    /**
     * This method choose the club categories from the list of categories checkboxes
     * @param categoriesNumber  index of checkbox in the list
     * @return instance of AddClubMainInfoComponent
     */
    @Step("Choose club categories {categoriesNumber}")
    public AddClubMainInfoComponent getCategoriesCheckBoxes(int categoriesNumber) {
        waitForElementsToAppear(this.categoriesCheckBoxes).get(categoriesNumber).click();
        return this;
    }

    /**
     * This method is entering child min age for the club
     * @param childAge - min child age for the club
     * @return instance of AddClubMainInfoComponent
     */
    @Step("Enter child min age {childAge}")
    public AddClubMainInfoComponent enterChildAgeFrom(String childAge) {
        waitForElementToBeClickable(childAgeFrom);
        this.childAgeFrom.click();
        this.childAgeFrom.sendKeys(childAge);
        return this;
    }

    /**
     * This method is entering child max age for the club
     * @param childAgeTo - max child age for the club
     * @return instance of AddClubMainInfoComponent
     */
    @Step("Enter child max age{childAgeTo}")
    public AddClubMainInfoComponent enterChildAgeFor(String childAgeTo) {
        waitForElementToBeClickable(childAgeFor);
        this.childAgeFor.click();
        this.childAgeFor.sendKeys(childAgeTo);
        return this;
    }

    /**
     * This method open the dropdown with centers the club might be related to
     * @return instance of AddClubMainInfoComponent
     */
    @Step("Add center the club belong to")
    public AddClubMainInfoComponent getBelongingToCenter() {
        waitForElementToBeClickable(belongingToCenter);
        this.belongingToCenter.click();
        waitForElementsToAppear(centerList);
        return this;
    }

    /**
     * This method choose the center from dropdown the club belongs to
     * @param centerNumber index of center in the list
     * @return instance of AddClubMainInfoComponent
     */
    @Step("Choose center {centerNumber} the club belongs to")
    public AddClubMainInfoComponent getCertainCenter(int centerNumber) {
        waitForElementsToAppear(centerList).get(centerNumber).click();
        return this;
    }

    /**
     * This method click on the 'Next' button
     * @return new instance of AddClubContactsComponent
     */
    @Step("Click on the 'Next' button")
    public AddClubContactsComponent clickNextStepButton() {
        waitForElementToBeClickable(nextStepButton);
        nextStepButton.click();
        return new AddClubContactsComponent(driver);
    }
}
