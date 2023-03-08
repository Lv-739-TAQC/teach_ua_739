package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

public class DataProviderProfilePage {
    @DataProvider(name = "dpTestChangePassword")
    public static Object[][] dpTestChangePassword() {
        return new Object[][]{
                {"rgb(255, 0, 0)",
                        "Будь ласка, підтвердіть новий пароль",
                        "Будь ласка, введіть новий пароль",
                        "Будь ласка, введіть діючий пароль"
                }
        };
    }
}
