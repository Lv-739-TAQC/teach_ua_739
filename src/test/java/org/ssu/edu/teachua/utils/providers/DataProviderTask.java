package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

public class DataProviderTask {

    public static final List<String> ERROR_MSG = Arrays.asList(
            "Поле 'Заголовок' не може бути пустим",
            "Поле 'Заголовок' може містити тільки українські та англійські літери, цифри та спеціальні символи",
            "Поле 'Заголовок' може містити мінімум 40 максимум 3000 символів"
    );

    @DataProvider(name = "dpTestAddTaskInvalid")
    public static Object[][] dpTestAddTaskInvalid() {
        return new Object[][]{
                {24, 12, 2025, "photos/image.png", "task-name", "",
                        ("task-description").repeat(5), "Ukrainian", ERROR_MSG.get(0)},
                {24, 12, 2025, "photos/image.png", "task-name", ("Aussätzige|Прокаженные").repeat(5),
                        ("task-description").repeat(5), "Ukrainian", ERROR_MSG.get(1)},
                {24, 12, 2025, "photos/image.png", "task-name", "task-title",
                        ("task-description").repeat(5), "Ukrainian", ERROR_MSG.get(2)},
                {24, 12, 2025, "photos/image.png", "task-name", ("title-title").repeat(300),
                        ("task-description").repeat(5), "Ukrainian", ERROR_MSG.get(2)}
        };
    }
}
