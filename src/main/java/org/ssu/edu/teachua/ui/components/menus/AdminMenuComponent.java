package org.ssu.edu.teachua.ui.components.menus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class AdminMenuComponent extends UserMenuComponent implements MenuComponent {

    public AdminMenuComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }
}
