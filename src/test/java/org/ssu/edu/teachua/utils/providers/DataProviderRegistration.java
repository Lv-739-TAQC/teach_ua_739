package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

public class DataProviderRegistration {

    @DataProvider(name = "registrationData")
    public static Object[][] registrationFormData() {
        return new Object[][]{
                {"Вайтович", "Світлана", "671234567", "svitlanawhite@gmail.com", "12345678", "12345678"},
        };
    }

    @DataProvider(name = "dpTestIfUserNotCreated")
    public static Object[][] dpTestIfUserNotCreated() {
        return new Object[][]{
                { "John", "Doe", "jondoe@gmail.com", "123456", "0670000067", "ROLE_MANAGER",
                    400, "password must contain at least one uppercase and lowercase letter and password must contain at least one number and special symbol and password size must be between 8 and 20"
                },
        };
    }

}
