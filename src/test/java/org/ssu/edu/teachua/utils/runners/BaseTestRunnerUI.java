package org.ssu.edu.teachua.utils.runners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ssu.edu.teachua.utils.EntityService;
import org.ssu.edu.teachua.utils.TestNgListeners;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Random;

@Listeners(TestNgListeners.class)
public class BaseTestRunnerUI {

    protected WebDriver driver;

    protected static final TestValueProvider valueProvider = new TestValueProvider();
    protected SoftAssert softAssert = new SoftAssert();
    protected Browsers browsers = new Browsers();
    protected Random random = new Random();
    protected EntityService entityService = new EntityService();

    private void checkErrorPage(String browser) {
        try {
            driver.findElement(By.id(browser.equals("firefox") ? "advancedButton" : "details-button")).click();
            driver.findElement(By.id(browser.equals("firefox") ? "exceptionDialogButton" : "proceed-link")).click();
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Parameters("browser")
    @BeforeClass(description = "Init Driver.")
    protected void initDriver(String browser, ITestContext context) {
        WebDriverManager.chromedriver().setup();
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
