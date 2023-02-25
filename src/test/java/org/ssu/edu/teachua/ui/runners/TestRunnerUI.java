package org.ssu.edu.teachua.ui.runners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class TestRunnerUI {

    protected WebDriver driver;
    protected static TestValueProvider testValueProvider;

    @BeforeSuite
    public void initTestValueProvider() {
        if (testValueProvider == null) {
            testValueProvider = new TestValueProvider();
        }
    }

    @BeforeMethod
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(testValueProvider.getBaseUiUrl());
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
    }

    @AfterMethod
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
