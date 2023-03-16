package org.ssu.edu.teachua.db.repository;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {

	private static DBManager dbManager;
	private static BasicDataSource dataSource = new BasicDataSource();

	private DBManager() {
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://185.156.43.101:5432/su_dev_2");
		dataSource.setUsername("su_teachua_test");
		dataSource.setPassword("jKsUjok57JsqLk9k287");
		dataSource.setMaxIdle(30);
		dataSource.setMaxTotal(1000);
		dataSource.setMaxWaitMillis(10000);
		dataSource.setDefaultAutoCommit(true);
	}

	public static synchronized DBManager getInstance() {
		if (dbManager == null) {
			dbManager = new DBManager();
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
