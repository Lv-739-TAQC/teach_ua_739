package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class DataProviderLocation {
    @DataProvider(name = "dpTestAddLocation")
    public static Object[][] dpTestAddLocation() {
        return new Object[][]{
                {"Лівий берег", "Одеса", "Фонтан", "Приморський", "проспект Бажана, 3А",
                        "50.406108, 30.668492", "0679002233", "Лівий берег"
                }
        };
    }
}
