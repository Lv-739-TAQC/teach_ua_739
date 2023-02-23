package org.ssu.edu.teachua.ui.components.modal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.ssu.edu.teachua.ui.base.BaseComponent;

public abstract class BaseClubComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'add-club-content-next')]")
    protected WebElement nextStepButton;
    @FindBy(how = How.XPATH, using = ".//button[contains(@class, 'add-club-content-prev')]")
    protected WebElement previousPageButton;
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-active')]//div[text()[contains(., 'Основна інформація')]])[1]")
    private WebElement clubMainInfoComponent;
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-active')]//div[text()[contains(., 'Контакти')]])[1])")
    private WebElement clubContactsComponent;
    @FindBy(how = How.XPATH, using = "(.//div[contains(@class, 'item-active')]//div[text()[contains(., 'Опис')]])[1]")
    private WebElement clubDescriptionComponent;

    public BaseClubComponent(WebDriver driver) {

        super(driver);
        componentRoot = driver.findElement(By.xpath("//div[contains(@class, 'ant-modal modal-add-club')]"));
        PageFactory.initElements(new DefaultElementLocatorFactory(componentRoot), this);
    }

    protected WebElement getClubMainInfoComponent() {
        return clubMainInfoComponent;
    }

    protected WebElement getClubContactsComponent() {
        return clubContactsComponent;
    }

    protected WebElement getClubDescriptionComponent() {
        return clubDescriptionComponent;
    }
}
