package org.ssu.edu.teachua.ui.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.components.header.HeaderComponent;

public abstract class BasePage extends Base {
    private final HeaderComponent header;

    @FindBy(how = How.XPATH, using = "//header")
    private WebElement headerTitle;

    public BasePage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver, headerTitle);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public HeaderComponent getHeader() {
        return header;
    }
}
