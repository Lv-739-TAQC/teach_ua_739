package org.ssu.edu.teachua.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.ssu.edu.teachua.db.entities.News;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.NewsService;
import org.ssu.edu.teachua.ui.components.modal.add_news_component.AddNewsComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.utils.EntityService;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.Assert;


import static org.ssu.edu.teachua.utils.Helper.checkFileSize;

public class NewsJanetScenarioStep {


    private WebDriver driver;

    private TestValueProvider valueProvider = new TestValueProvider();
    protected EntityService entityService = new EntityService();
    private AddNewsComponent addNewsArticle;


    @Given("User log in as an admin")
    public void userLogInAsAmin() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(valueProvider.getBaseUiUrl());
        checkErrorPage("chrome");

        HomePage homePage = new HomePage(driver);

        homePage.getHeader()
                .openGuestProfileMenu()
                .openLogInForm()
                .enterEmail(valueProvider.getAdminEmail())
                .enterPassword(valueProvider.getAdminPassword())
                .clickLoginButton()
                .loginIsSuccess();
    }

    @And("User is on the add news article page")
    public void openNewsPage() {
        HomePage homePage = new HomePage(driver);
        homePage.getHeader()
                .openAdminProfileMenu()
                .openPageMenu()
                .clickNews()
                .clickAddNewsArticle();
    }

    private void checkErrorPage(String browser) {
        try {
            driver.findElement(By.id(browser.equals("firefox") ? "advancedButton" : "details-button")).click();
            driver.findElement(By.id(browser.equals("firefox") ? "exceptionDialogButton" : "proceed-link")).click();
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @When("User fills in the news article title {string}")
    public void fillInNewsArticleTitle(String title) {
        addNewsArticle = new AddNewsComponent(driver);
        addNewsArticle.addNewsTitle(title);

    }

    @And("User fills in the news article content {string}")
    public void fillInNewsArticleContent(String content) {
        addNewsArticle.addNewsContent(content);

    }

    @And("User fills in the news article image {string} greater than 300KB")
    public void fillInNewsArticlePhoto(String photoPath) {
        addNewsArticle.addNewsPhoto(valueProvider.getFilePath(photoPath));

    }

    @And("User submits the news article")
    public void submitNewsArticle() {
        addNewsArticle.clickSubmit();
    }

    @Then("The system should compress the image {string} to {int} or less")
    public void verifyImageCompression(String imageName, int expectedFileSize) throws DBException, EntityException {
        NewsService newsService = entityService.getNewsService();
        News news = newsService.getNewsByURLTitleLogo(imageName);
        String newsLogoURL = news.getUrlTitleLogo();
        String webNewsLogoURL = valueProvider.getBaseUiUrl() + newsLogoURL;
        long actualFileSize = checkFileSize(webNewsLogoURL);
        Assert.assertTrue(actualFileSize <= expectedFileSize, "File size was not compressed");
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}
