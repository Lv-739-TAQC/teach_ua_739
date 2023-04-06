package org.ssu.edu.teachua.db.repository;

/**
 * The exception thrown when a wrongly work with entity.
 * @author Kapustin Illia
 */
public class EntityException extends Exception {
	/**
	 * Constructs an EntityException with the specified detail message and reference info.
	 * @param message name entity where exception occurred 
	 * @param cause Parent exception 
	 */
    public EntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
