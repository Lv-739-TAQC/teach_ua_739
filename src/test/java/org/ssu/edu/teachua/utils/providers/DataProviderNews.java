package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

public class DataProviderNews {

    @DataProvider(name = "dpTestButtonsActivity")
    public static Object[][] dpTestButtonsActivity() {
        return new Object[][]{
                {"Київ", "Гуртки у місті Київ"},
                {"Харків", "Гуртки у місті Харків"},
                {"Дніпро", "Гуртки у місті Дніпро"},
                {"Одеса", "Гуртки у місті Одеса"},
                {"Львів", "Гуртки у місті Львів"}
        };
    }
}
