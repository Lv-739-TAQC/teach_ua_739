package org.ssu.edu.teachua.ui.components.date_picker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;

import java.util.Map;

import static java.util.Map.entry;

public class SelectDateComponent extends BaseComponent {

    private static final Map<String, Integer> months = Map.ofEntries(
            entry("Jan", 1),
            entry("feb", 2),
            entry("Mar", 3),
            entry("Apr", 4),
            entry("May", 5),
            entry("Jun", 6),
            entry("Jul", 7),
            entry("Aug", 8),
            entry("Sep", 9),
            entry("Oct", 10),
            entry("Nov", 11),
            entry("Dec", 12)
    );

    private static final String DAY_XPATH = ".//td[contains(@class, 'ant-picker-cell-in-view')]/div[text()='%s']";

    @FindBy(how = How.XPATH, using = ".//button[@class='ant-picker-header-super-prev-btn']")
    private WebElement previousYearBtn;

    @FindBy(how = How.XPATH, using = ".//button[@class='ant-picker-header-prev-btn']")
    private WebElement previousMonthBtn;

    @FindBy(how = How.XPATH, using = ".//button[@class='ant-picker-month-btn']")
    private WebElement monthBtn;

    @FindBy(how = How.XPATH, using = ".//button[@class='ant-picker-year-btn']")
    private WebElement yearBtn;

    @FindBy(how = How.XPATH, using = ".//button[@class='ant-picker-header-next-btn']")
    private WebElement nextMonthBtn;

    @FindBy(how = How.XPATH, using = ".//button[@class='ant-picker-header-super-next-btn']")
    private WebElement nextYearBtn;

    public SelectDateComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public void selectDate(int day, int month, int year) {
        selectYear(year);
        selectMonth(month);
        selectDay(day);
    }

    public void selectYear(int year) {
        int currentYear = Integer.parseInt(yearBtn.getText());
        if (year > currentYear) {
            while (currentYear != year) {
                nextYearBtn.click();
                currentYear = Integer.parseInt(yearBtn.getText());
            }
        } else if (year < currentYear) {
            while (currentYear != year) {
                previousYearBtn.click();
                currentYear = Integer.parseInt(yearBtn.getText());
            }
        }
    }

    public void selectMonth(int month) {
        String currentMonth = monthBtn.getText();
        if (month > months.get(currentMonth)) {
            while (month != months.get(currentMonth)) {
                nextMonthBtn.click();
                currentMonth = monthBtn.getText();
            }
        } else if (month < months.get(currentMonth)) {
            while (month != months.get(currentMonth)) {
                previousMonthBtn.click();
                currentMonth = monthBtn.getText();
            }
        }
    }

    public void selectDay(int day) {
        driver.findElement(By.xpath(String.format(DAY_XPATH, day))).click();
    }
}
