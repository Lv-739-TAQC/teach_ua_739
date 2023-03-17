package org.ssu.edu.teachua.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class StringGenerator {

    public static String generateRandomString(int stringLength) {
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(stringLength, useLetters, useNumbers);
    }
}
