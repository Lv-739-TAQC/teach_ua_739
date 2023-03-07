package org.ssu.edu.teachua.ui.runners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestRunnerUI {

    protected static TestValueProvider valueProvider;
    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void initTestValueProvider() {
        if (valueProvider == null) {
            valueProvider = new TestValueProvider();
        }
    }




    @BeforeClass
    protected void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(valueProvider.getBaseUiUrl());
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
    }

    @AfterSuite
    public void quitDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
