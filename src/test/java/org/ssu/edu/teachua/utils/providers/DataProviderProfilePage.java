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
    private static Object[][] dpTestVerifieDataLastName() {
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
    private static Object[][] dpTestVerifieDataNumberPhone() {
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
                {1, "", "123_%testPass", "admin", 400,
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

    @DataProvider(name = "dpTestUpdateFirstLastNamesInvalid")
    private static Object[][] dpTestUpdateFirstLastNamesInvalid() {
        return new Object[][]{
                {203, "Nastia1234", "Kukh", "999999922", "soyec48727@busantei.com", "ROLE_MANAGER", null, true,
                        400, ("\"firstName\"" + " can`t contain numbers")},
                {203, "NastiaNastiaNastiaNastiaNastia", "Kukh", "999999922", "soyec48727@busantei.com", "ROLE_MANAGER", null, true,
                        400, ("\"firstName\"" + " can contain from 1 to 25 letters")},
                {203, "Nastia!@##$#$%", "Kukh", "999999922", "soyec48727@busantei.com", "ROLE_MANAGER", null, true,
                        400, ("\"firstName\"" + " can contain only ukrainian and english letters")},
                {203, "Nastia", "Kukhar#%$#", "999999922", "soyec48727@busantei.com", "ROLE_MANAGER", null, true,
                        400, ("\"lastName\"" + " can contain only ukrainian and english letters")},
                {203, "Nastia", "KukharKukharKukharKukharKukharKukharKukharK", "999999922", "soyec48727@busantei.com", "ROLE_MANAGER", null, true,
                        400, ("\"lastName\"" + " can contain from 1 to 25 letters")},
                {203, "Nastia", "Kukhar123343#", "999999922", "soyec48727@busantei.com", "ROLE_MANAGER", null, true,
                        400, ("\"lastName\"" + " can`t contain numbers")},
        };
    }

    @DataProvider(name = "dpTestUpdatePhoneInvalid")
    private static Object[][] dpTestUpdatePhoneInvalid() {
        return new Object[][]{
                {854, "Jane", "Doe", "janedoelead123@gmail.com", "123456789121212", "ROLE_MANAGER", null, true,
                        400, ("phone Phone number must contain 10 numbers and can`t contain other symbols")},
                {854, "Jane", "Doe", "janedoelead123@gmail.com", "assdsdsd", "ROLE_MANAGER", null, true,
                        400, ("phone Phone number must contain 10 numbers and can`t contain other symbols")},
                {854, "Jane", "Doe", "janedoelead123@gmail.com", "@$#%#%^", "ROLE_MANAGER", null, true,
                        400, ("phone Phone number must contain 10 numbers and can`t contain other symbols")}
        };
    }

    @DataProvider(name = "dpAPITestChangeRole")
    private static Object[][] dpAPITestChangeRole() {
        return new Object[][]{
                {203, "Nastia", "Kukh", "soyec48727@busantei.com", "0000000000", "ROLE_MANAGER", null, true},
                {203, "Nastia", "Kukh", "soyec48727@busantei.com", "0000000000", "ROLE_ADMIN", null, true}
        };
    }

}

