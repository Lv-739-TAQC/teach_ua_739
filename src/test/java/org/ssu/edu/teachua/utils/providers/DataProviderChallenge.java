package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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

    @DataProvider(name = "dpTestEmptySortNumber")
    public static Object[][] dpTestEmptySortNumber() {
        return new Object[][]{
                {"",
                        "Челендж_99",
                        "99-й найкращий",
                        "Який-небудь опис челенджу, челенджу челенджу челенджу челенджу",
                        "photos/image.png",
                        "Поле порядковий номер не має бути пустим"
                }
        };
    }

    @DataProvider(name = "dpTestInvalidValueNameField")
    public static Object[][] dpTestInvalidValueNameField() {
        return new Object[][]{
                {"Заголовок Челенджу",
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
                        "photos/image.png",
                        Arrays.asList("писатель эссеист", "", "Історично сформовані є особливості"),
                        Arrays.asList("Це поле може містити тільки українські та англійські літери, цифри та спеціальні символи",
                                "Поле ‘Назва Челенджу’ не може бути порожнім",
                                "Назва Челенджу задовга")
                }
        };
    }

    @DataProvider(name = "dpTestValidValueNameField")
    public static Object[][] dpTestValidValueNameField() {
        return new Object[][]{
                {"Заголовок Челенджу",
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
                        "photos/image.png",
                        Arrays.asList("Українськамоваєнаймилозвучніша", "Ukrainian", "99999", "~`!@#$%^&()_=+{}[]/|:<>?"),
                        Arrays.asList("Челендж 'Українськамоваєнаймилозвучніша' успішно доданий!",
                                "Челендж 'Ukrainian' успішно доданий!",
                                "Челендж '99999' успішно доданий!",
                                "Челендж '~`!@#$%^&()_=+{}[]/|:<>?' успішно доданий!")
                }
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

    @DataProvider(name = "dpTestIfChallengeIsNotCreated")
    public static Object[][] dpTestIfChallengeNotCreated() {
        return new Object[][]{
                {"testTitle", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", null, "/upload/photos/image.png", BigInteger.valueOf(546789),
                        Arrays.asList("Дыผð*.:", "t", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.", ""),
                        Arrays.asList("Це поле може містити тільки українські та англійські літери, цифри та спеціальні символи",
                                "Назва Челенджу закоротка",
                                "Назва Челенджу задовга",
                                "Поле не повинно бути пустим"),
                        400
                }
        };
    }

    @DataProvider(name = "dpTestCreateChallengeInvalid")
    public static Object[][] dpTestCreateChallengeInvalid() {
        return new Object[][]{
                {"name", "tit", "des", null, "/upload/test/test.png", 1, 400},
                {"Lorem ipsum dolor sit amet, consect", "Lorem ipsum dolor sit amet, consect",
                        ("description").repeat(500), null, "/upload/test/test.png", 1, 400},
                {"эЭъЪыЫёЁ", "эЭъЪыЫёЁ", "эЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁ", null, "/upload/test/test.png", 1, 400}
        };
    }

    @DataProvider(name = "dpTestRussianValueNameField")
    public static Object[][] dpTestRussianValueNameField() {
        return new Object[][]{
                {"писатель эссеист", "Заголовок Челенджу",
                        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. L" +
                                "orem Ipsum has been the industry's standard dummy text ever since the 1500s",
                        null, "/upload/test/image.png", BigInteger.valueOf(1737637), 400,
                        "Це поле може містити тільки українські та англійські літери, цифри та спеціальні символи"}
        };
    }

    @DataProvider(name = "dpTestEmptySortNumberField")
    public static Object[][] dpTestEmptySortNumberField() {
        return new Object[][]{
                {"Челендж_99", "99-й найкращий",
                        "Який-небудь опис челенджу, челенджу челенджу челенджу челенджу",
                        null, "/upload/test/image.png", null, 400, "Поле порядковий номер не має бути пустим"}
        };
    }

    @DataProvider(name = "dpTestDeleteChallenge")
    public static Object[][] dpTestDeleteChallenge() {
        return new Object[][]{
                {"Challenge name", "Challenge title", ("description").repeat(10), null, "/upload/photos/image.png", BigInteger.valueOf(222), 200}
        };
    }

    @DataProvider(name = "dpTestCreateChallengeWithValidData")
    public static Object[][] TestCreateChallengeWithValidData() {
        return new Object[][]{
                {"Example name test1", "Example title test1", "Lorem ipsum dolor sit amet, consectetuer adipiscin", null, "/upload/test/test.png", BigInteger.valueOf(1), 200}
        };
    }

    @DataProvider(name = "dpTestUpdateChallengeWithValidData")
    public static Object[][] TestUpdateChallengeWithValidData() {
        return new Object[][]{
                {857, "Ukrainian", "Заголовок Челенджу", "<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</p>",
                        null, "/upload/challenges/image.png", BigInteger.valueOf(1679648262283L), true, 200}
        };
    }

    @DataProvider(name = "dpTestCreateChallengeInvalidCharacters")
    public static Object[][] dpTestCreateChallengeInvalidCharacters() {
        return new Object[][]{
                {null, BigInteger.valueOf(2), 400},
                {" ", BigInteger.valueOf(2), 400},
                {"", BigInteger.valueOf(2), 400}
        };
    }

    @DataProvider(name = "dpTestEditChallengeInvalidValues")
    public static Object[][] dpTestEditChallengeInvalidValues() {
        return new Object[][]{
                {5, "nam", "tit", "des", null, "/upload/test/test.png", 1, true, 400},
                {5, "Lorem ipsum dolor sit amet, consect", "Lorem ipsum dolor sit amet, consect",
                        ("description").repeat(500), null, "/upload/test/test.png", 1, true, 400},
                {5, "эЭъЪыЫёЁ", "эЭъЪыЫёЁ", "эЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁэЭъЪыЫёЁ", null,
                        "/upload/test/test.png", 1, true, 400}
        };
    }

    @DataProvider(name = "dpTestEditChallengeInvalidCharacters")
    public static Object[][] dpTestEditChallengeInvalidCharacters() {
        return new Object[][]{
                {5, null, 2, true, 400},
                {5, " ", 2, true, 400},
                {5, "", 2, true, 400},};
    }
}
