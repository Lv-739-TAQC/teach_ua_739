package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

public class DataProviderTask {

    public static final List<String> ERROR_MSG = Arrays.asList(
            "Поле 'Опис' не може бути пустим",
            "description Помилка. Текст містить недопустимі символи",
            "Поле 'Опис' може містити мінімум 40 максимум 3000 символів",
            "Поле 'Опис' може містити мінімум 40 максимум 3000 символів"
    );

    @DataProvider(name = "dpTestAddTaskInvalidDescription")
    public static Object[][] dpTestAddTask() {
        return new Object[][]{
                {25, 05, 2025, "photos/image.png", "Впровадження електронного каталогу",
                        "Електронний каталог: досвід впровадження та використання",
                        "", "Ukrainian", ERROR_MSG.get(0)},
                {25, 05, 2025, "photos/image.png", "Впровадження електронного каталогу",
                        "Електронний каталог: досвід впровадження та використання",
                        "ъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ð", "Ukrainian", ERROR_MSG.get(1)},
                {25, 05, 2025, "photos/image.png", "Впровадження електронного каталогу",
                        "Електронний каталог: досвід впровадження та використання",
                        "Description field input symbols length.", "Ukrainian", ERROR_MSG.get(2)},
                {25, 05, 2025, "photos/image.png", "Впровадження електронного каталогу",
                        "Електронний каталог: досвід впровадження та використання",
                        ("descriptio").repeat(30) + ".", "Ukrainian", ERROR_MSG.get(3)}
        };
    }
}
