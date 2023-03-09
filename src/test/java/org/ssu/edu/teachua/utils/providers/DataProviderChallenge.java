package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class DataProviderChallenge {

    @DataProvider(name = "dpTestAddChallengeValid")
    public static Object[][] dpTestAddChallengeValid() {
        return new Object[][]{
                {"115", "name-1", "title-1", ("description-1").repeat(20),
                        "photos/image.png", "Челендж 'name-1' успішно доданий!"}
        };
    }

    @DataProvider(name = "dpTestErrorMessageChallengeNameField")
    public static Object[][] dpTestErrorMessageChallengeNameField() {
        return new Object[][]{
                {"546789",
                        "testFeb2023",
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                        "photos/image.png",
                        Arrays.asList("Дыผð*.:", "2", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", ""),
                        "rgb(255, 0, 0)",
                        Arrays.asList("Це поле може містити тільки українські та англійські літери, цифри та спеціальні символи",
                                "Назва Челенджу закоротка",
                                "Назва Челенджу задовга",
                                "Поле не повинно бути пустим")
                }
        };
    }

    @DataProvider(name = "dpTestCompressAndUploadPhoto")
    public static Object[][] dpTestCompressAndUploadPhoto() {
        return new Object[][]{
                {"photos/image.png"}
        };
    }
}
