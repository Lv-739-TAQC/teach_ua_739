package org.ssu.edu.teachua.ui.base;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.header.HeaderComponent;

public abstract class BasePage extends Base {

    protected HeaderComponent header;
    @FindBy(how = How.XPATH, using = "//body")
    private WebElement headerNode;

    public BasePage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver, headerNode);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public HeaderComponent getHeader() {
        return header;
    }
}
