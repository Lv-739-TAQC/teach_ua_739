package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

public class DataProviderRegistration {

    @DataProvider(name = "registrationData")
    public static Object[][] registrationFormData() {
        return new Object[][]{
                {"Вайтович", "Світлана", "671234567", "svitlanawhite@gmail.com", "12345678", "12345678"},
        };
    }
}
