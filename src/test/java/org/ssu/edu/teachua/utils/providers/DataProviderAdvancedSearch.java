package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class DataProviderAdvancedSearch {

    @DataProvider(name = "dpAgeFieldTest")
    public static Object[][] dpTestAgeField() {
        return new Object[][]{
                {Arrays.asList("1", "2", "18", "19"), Arrays.asList("2", "18")}
        };
    }
}
