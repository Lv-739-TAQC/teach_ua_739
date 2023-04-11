package org.ssu.edu.teachua.utils;

public enum ErrorMessagesUI {
    TITLE_CANNOT_BE_EMPTY("Поле 'Заголовок' не може бути пустим"),
    TITLE_CAN_ONLY_CONTAIN_LETTERS_DIGITS_SPECIAL_CHARS("Поле 'Заголовок' може містити тільки українські та англійські літери, цифри та спеціальні символи"),
    TITLE_CAN_CONTAIN_MIN_40_MAX_3000_CHARS("Поле 'Заголовок' може містити мінімум 40 максимум 3000 символів"),
    NAME_CANNOT_BE_EMPTY("Поле 'Назва' не може бути пустим"),
    NAME_CAN_ONLY_CONTAIN_LETTERS_DIGITS_SPECIAL_CHARS("Поле 'Назва' може містити тільки українські та англійські літери, цифри та спеціальні символи"),
    NAME_CAN_CONTAIN_MIN_5_MAX_50_CHARS("Поле 'Назва' може містити мінімум 5 максимум 50 символів"),
    DESCRIPTION_CANNOT_BE_EMPTY("Поле 'Опис' не може бути пустим"),
    DESCRIPTION_CAN_ONLY_CONTAIN_LETTERS_DIGITS_SPECIAL_CHARS("Поле 'Опис' може містити тільки українські та англійські літери, цифри та спеціальні символи"),
    DESCRIPTION_CAN_CONTAIN_MIN_40_MAX_3000_CHARS("Поле 'Опис' може містити мінімум 40 максимум 3000 символів");

    private String message;

    ErrorMessagesUI(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
