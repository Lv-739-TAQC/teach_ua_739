package org.ssu.edu.teachua.db.repository;

public class DBException extends Exception {
    public DBException(String message) {
        super(message);
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}
