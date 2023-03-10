package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

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

    @DataProvider(name = "dpTestEmptySortNumber")
    public  Object[][] dpTestEmptySortNumber() {
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
    public Object[][] dpTestInvalidValueNameField() {
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
    public Object[][] dpTestValidValueNameField() {
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

}
