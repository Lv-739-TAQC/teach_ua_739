package org.ssu.edu.teachua.db.repository;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {

	private static DBManager dbManager;
	private static BasicDataSource dataSource = new BasicDataSource();

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

	public static synchronized DBManager getInstance(String url, String username, String password) {
		if (dbManager == null) {
			dbManager = new DBManager(url, username, password);
		}
		return dbManager;
	}

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
