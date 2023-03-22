package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

public class DataProviderTask {

    public static final List<String> ERROR_MSG = Arrays.asList(
            "Поле 'Заголовок' не може бути пустим",
            "Поле 'Заголовок' може містити тільки українські та англійські літери, цифри та спеціальні символи",
            "Поле 'Заголовок' може містити мінімум 40 максимум 3000 символів",
            "Поле 'Назва' не може бути пустим",
            "Поле 'Назва' може містити тільки українські та англійські літери, цифри та спеціальні символи",
            "Поле 'Назва' може містити мінімум 5 максимум 50 символів"
    );

    @DataProvider(name = "dpTestAddTaskInvalidTitle")
    public static Object[][] dpTestAddTaskInvalidTitle() {
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

    @DataProvider(name = "dpTestAddClubWithInvalidDate")
    public static Object[][] dpTestAddClubWithInvalidDate() {
        return new Object[][]{
                {"photos/image.png",
                        "Task Ukraine",
                        "Task Ukraine winner 2023  Task Ukraine winner 2023",
                        "Ukraine winner 2023!, Ukraine winner 2023!, Ukraine winner 2023!, Ukraine winner 2023!",
                        "99999",
                        01, 03, 2023,
                        "Дата початку має бути в майбутньому"
                }
        };
    }

    @DataProvider(name = "dpTestAddTaskInvalidName")
    public static Object[][] dpTestAddTaskInvalidName() {

        return new Object[][]{
                {12, 12, 2025, "photos/image.png", "Title", ("description_").repeat(4),
                        "Ukrainian", "", ERROR_MSG.get(3)},
                {12, 12, 2025, "photos/image.png", "Title", ("description_").repeat(4),
                        "Ukrainian", "ъэы; ผม, Ÿ, ð", ERROR_MSG.get(4)},
                {12, 12, 2025, "photos/image.png", "Title", "task-title",
                        "Ukrainian", "Name", ERROR_MSG.get(5)},
                {12, 12, 2025, "photos/image.png", "Title", ("title-title").repeat(300),
                        "Ukrainian", "Name".repeat(13), ERROR_MSG.get(5)},
        };
    }
}
