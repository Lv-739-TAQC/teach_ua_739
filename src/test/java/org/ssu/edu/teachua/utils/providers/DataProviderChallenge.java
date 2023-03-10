package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DataProviderChallenge {
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

    @DataProvider(name = "challengeData")
    public static Object[][] getChallengeData() {
        long timestamp = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        String sortNumber = dateFormat.format(new Date(timestamp));
        return new Object[][]{
                {sortNumber, "photos/heart.png", "Example23_Приклад", "Example:78Приклад", "ExamplePOIUQ*$%91!;?*(0_,/ЇЄПриклад~+=-"}
        };
    }
}
