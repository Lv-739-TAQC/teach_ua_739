package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

public class DataProviderTua328 {

        @DataProvider(name = "dpTua328")
        public static Object[][] dpTua328() {
            return new Object[][]{
                    {"AfBbCcDdEeFfGgHhIiJjKkLlMmNn", "Будь ласка введіть Ваше ім'я\nІм'я не може містити більше, ніж 25 символів"},
                    {"!@#$%^&,", "Ім'я не може містити спеціальні символи"},
                    {"1234", "Ім'я не може містити цифри"},
                    {"-Name", "Будь ласка введіть Ваше ім'я\nІм'я повинно починатися і закінчуватися літерою"},
                    {" Name", "Ім'я повинно починатися і закінчуватися літерою"},
                    {"`Name", "Ім'я не може містити спеціальні символи"},
                    {"Name", "Будь ласка введіть Ваше ім'я"},
                    {"Name ", "м'я повинно починатися і закінчуватися літерою"},
                    {"Name`", "Ім'я не може містити спеціальні символи"}
            };
    }
}
