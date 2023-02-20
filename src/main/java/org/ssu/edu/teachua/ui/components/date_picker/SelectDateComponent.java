package org.ssu.edu.teachua.ui.components.date_picker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.ssu.edu.teachua.ui.base.BaseComponent;
import org.ssu.edu.teachua.ui.pages.tasks.AddTaskPage;

import java.util.HashMap;
import java.util.Map;

public class SelectDateComponent extends BaseComponent {

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
        if (day > 31 || day < 1 || month > 12 || month < 1 || year < 1)
            return;

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
        if (month > months().get(currentMonth)) {
            while (month != months().get(currentMonth)) {
                nextMonthBtn.click();
                currentMonth = monthBtn.getText();
            }
        } else if (month < months().get(currentMonth)) {
            while (month != months().get(currentMonth)) {
                previousMonthBtn.click();
                currentMonth = monthBtn.getText();
            }
        }
    }

    public void selectDay(int day) {
        driver.findElement(By.xpath(String.format(DAY_XPATH, day))).click();
    }

    public Map<String, Integer> months() {
        Map<String, Integer> months = new HashMap<>();
        months.put("Jan", 1);
        months.put("Feb", 2);
        months.put("Mar", 3);
        months.put("Apr", 4);
        months.put("May", 5);
        months.put("Jun", 6);
        months.put("Jul", 7);
        months.put("Aug", 8);
        months.put("Sep", 9);
        months.put("Oct", 10);
        months.put("Nov", 11);
        months.put("Dec", 12);
        return months;
    }
}
