package org.ssu.edu.teachua.db.repository;

public class EntityException extends Exception {
    public EntityException(String message) {
        super(message);
    }

    public EntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
