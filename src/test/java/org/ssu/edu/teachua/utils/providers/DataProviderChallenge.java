package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class DataProviderChallenge {
    @DataProvider(name = "dpTestErrorMessageChallengeNameField")
    public Object[][] dpTestErrorMessageChallengeNameField() {
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
    public Object[][] dpTestCompressAndUploadPhoto() {
        return new Object[][]{
                {"photos/image.png"}
        };
    }
}
