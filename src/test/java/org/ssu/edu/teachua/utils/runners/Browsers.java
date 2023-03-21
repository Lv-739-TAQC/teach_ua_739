package org.ssu.edu.teachua.utils.runners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Parameters;

/**
 * This class contains a method to launch the browser driver according to the name of the browser we are calling
 */
public class Browsers {

    /**
     * This variable is required to solve the WebSocket Issue.
     * Must be added as an argument for chrome and edge browsers
     */
    private final String REMOTE_CONTROL = "--remote-allow-origins=*";
    WebDriver driver = null;

    /**
     *This method accepts the name of the browser as a parameter and,
     * depending on this name, launches the browser we need
     * @param browser extracts the name of the browser from the xml file using the {@link Parameters} annotation
     * @return the driver of the selected browser
     */
    @Parameters("browser")
    public WebDriver setUpBrowser(String browser) {

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(REMOTE_CONTROL);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments(REMOTE_CONTROL);
                driver = new EdgeDriver(edgeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--allow-origins=https://speak-ukrainian.org.ua");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new RuntimeException("Invalid browser name " + browser);
        }

        return driver;
    }
}
