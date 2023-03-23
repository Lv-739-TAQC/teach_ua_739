package org.ssu.edu.teachua.db.repository;


/**
 * The exception thrown when a wrongly work with database.
 * @author Kapustin Illia
 */
public class DBException extends Exception {
	/**
	 * Constructs an DBException with the specified detail message and reference info.
	 * @param message name table or query where exception occurred
	 * @param cause Parent exception 
	 */
    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}
