package org.ssu.edu.teachua.utils.runners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.ssu.edu.teachua.utils.TestNgListeners;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

@Listeners(TestNgListeners.class)
public class BaseTestRunnerUI {

    protected static TestValueProvider valueProvider;
    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void initTestValueProvider() {
        if (valueProvider == null) {
            valueProvider = new TestValueProvider();
        }
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass(description = "Init ChromeDriver.")
    protected void initDriver(ITestContext context) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        context.setAttribute("myDriver", driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(valueProvider.getBaseUiUrl());
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
    }

    @AfterClass
    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }

    @AfterSuite
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
