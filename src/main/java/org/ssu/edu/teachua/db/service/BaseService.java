package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.DBManager;

import java.sql.Connection;

public abstract class BaseService {
    protected Connection con;

    public BaseService(String url, String username, String password) throws DBException {
        this.con = DBManager.getInstance(url, username, password).getConnection();
    }
}
