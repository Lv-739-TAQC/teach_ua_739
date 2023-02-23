package org.ssu.edu.teachua.ui.components.modal.edit_club_component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.modal.add_club_component.AddClubMainInfoComponent;

import java.util.ArrayList;
import java.util.List;

public class EditClubMainInfoComponent extends AddClubMainInfoComponent {

    @FindBy(how = How.XPATH, using = ".//div/form[@id='edit_category']//div/span[contains(@class, 'add-club-input')]")
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

    public EditClubMainInfoComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public EditClubMainInfoComponent enterNewClubName(String nameField) {
        this.editNameField.click();
        this.editNameField.clear();
        this.editNameField.sendKeys(nameField);
        return this;
    }

    public void setCategoriesCheckBoxes(List<WebElement> categoriesCheckBoxes) {
        this.editCategoriesCheckBoxes = categoriesCheckBoxes;
    }

    public List<EditClubMainInfoComponent> getEditCategoriesCheckBoxes() {
        List<EditClubMainInfoComponent> checkBoxes = new ArrayList<>();
        for (WebElement element : editCategoriesCheckBoxes) {
            checkBoxes.add(new EditClubMainInfoComponent(driver, element));
        }
        return checkBoxes;
    }

    public EditClubMainInfoComponent enterEditChildAgeFrom(String editChildAge) {
        this.editChildAgeFrom.click();
        this.editChildAgeFor.clear();
        this.editChildAgeFrom.sendKeys(editChildAge);
        return this;
    }

    public EditClubMainInfoComponent enterEditChildAgeFor(String editChildAgeTo) {
        this.editChildAgeFor.click();
        this.editChildAgeFor.clear();
        this.editChildAgeFor.sendKeys(editChildAgeTo);
        return this;
    }

    public EditClubMainInfoComponent getEditBelongingToCenter() {
        this.editBelongingToCenter.click();
        this.editBelongingToCenter.sendKeys((CharSequence) editBelongingToCenter);
        return this;
    }

    public List<EditClubMainInfoComponent> getEditCenterList() {
        List<EditClubMainInfoComponent> centers = new ArrayList<>();
        for (WebElement element : editCenterList) {
            centers.add(new EditClubMainInfoComponent(driver, element));
        }
        return centers;
    }

    public EditClubContactsComponent clickNextStepButton() {
        nextStepButton.click();
        return new EditClubContactsComponent(driver, getClubContactsComponent());
    }
}
