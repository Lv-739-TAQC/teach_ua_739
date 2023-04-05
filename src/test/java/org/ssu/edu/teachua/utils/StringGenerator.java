package org.ssu.edu.teachua.utils;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class StringGenerator {

    protected static Random randomData = new Random();

    public static String generateRandomString(int stringLength) {
        return RandomStringUtils.random(stringLength, true, false);
    }

    public static String randomPhoneNumber() {
        return String.format("067%07d", randomData.nextInt(100_000_00));
    }

    public static String randomName() {
        StringBuilder randomLetters = new StringBuilder();
        char firstLetter = (char) (randomData.nextInt(26) + 'A');
        randomLetters.append(firstLetter);
        for (int i = 1; i < 5; i++) {
            char letter = (char) (randomData.nextInt(26) + 'a');
            randomLetters.append(letter);
        } return randomLetters.toString();
    }

}
