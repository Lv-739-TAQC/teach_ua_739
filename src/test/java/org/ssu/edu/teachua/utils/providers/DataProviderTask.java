package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class DataProviderTask {

    public static final List<String> ERROR_MSG = Arrays.asList(
            "Поле 'Заголовок' не може бути пустим",
            "Поле 'Заголовок' може містити тільки українські та англійські літери, цифри та спеціальні символи",
            "Поле 'Заголовок' може містити мінімум 40 максимум 3000 символів",
            "Поле 'Назва' не може бути пустим",
            "Поле 'Назва' може містити тільки українські та англійські літери, цифри та спеціальні символи",
            "Поле 'Назва' може містити мінімум 5 максимум 50 символів",
            "Поле 'Опис' не може бути пустим",
            "Поле 'Опис' може містити тільки українські та англійські літери, цифри та спеціальні символи",
            "Поле 'Опис' може містити мінімум 40 максимум 3000 символів",
            "Поле 'Опис' може містити мінімум 40 максимум 3000 символів"

    );

    public static final List<String> API_ERROR_MSG = Arrays.asList(
            "name must contain a minimum of 5 and a maximum of 50 letters",
            "name Помилка. Текст містить недопустимі символи",
            "description must contain a minimum of 40 and a maximum of 3000 letters",
            "description Помилка. Текст містить недопустимі символи and name Помилка. Текст містить недопустимі символи",
            "name must not be blank",
            "description must contain a maximum of 3000 letters and name must not be blank and name must contain a minimum of 5 and a maximum of 50 letters",
            "name must contain a minimum of 5 and a maximum of 255 letters",
            "description Помилка. Текст містить недопустимі символи",
            "name must not be blank and description must contain a maximum of 10000 letters and name must contain a minimum of 5 and a maximum of 255 letters and headerText must not be blank and headerText must contain a minimum of 40 and a maximum of 10000 letters",
            "headerText must not be blank and name must not be blank"
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

    @DataProvider(name = "dpTestAddTaskInvalidDescription")
    public static Object[][] dpTestAddTask() {
        return new Object[][]{
                {25, 05, 2025, "photos/image.png", "Впровадження електронного каталогу",
                        "Електронний каталог: досвід впровадження та використання",
                        "", "Ukrainian", ERROR_MSG.get(6)},
                {25, 05, 2025, "photos/image.png", "Впровадження електронного каталогу",
                        "Електронний каталог: досвід впровадження та використання",
                        "ъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ð", "Ukrainian", ERROR_MSG.get(7)},
                {25, 05, 2025, "photos/image.png", "Впровадження електронного каталогу",
                        "Електронний каталог: досвід впровадження та використання",
                        "Description field input symbols length.", "Ukrainian", ERROR_MSG.get(8)},
                {25, 05, 2025, "photos/image.png", "Впровадження електронного каталогу",
                        "Електронний каталог: досвід впровадження та використання",
                        ("descriptio").repeat(30) + ".", "Ukrainian", ERROR_MSG.get(9)}
        };
    }

    @DataProvider(name = "testEditTaskWithInvalidData")
    public static Object[][] dpCantEditTask() {
        return new Object[][]{
                {" ", "header text must contain min fourty letters", " ", "/upload/test/test.png",
                        "2023-11-03", 777},

                {null, "header text must contain min fourty letters", null, "/upload/test/test.png",
                        "2023-11-03", 777}
        };
    }

    @DataProvider(name = "testEditTaskWithValidData")
    public static Object[][] dpTestEditTask() {
        return new Object[][]{
                {"namenamename1213#$%", "header text must contain min fourty letters",
                        "descriptiondescriptiondescriptiondescriptiondescription12345$%%^$#", "/upload/test/test.png", "2023-12-03", 777}
        };
    }

    @DataProvider(name = "testCreateTaskWithInvalidData")
    public static Object[][] dpTestCantCreateTask() {
        return new Object[][]{
                {"name", "header text must contain min fourty letters", "descriptiondescriptiondescriptiondescriptiondescription",
                        "/upload/test/test.png", "2023-12-03", API_ERROR_MSG.get(0)},
                {"namenamenamenamenamenamenamenamenamenamenamenamenam", "header text must contain min fourty letters",
                        "descriptiondescriptiondescriptiondescriptiondescription", "/upload/test/test.png", "2023-11-03", API_ERROR_MSG.get(0)},
                {"namenameЁ, Ы,Э", "header text must contain min fourty letters", "descriptiondescriptiondescriptiondescriptiondescription",
                        "/upload/test/test.png", "2023-11-03", API_ERROR_MSG.get(1)},
                {"namenamename", "header text must contain min fourty letters", "descriptiondescriptiondescriptiondescr", "/upload/test/test.png",
                        "2023-11-03", API_ERROR_MSG.get(2)},
                {"namenamename", "header text must contain min fourty letters", " descriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondedescriptiondescriptiondescridescriptionde ",
                        "/upload/test/test.png", "2023-11-03", API_ERROR_MSG.get(2)},
                {"namenamename", "header text must contain min fourty letters", "descriptiondescriptiondescriptiondescriptiondescription Ё, Ы,Э ", "/upload/test/test.png",
                        "2023-11-03", API_ERROR_MSG.get(3)}
        };
    }

    @DataProvider(name = "testCreateTaskWithValidData")
    public static Object[][] dpTestCreateTask() {
        return new Object[][]{
                {"namenamename1213#$%", "header text must contain min fourty letters",
                        "descriptiondescriptiondescriptiondescriptiondescription12345$%%^$# ", "/upload/test/test.png", "2023-12-03"}
        };
    }

    @DataProvider(name = "dpAPITestEditTaskInvalidData2")
    public Object[][] dpAPITestEditTask2() {
        return new Object[][]{
                {"name", "headerText".repeat(4), "description".repeat(5), "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), API_ERROR_MSG.get(6), 400},
                {"namenam".repeat(5), "headerText".repeat(4), "description".repeat(5), "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), API_ERROR_MSG.get(0), 400},
                {"namenameЁ, Ы,Э", "headerText".repeat(4), "description".repeat(5), "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), API_ERROR_MSG.get(1), 400},
                {"namenamename", "headerText".repeat(4), "description".repeat(5), "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), API_ERROR_MSG.get(2), 400},
                {"namenamename", "headerText".repeat(4), "description".repeat(50), "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), API_ERROR_MSG.get(2), 400},
                {"namenamename".repeat(5), "headerText".repeat(4), " description".repeat(100) + "Ё, Ы,Э", "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), API_ERROR_MSG.get(7), 400}
        };
    }

    @DataProvider(name = "dpAPITestEditTaskInvalidData3")
    public Object[][] dpAPITestEditTask3() {
        return new Object[][]{
                {"           ", "             ", "                 ", "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), API_ERROR_MSG.get(8), 400},
                {" namenam ".repeat(5), " headerText ".repeat(4), " description ".repeat(5), "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), API_ERROR_MSG.get(4), 400},
                {null, null, null, "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), API_ERROR_MSG.get(9), 400},
        };
    }
}
