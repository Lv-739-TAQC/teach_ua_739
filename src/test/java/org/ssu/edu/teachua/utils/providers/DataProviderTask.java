package org.ssu.edu.teachua.utils.providers;

import org.ssu.edu.teachua.utils.ErrorMessagesAPI;
import org.ssu.edu.teachua.utils.ErrorMessagesUI;
import org.testng.annotations.DataProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class DataProviderTask {

    @DataProvider(name = "dpTestAddTaskInvalidTitle")
    public static Object[][] dpTestAddTaskInvalidTitle() {
        return new Object[][]{
                {24, 12, 2025, "photos/image.png", "task-name", "",
                        ("task-description").repeat(5), "Ukrainian", ErrorMessagesUI.TITLE_CANNOT_BE_EMPTY.getMessage()},
                {24, 12, 2025, "photos/image.png", "task-name", ("Aussätzige|Прокаженные").repeat(5),
                        ("task-description").repeat(5), "Ukrainian", ErrorMessagesUI.TITLE_CAN_ONLY_CONTAIN_LETTERS_DIGITS_SPECIAL_CHARS.getMessage()},
                {24, 12, 2025, "photos/image.png", "task-name", "task-title",
                        ("task-description").repeat(5), "Ukrainian", ErrorMessagesUI.TITLE_CAN_CONTAIN_MIN_40_MAX_3000_CHARS.getMessage()},
                {24, 12, 2025, "photos/image.png", "task-name", ("title-title").repeat(300),
                        ("task-description").repeat(5), "Ukrainian", ErrorMessagesUI.TITLE_CAN_CONTAIN_MIN_40_MAX_3000_CHARS.getMessage()}
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
                        "Ukrainian", "", ErrorMessagesUI.NAME_CANNOT_BE_EMPTY.getMessage()},
                {12, 12, 2025, "photos/image.png", "Title", ("description_").repeat(4),
                        "Ukrainian", "ъэы; ผม, Ÿ, ð", ErrorMessagesUI.NAME_CAN_ONLY_CONTAIN_LETTERS_DIGITS_SPECIAL_CHARS.getMessage()},
                {12, 12, 2025, "photos/image.png", "Title", "task-title",
                        "Ukrainian", "Name", ErrorMessagesUI.NAME_CAN_CONTAIN_MIN_5_MAX_50_CHARS.getMessage()},
                {12, 12, 2025, "photos/image.png", "Title", ("title-title").repeat(300),
                        "Ukrainian", "Name".repeat(13), ErrorMessagesUI.NAME_CAN_CONTAIN_MIN_5_MAX_50_CHARS.getMessage()},
        };
    }

    @DataProvider(name = "dpTestAddTaskInvalidDescription")
    public static Object[][] dpTestAddTask() {
        return new Object[][]{
                {25, 05, 2025, "photos/image.png", "Впровадження електронного каталогу",
                        "Електронний каталог: досвід впровадження та використання",
                        "", "Ukrainian", ErrorMessagesUI.DESCRIPTION_CANNOT_BE_EMPTY.getMessage()},
                {25, 05, 2025, "photos/image.png", "Впровадження електронного каталогу",
                        "Електронний каталог: досвід впровадження та використання",
                        "ъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ðъэы, ผม, Ÿ, ð", "Ukrainian", ErrorMessagesUI.DESCRIPTION_CAN_ONLY_CONTAIN_LETTERS_DIGITS_SPECIAL_CHARS.getMessage()},
                {25, 05, 2025, "photos/image.png", "Впровадження електронного каталогу",
                        "Електронний каталог: досвід впровадження та використання",
                        "Description field input symbols length.", "Ukrainian", ErrorMessagesUI.DESCRIPTION_CAN_CONTAIN_MIN_40_MAX_3000_CHARS.getMessage()},
                {25, 05, 2025, "photos/image.png", "Впровадження електронного каталогу",
                        "Електронний каталог: досвід впровадження та використання",
                        ("descriptio").repeat(30) + ".", "Ukrainian", ErrorMessagesUI.DESCRIPTION_CAN_CONTAIN_MIN_40_MAX_3000_CHARS.getMessage()}
        };
    }

    @DataProvider(name = "testEditTaskWithInvalidData")
    public static Object[][] dpCantEditTask() {
        return new Object[][]{
                {" ", "header text must contain min fourty letters", " ", "/upload/test/test.png",
                        "2023-11-03", BigInteger.valueOf(777)},

                {null, "header text must contain min fourty letters", null, "/upload/test/test.png",
                        "2023-11-03", BigInteger.valueOf(777)}
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
                        "/upload/test/test.png", "2023-12-03", ErrorMessagesAPI.NAME_LENGTH.getMessage()},
                {"namenamenamenamenamenamenamenamenamenamenamenamenam", "header text must contain min fourty letters",
                        "descriptiondescriptiondescriptiondescriptiondescription", "/upload/test/test.png", "2023-11-03", ErrorMessagesAPI.NAME_LENGTH.getMessage()},
                {"namenameЁ, Ы,Э", "header text must contain min fourty letters", "descriptiondescriptiondescriptiondescriptiondescription",
                        "/upload/test/test.png", "2023-11-03", ErrorMessagesAPI.NAME_INVALID_CHARACTERS.getMessage()},
                {"namenamename", "header text must contain min fourty letters", "descriptiondescriptiondescriptiondescr", "/upload/test/test.png",
                        "2023-11-03", ErrorMessagesAPI.DESCRIPTION_LENGTH.getMessage()},
                {"namenamename", "header text must contain min fourty letters", " descriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondescridescriptiondescriptiondescriptiondedescriptiondescriptiondescridescriptionde ",
                        "/upload/test/test.png", "2023-11-03", ErrorMessagesAPI.DESCRIPTION_LENGTH.getMessage()},
                {"namenamename", "header text must contain min fourty letters", "descriptiondescriptiondescriptiondescriptiondescription Ё, Ы,Э ", "/upload/test/test.png",
                        "2023-11-03", ErrorMessagesAPI.DESCRIPTION_INVALID_CHARACTERS.getMessage()}
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
                {"name", "headerText".repeat(4), "description".repeat(5), "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), ErrorMessagesAPI.NAME_LENGTH_EXTENDED.getMessage(), 400},
                {"namenam".repeat(5), "headerText".repeat(4), "description".repeat(5), "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), ErrorMessagesAPI.NAME_LENGTH.getMessage(), 400},
                {"namenameЁ, Ы,Э", "headerText".repeat(4), "description".repeat(5), "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), ErrorMessagesAPI.NAME_INVALID_CHARACTERS.getMessage(), 400},
                {"namenamename", "headerText".repeat(4), "description".repeat(5), "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), ErrorMessagesAPI.DESCRIPTION_LENGTH.getMessage(), 400},
                {"namenamename", "headerText".repeat(4), "description".repeat(50), "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), ErrorMessagesAPI.DESCRIPTION_LENGTH.getMessage(), 400},
                {"namenamename".repeat(5), "headerText".repeat(4), " description".repeat(100) + "Ё, Ы,Э", "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), ErrorMessagesAPI.DESCRIPTION_INVALID_CHARACTERS_EXTENDED.getMessage(), 400}
        };
    }

    @DataProvider(name = "dpAPITestEditTaskInvalidData3")
    public Object[][] dpAPITestEditTask3() {
        return new Object[][]{
                {"           ", "             ", "                 ", "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), ErrorMessagesAPI.MULTIPLE_VALIDATION_ERRORS.getMessage(), 400},
                {" namenam ".repeat(5), " headerText ".repeat(4), " description ".repeat(5), "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), ErrorMessagesAPI.NAME_BLANK.getMessage(), 400},
                {null, null, null, "/upload/test/test.png", "2024-11-03", BigInteger.valueOf(765), ErrorMessagesAPI.HEADER_AND_NAME_BLANK.getMessage(), 400},
        };
    }
}
