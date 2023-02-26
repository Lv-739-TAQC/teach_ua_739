package org.ssu.edu.teachua.ui.utils;

public class NumberGenerator {

    public static int generateRandomNumber() {
        return (int) ((Math.random() * (10000 - 1)) + 1);
    }
}
