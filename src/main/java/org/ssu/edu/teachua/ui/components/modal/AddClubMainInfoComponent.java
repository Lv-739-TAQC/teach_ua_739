package org.ssu.edu.teachua.ui.components.modal;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
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

    public AddClubMainInfoComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public AddClubMainInfoComponent enterClubName(String nameField) {
        this.nameField.click();
        this.nameField.sendKeys(nameField);
        return this;
    }

    public void setCategoriesCheckBoxes(List<WebElement> categoriesCheckBoxes) {
        this.categoriesCheckBoxes = categoriesCheckBoxes;
    }

    public List<AddClubMainInfoComponent> getCategoriesCheckBoxes() {
        List<AddClubMainInfoComponent> checkBoxes = new ArrayList<>();
        for(WebElement element : categoriesCheckBoxes) {
            checkBoxes.add(new AddClubMainInfoComponent(driver, element));
        }
        return checkBoxes;
    }

    public AddClubMainInfoComponent enterChildAgeFrom() {
        this.childAgeFrom.click();
        this.childAgeFrom.sendKeys((CharSequence) childAgeFrom);
        return this;
    }

    public AddClubMainInfoComponent enterChildAgeFor() {
        this.childAgeFor.click();
        this.childAgeFor.sendKeys((CharSequence) childAgeFor);
        return this;
    }

    public AddClubMainInfoComponent getBelongingToCenter() {
        this.belongingToCenter.click();
        this.belongingToCenter.sendKeys((CharSequence) belongingToCenter);
        return this;
    }

    public void setCenterList(List<WebElement> centerList) {
        this.centerList = centerList;
    }

    public List<AddClubMainInfoComponent> getCenterList() {
        List<AddClubMainInfoComponent> centers = new ArrayList<>();
        for(WebElement element : centerList) {
            centers.add(new AddClubMainInfoComponent(driver, element));
        }
        return centers;
    }

    public AddClubContactsComponent clickNextStepButton() {
        nextStepButton.click();
        return new AddClubContactsComponent(driver, getClubContactsComponent());
    }

}
