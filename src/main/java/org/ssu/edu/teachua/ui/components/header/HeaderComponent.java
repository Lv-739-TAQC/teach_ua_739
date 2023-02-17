package org.ssu.edu.teachua.ui.components.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.pages.about.AboutPage;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;

public class HeaderComponent extends BaseComponent {
    @FindBy(how = How.XPATH, using = "./div[1]")
    private WebElement logo;
    @FindBy(how = How.XPATH, using = "./div[2]/ul/li[4]/span/a")
    private WebElement aboutButton;

    public HeaderComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public HomePage clickLogo() {
        logo.click();
        return new HomePage(driver);
    }

    public AboutPage clickAboutButton() {
        aboutButton.click();
        return new AboutPage(driver);
    }
}
