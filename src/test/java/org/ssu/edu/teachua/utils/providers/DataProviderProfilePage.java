package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

import static org.ssu.edu.teachua.utils.StringGenerator.randomName;
import static org.ssu.edu.teachua.utils.StringGenerator.randomPhoneNumber;

public class DataProviderProfilePage {


    @DataProvider(name = "dpTestChangePassword")
    public static Object[][] dpTestChangePassword() {
        return new Object[][]{
                {"rgb(255, 0, 0)", "Будь ласка, підтвердіть новий пароль",
                        "Будь ласка, введіть новий пароль", "Будь ласка, введіть діючий пароль"}
        };
    }

    @DataProvider(name = "dpTestVerifieDataLastName")
    private Object[][] dpTestVerifieDataLastName() {
        return new Object[][]{
                {"AfBbCcDdEeFfGgHhIiJjKkLlMm", "Прізвище не може містити більше, ніж 25 символів"},
                {"!@#$%^&,", "Прізвище не може містити спеціальні символи"},
                {"1234", "Прізвище не може містити цифри"},
                {"-Lastname", "Прізвище повинно починатися та закінчуватися літерою"},
                {" Lastname", "Прізвище повинно починатися та закінчуватися літерою"},
                {"'Lastname", "Прізвище повинно починатися та закінчуватися літерою"},
                {"Lastname-", "Прізвище повинно починатися та закінчуватися літерою"},
                {"Lastname ", "Прізвище повинно починатися та закінчуватися літерою"},
                {"Lastname'", "Прізвище повинно починатися та закінчуватися літерою"},
                {"", "Введіть прізвище"}
        };
    }

    @DataProvider(name = "dpTestVerifieDataPhoneNumber")
    private Object[][] dpTestVerifieDataNumberPhone() {
        return new Object[][]{
                {"+3806895", "Телефон не відповідає формату +38(___) ___ __ __"},
                {"+38065987458", "Телефон не відповідає формату +38(___) ___ __ __"},
                {"+3806593859632586", "Телефон не відповідає формату +38(___) ___ __ __"},
                {"+3806598521475", "Телефон не відповідає формату +38(___) ___ __ __"},
                {"jngeoлщшогнеп", "Телефон не відповідає формату +38(___) ___ __ __"},
                {"!@#$%^&*(_+.:", "Телефон не відповідає формату +38(___) ___ __ __"},
                {"", "Телефон не відповідає формату +38(___) ___ __ __"}};
    }

    @DataProvider(name = "dpTestIfPasswordNotUpdated")
    private static Object[][] dpTestIfPasswordNotUpdated() {
        return new Object[][]{
                {1, "", "123_%testPass", "admin@gmail.com", 400,
                        Arrays.asList("Будь ласка, введіть діючий пароль", "Будь ласка, введіть новий пароль", "Будь ласка, підтвердіть новий пароль")
                }};
    }

    @DataProvider(name = "dpTestIfProfileUpdated")
    private static Object[][] dpTestIfProfileUpdated() {
        return new Object[][]{
                {203, Arrays.asList("Hanna", "Kukh", "soyec48727@busantei.com", "0648768777", "ROLE_MANAGER", null), true,
                        randomName(), randomName() + "z", randomPhoneNumber(), 200
                }};
    }

}

