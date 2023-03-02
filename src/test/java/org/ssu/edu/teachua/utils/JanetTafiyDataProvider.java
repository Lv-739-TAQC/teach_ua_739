package org.ssu.edu.teachua.utils;

import org.testng.annotations.DataProvider;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JanetTafiyDataProvider {

    @DataProvider(name = "registrationData")
    public static Object[][] registrationFormData() {
        return new Object[][] {
                {"Вайтович", "Світлана", "671234567", "svitlanawhite@gmail.com", "12345678", "12345678"},
        };

    }
    @DataProvider(name = "challengeData")
    public static Object[][] getChallengeData() {
        long timestamp = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        String sortNumber = dateFormat.format(new Date(timestamp));
        return new Object[][] {
                {sortNumber, "heart.png", "Example23_Приклад", "Example:78Приклад", "ExamplePOIUQ*$%91!;?*(0_,/ЇЄПриклад~+=-"}
        };
    }



}