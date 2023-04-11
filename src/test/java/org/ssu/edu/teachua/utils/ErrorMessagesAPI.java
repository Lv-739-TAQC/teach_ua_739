package org.ssu.edu.teachua.utils;


public enum ErrorMessagesAPI {
    NAME_LENGTH("name must contain a minimum of 5 and a maximum of 50 letters"),
    NAME_INVALID_CHARACTERS("name Помилка. Текст містить недопустимі символи"),
    DESCRIPTION_LENGTH("description must contain a minimum of 40 and a maximum of 3000 letters"),
    DESCRIPTION_INVALID_CHARACTERS("description Помилка. Текст містить недопустимі символи"),
    NAME_BLANK("name must not be blank"),
    DESCRIPTION_AND_NAME_LENGTH("description must contain a maximum of 3000 letters and name must not be blank and name must contain a minimum of 5 and a maximum of 50 letters"),
    NAME_LENGTH_EXTENDED("name must contain a minimum of 5 and a maximum of 255 letters"),
    DESCRIPTION_INVALID_CHARACTERS_EXTENDED("description Помилка. Текст містить недопустимі символи"),
    MULTIPLE_VALIDATION_ERRORS("name must not be blank|description must contain a maximum of 10000 letters|name must contain a minimum of 5 and a maximum of 255 letters|headerText must not be blank|headerText must contain a minimum of 40 and a maximum of 10000 letters"),
    HEADER_AND_NAME_BLANK("headerText must not be blank|name must not be blank");

    private final String message;

    ErrorMessagesAPI(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
