package org.ssu.edu.teachua.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class StringGenerator {

    public static String generateRandomString(int stringLength) {
        return RandomStringUtils.random(stringLength, true, false);
    }
}
