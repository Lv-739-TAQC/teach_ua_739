package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

public class DataProviderLocation {

    @DataProvider(name = "dpTestAddLocationAllFields")
    public static Object[][] dpTestAddLocationAllFields() {
        return new Object[][]{
                {"Лівий берег", "Одеса", "Фонтан", "Приморський", "проспект Бажана, 3А",
                        "50.406108, 30.668492", "0679002233", "Лівий берег"}
        };
    }

    @DataProvider(name = "dpTestAddLocationMandatoryFields")
    public static Object[][] dpTestAddLocationMandatoryFields() {
        return new Object[][]{
                {"тестова-локація", "Харків", "проспект Шевченка", "50.406108, 30.668492",
                        "0679002233", "тестова-локація"}
        };
    }
}
