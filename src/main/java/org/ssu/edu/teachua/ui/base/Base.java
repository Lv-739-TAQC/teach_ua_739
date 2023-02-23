package org.ssu.edu.teachua.ui.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class Base {

    private static final int EXPLICIT_WAIT = 100;

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected WebStorage webStorage;
    protected LocalStorage localStorage;

    public Base(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        webStorage = (WebStorage) driver;
        localStorage = webStorage.getLocalStorage();
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        driver.get(url);
    }

    protected WebElement waitForElementToAppear(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected List<WebElement> waitForElementsToAppear(List<WebElement> elements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    // temporary falling asleep :
    protected void sleep(long s) {
        try {
            Thread.sleep(s * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
