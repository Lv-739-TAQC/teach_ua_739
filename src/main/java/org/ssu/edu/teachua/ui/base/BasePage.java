package org.ssu.edu.teachua.ui.base;

import org.openqa.selenium.WebDriver;
import org.ssu.edu.teachua.ui.header.HeaderComponent;

public abstract class BasePage extends Base {
    private final HeaderComponent header;

    public BasePage(WebDriver driver) {
        super(driver);
        header = new HeaderComponent(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public HeaderComponent getHeader() {
        return header;
    }
}
