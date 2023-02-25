package org.ssu.edu.teachua.ui.providers;

import org.testng.annotations.DataProvider;

public class AddClubComponentProvider {

    @DataProvider(name = "dpTestDescriptionFieldFirstValid")
    public static Object[][] dpTestDescriptionFieldFirstValid() {
        return new Object[][]{
                {"club1", 0, "10", "15", "1212121212", ("some data;").repeat(150)},
                {"club2", 6, "9", "14", "1313131313", ("text;").repeat(300)},
                {"club3", 12, "15", "18", "2323232323", ("new test data ;").repeat(100)},
        };
    }
}
