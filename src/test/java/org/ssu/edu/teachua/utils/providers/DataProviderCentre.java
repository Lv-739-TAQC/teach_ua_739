package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class DataProviderCentre {

    @DataProvider(name = "dpTestAddCenter")
    public static Object[][] dpTestAddCenter() {
        return new Object[][]{
                {"First language center", "Лівий берег", "Одеса", "Фонтан", "Приморський", "проспект Бажана, 3А",
                 "50.406108, 30.668492", "0679002233", 1, "https://www.facebook.com/1lngcenter/",
                 "https://1lngcenter/", "center@gmail.com", "1lngcenter", "+380630336789", "0503334455",
                 "photos/centerLogo.jpg", "photos/centerPhoto.jpg", "Кількість курсів, призначених для окремих вікових" +
                 "груп, залежить від суми використовуваних на сьогоднішній день грантів", 100,
                 Arrays.asList("Особистий кабінет", "Admin Admin", "АДМІНІСТРАТОР", "0689543242", "admin@gmail.com")}
        };
    }
}
