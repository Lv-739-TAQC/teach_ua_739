package org.ssu.edu.teachua.db.service;

import io.qameta.allure.Step;
import org.ssu.edu.teachua.db.entities.User;

import java.util.List;

import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.UserDAOImpl;

public class UserService extends BaseService {

    static final String SQL_FIND_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM users WHERE email = ? and password ?;";
    static final String SQL_FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?;";

    public UserService(String url, String username, String password) throws DBException {
        super(url, username, password);
    }

    @Step("From database get users by email & password: '{email}', {password}")
    public List<User> getUsersByEmailAndPassword(String email, String password) throws DBException, EntityException {
        return new UserDAOImpl().findElementsBySQlRequest(
                connection, SQL_FIND_USER_BY_EMAIL_AND_PASSWORD, false, email, password
        );
    }

    @Step("From database get users by email: '{email}'")
    public List<User> getUsersByEmail(String email) throws DBException, EntityException {
        return new UserDAOImpl().findElementsBySQlRequest(
                connection, SQL_FIND_USER_BY_EMAIL, true, email
        );
    }
}
