package org.ssu.edu.teachua.db.repository;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * The class is responsible for communicating with the database
 * @author Kapustin Illia
 *
 */
public class DBManager {
	/**
	 * The field for realization singleton pattern
	 */
	private static DBManager dbManager;
	/**
	 * The field contains data source 
	 */
	private static BasicDataSource dataSource = new BasicDataSource();
	/**
	 * Constructs an DBManager with the specified detail url, username, password for connection .
	 * @param url full url in jdbc format
	 * @param username username for connection
	 * @param password password for connection 
	 */
	private DBManager(String url, String username, String password ) {
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setMaxIdle(30);
		dataSource.setMaxTotal(1000);
		dataSource.setMaxWaitMillis(10000);
		dataSource.setDefaultAutoCommit(true);
	}
	/**
	 * This method return only one object. According to singleton pattern.
	 * @param url full url in jdbc format
	 * @param username username for connection
	 * @param password password for connection 
	 * @return DBManager
	 */
	public static synchronized DBManager getInstance(String url, String username, String password) {
		if (dbManager == null) {
			dbManager = new DBManager(url, username, password);
		}
		return dbManager;
	}
	/**
	 * This method returns a connection using the data source.
	 * @return object class Connection
	 * @throws DBException
	 */
	public Connection getConnection() throws DBException {
		Connection cn = null;
		try {
			cn = dataSource.getConnection();
		} catch (SQLException ex) {
			throw new DBException("Can not obtain a connection", ex);
		}
		return cn;
	}
}
