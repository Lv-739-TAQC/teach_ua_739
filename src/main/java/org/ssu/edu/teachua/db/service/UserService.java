package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.User;

import java.util.List;

import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.DBManager;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.UserDAOImpl;

public class UserService extends BaseService {

    static final String SQL_FIND_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM users WHERE email = ? and password ?;";
    static final String SQL_FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?;";

    public UserService(String url, String username, String password) throws DBException {
        super(url, username, password);
    }

    public  List<User> getUsersByEmailAndPassword(String email, String password) throws DBException, EntityException {
        return new UserDAOImpl().findElementsBySQlRequest(
                con, SQL_FIND_USER_BY_EMAIL_AND_PASSWORD, false, email, password
        );
    }

    public  List<User> getUsersByEmail(String email) throws DBException, EntityException {
        return new UserDAOImpl().findElementsBySQlRequest(
                con, SQL_FIND_USER_BY_EMAIL, true, email
        );
    }
}
