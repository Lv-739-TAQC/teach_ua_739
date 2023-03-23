package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.DBManager;

import java.sql.Connection;
/**
 * An abstract class is the parent of all service
 * @author User
 *
 */
public abstract class BaseService {
	/**
	 * The field is connection database
	 */
    protected Connection connection;
    /**
     * Constructs an BaseService creates connection.
     * @param url full url in jdbc format
	 * @param username username for connection
	 * @param password password for connection 
     * @throws DBException
     */
    public BaseService(String url, String username, String password) throws DBException {
        this.connection = DBManager.getInstance(url, username, password).getConnection();
    }
}
