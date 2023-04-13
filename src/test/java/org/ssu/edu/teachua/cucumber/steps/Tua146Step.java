package org.ssu.edu.teachua.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.ssu.edu.teachua.ui.components.card.NewsCardComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.pages.news.NewsPage;
import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Tua146Step {

    private WebDriver driver;
    private final TestValueProvider valueProvider = new TestValueProvider();
    private NewsPage newsPage;
    private List<Date> newsDates = new ArrayList<>();
    private List<Date> descNewsDates;

    @Given("User open website home page")
    public void userOpenWebsiteWithBaseUrl() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(valueProvider.getBaseUiUrl());
        checkErrorPage();

    }

    private void checkErrorPage() {
        try {
            driver.findElement(By.id("details-button")).click();
            driver.findElement(By.id("proceed-link")).click();
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @When("User open news page")
    public void openNewsPage() {
        newsPage = new HomePage(driver)
                .getHeader()
                .clickNewsButton();
    }

    @When("User get all dates from news cards and add them to list")
    public void getAllDates() {
        List<NewsCardComponent> newsCards = newsPage.getCardsWithNews();
        for (NewsCardComponent newsCard : newsCards) {
            try {
                newsDates.add(new SimpleDateFormat("dd.MM.yyyy").parse(newsCard.getNewsDate()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @When("User sort all this dates by desc order and add them to new list")
    public void sortDatesDesc() {
        descNewsDates = new ArrayList<>(newsDates);
        Collections.sort(descNewsDates, Collections.reverseOrder());
    }

    @Then("First list equal to second list")
    public void compareListsWithDates() {
        Assert.assertEquals(newsDates, descNewsDates);
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }
}
