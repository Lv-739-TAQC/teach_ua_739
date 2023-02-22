package org.ssu.edu.teachua.ui.components.modal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;

public abstract class BaseClubComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-active')]//div[text()[contains(., 'Основна інформація')]])[1]")
    private WebElement clubMainInfoComponent;

    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-active')]//div[text()[contains(., 'Контакти')]])[1])")
    private WebElement clubContactsComponent;

    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-active')]//div[text()[contains(., 'Опис')]])[1]")
    private WebElement clubDescriptionComponent;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'add-club-content-next')]")
    protected WebElement nextStepButton;

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'add-club-content-prev')]")
    protected WebElement previousPageButton;

    protected WebElement getClubMainInfoComponent() {
        return clubMainInfoComponent;
    }

    protected WebElement getClubContactsComponent() {
        return clubContactsComponent;
    }

    protected WebElement getClubDescriptionComponent() {
        return clubDescriptionComponent;
    }

    protected WebElement getNextStepButton() {
        return nextStepButton;
    }

    protected WebElement getPreviousPageButton() {
        return previousPageButton;
    }

    public BaseClubComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }
}
