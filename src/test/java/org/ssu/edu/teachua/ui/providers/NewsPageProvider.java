package org.ssu.edu.teachua.ui.providers;

import org.testng.annotations.DataProvider;

public class NewsPageProvider {

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
