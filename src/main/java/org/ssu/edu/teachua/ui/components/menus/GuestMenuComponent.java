package org.ssu.edu.teachua.ui.components.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ssu.edu.teachua.ui.base.BaseComponent;

public class GuestMenuComponent extends BaseComponent implements MenuComponent {
    public GuestMenuComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }
}
