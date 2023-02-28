package org.ssu.edu.teachua.ui.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.header.HeaderComponent;

public abstract class BasePage extends Base {

    @FindBy(how = How.XPATH, using = "//body")
    private WebElement headerNode;

    protected HeaderComponent header;

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
