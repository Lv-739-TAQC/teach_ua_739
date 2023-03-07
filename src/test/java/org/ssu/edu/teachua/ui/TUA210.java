package org.ssu.edu.teachua.ui;

import org.ssu.edu.teachua.ui.components.search.AdvancedSearchClubComponent;
import org.ssu.edu.teachua.ui.pages.home.HomePage;
import org.ssu.edu.teachua.ui.runners.TestRunnerUI;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Arrays;
import java.util.List;

public class TUA210 extends TestRunnerUI {
    private static final List<String> INVALID_AGE = Arrays.asList(
            "1",
            "19");
    private static final List<String> VALID_AGE = Arrays.asList(
            "2",
            "18");
    private static final String MIN_AGE = "2";
    private static final String MAX_AGE = "18";


    @Test
    public void testTUA210() {
        SoftAssert softAssert = new SoftAssert();
        AdvancedSearchClubComponent advancedSearchClubComponent = new HomePage(driver)
                .clickAdvancedSearchIcon();

        String actualAgeFirst = advancedSearchClubComponent
                .setAge(INVALID_AGE.get(0))
                .getAge();
        softAssert.assertEquals(actualAgeFirst, MIN_AGE, "Age has not been set correctly");

        String actualAgeSecond = advancedSearchClubComponent
                .setAge(VALID_AGE.get(0))
                .getAge();
        softAssert.assertEquals(actualAgeSecond, MIN_AGE, "Age has not been set correctly");

        String actualAgeThird = advancedSearchClubComponent
                .setAge(VALID_AGE.get(1))
                .getAge();
        softAssert.assertEquals(actualAgeThird, MAX_AGE, "Age has not been set correctly");

        String actualAgeFourth = advancedSearchClubComponent
                .setAge(INVALID_AGE.get(1))
                .getAge();
        softAssert.assertEquals(actualAgeFourth, MAX_AGE, "Age has not been set correctly");

        softAssert.assertAll();
    }
}

