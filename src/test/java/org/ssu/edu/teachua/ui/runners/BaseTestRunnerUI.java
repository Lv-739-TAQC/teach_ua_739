package org.ssu.edu.teachua.ui.runners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

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
    protected void initDriver() {
        driver = new ChromeDriver();
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
