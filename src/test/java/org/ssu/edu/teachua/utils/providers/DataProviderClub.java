package org.ssu.edu.teachua.utils.providers;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

public class DataProviderClub {

    public static final List<String> ERROR_MSG = Arrays.asList(
            "Опис гуртка задовгий",
            "Опис гуртка не може містити російські літери",
            "Некоректний опис гуртка\nОпис гуртка не може містити російські літери",
            "Некоректний опис гуртка\nОпис гуртка може містити від 40 до 1500 символів."
    );

    @DataProvider(name = "dpTestDescriptionFieldValid")
    public static Object[][] dpTestDescriptionFieldValid() {
        return new Object[][]{
                // These data is used in Maksym's test cases :
                {"club1.1", 0, "10", "15", "1212121212", ("some data;").repeat(150)},
                {"club1.2", 6, "9", "14", "1313131313", ("text;").repeat(300)},
                {"club1.3", 12, "15", "18", "2323232323", ("new test data ;").repeat(100)},
                {"club1.4", 3, "11", "18", "2525252525", ("some text;").repeat(5)},
                {"club1.5", 9, "8", "13", "1717171717", ("club description;").repeat(3)},
                // These data is used in Anna's test cases :
                {"Speaking club", 2, "6", "16", "0674443322", ("text").repeat(250)},
                {"Speaking club", 2, "6", "16", "0674443322", "Lorem ipsum dolor sit amet, consectetur adips"},
                {"Speaking club", 2, "6", "16", "0674443322", ("hello").repeat(300)},
                {"Speaking club", 2, "6", "16", "0674443322",
                        "Гурток Speaking club спрямований на розвиток мовленнєвих навичок для дітей віком від 6 і до 16 років"},
                {"Speaking club", 2, "6", "16", "0674443322", "1234567890123456789012345678901234567890"},
                {"Speaking club", 2, "6", "16", "0674443322", "!#$%&'()*+,-./:;<=>?@[]^_`{}~!#$%&'()*+,-./:;<=>?@[]^_`{}~"}
        };
    }

    @DataProvider(name = "dpTestDescriptionFieldInvalid")
    public static Object[][] dpTestDescriptionFieldInvalid() {
        return new Object[][]{
                // These data is used in Maksym's test cases :
                {"club2.1", 1, "12", "16", "1212121212", (("text;").repeat(300) + "!"), ERROR_MSG.get(0)},
                {"club2.2", 7, "10", "16", "1313131313", ("new test data ;").repeat(120), ERROR_MSG.get(0)},
                {"club2.3", 9, "15", "18", "2323232323", ("запрещенные слова;").repeat(3), ERROR_MSG.get(1)},
                {"club2.4", 2, "11", "18", "2525252525", ("эъüöäЫэъüöä").repeat(5), ERROR_MSG.get(2)},
                {"club2.5", 10, "8", "15", "1717171717", ("Aussätzige|Прокаженные").repeat(2), ERROR_MSG.get(2)},
                // These data is used in Anna's test cases :
                {"Speaking club", 2, "6", "16", "0674443322", "Lorem ipsum dolor si", ERROR_MSG.get(3)},
                {"Speaking club", 2, "6", "16", "0674443322", "1", ERROR_MSG.get(3)},
                {"Speaking club", 2, "6", "16", "0674443322", "Lorem ipsum dolor sit amet, consectetur", ERROR_MSG.get(3)}
        };
    }

    @DataProvider(name = "dpTestAllFieldsValidCenter")
    public static Object[][] dpTestAllFieldsValidCenter() {
        return new Object[][]{
                {"Test club name", 1, "3", "6", 2, "0667778899", "Lorem ipsum dolor sit amet, consectetur adips"}
        };
    }

    @DataProvider(name = "dpTestAddLocationForClub")
    public static Object[][] dpTestAddLocationForClub() {
        return new Object[][]{
                {"Hurtok3210", 2, "3", "15", "LocationTest123", "Харків", "Київський", "Ivana Krylova",
                "49.829104498711104, 24.005058710351314", "0123456789", "0123456789", "description".repeat(5),
                "City(latitude=49.9935, longitude=36.2304, name=Харків)"}
        };
    }
}
