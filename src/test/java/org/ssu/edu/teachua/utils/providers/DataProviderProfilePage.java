package org.ssu.edu.teachua.utils.providers;

import org.ssu.edu.teachua.utils.TestValueProvider;
import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.Random;

public class DataProviderProfilePage {

    protected static final TestValueProvider valueProvider = new TestValueProvider();

    protected static Random random = new Random();

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

    @DataProvider(name = "dpTestIfPasswordIsNotUpdated")
    private static Object[][] dpTestIfPasswordIsNotUpdated() {
        return new Object[][]{
                {"", "123_%testPass", valueProvider.getAdminPassword(), 400,
                        Arrays.asList("Будь ласка, введіть діючий пароль", "Будь ласка, введіть новий пароль", "Будь ласка, підтвердіть новий пароль")
                }};
    }

    @DataProvider(name = "dpTestIfProfileIsUpdated")
    private static Object[][] dpTestIfProfileIsUpdated() {
        String phoneNumber = String.format("067%08d", random.nextInt(100_000_000));
        StringBuilder randomLetters = new StringBuilder();
        char firstLetter = (char) (random.nextInt(26) + 'A');
        randomLetters.append(firstLetter);
        for (int i = 1; i < 5; i++) {
            char letter = (char) (random.nextInt(26) + 'a');
            randomLetters.append(letter);
        }
        return new Object[][]{
                {Arrays.asList("John", "Doe", valueProvider.getUserEmail(), "06700000067", "ROLE_USER"),
                        randomLetters.toString(), randomLetters.append("Z").toString(), phoneNumber, 200
                }};
    }

}

