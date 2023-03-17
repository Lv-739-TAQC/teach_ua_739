package org.ssu.edu.teachua.utils.runners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.ssu.edu.teachua.utils.TestNgListeners;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.ssu.edu.teachua.utils.runners.Browsers;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


@Listeners(TestNgListeners.class)
public class BaseTestRunnerUI {

    protected static TestValueProvider valueProvider;
    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    Browsers browsers = new Browsers();

    private void checkErrorPage(String browser) {
        try {
            driver.findElement(By.id(browser.equals("firefox") ? "advancedButton" : "details-button")).click();
            driver.findElement(By.id(browser.equals("firefox") ? "exceptionDialogButton" : "proceed-link")).click();
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @BeforeSuite
    public void initTestValueProvider() {
        if (valueProvider == null) {
            valueProvider = new TestValueProvider();
        }
        WebDriverManager.chromedriver().setup();
    }

    @Parameters("browser")
    @BeforeClass(description = "Init ChromeDriver.")
    protected void initDriver(String browser, ITestContext context) throws InterruptedException {
        driver = browsers.setUpBrowser(browser);
        context.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(valueProvider.getBaseUiUrl());
        checkErrorPage(browser);
    }

    @Parameters("browser")
    @AfterClass
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
