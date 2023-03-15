package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.User;

import java.util.List;

import org.ssu.edu.teachua.db.entities.Role;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.DBManager;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.RoleDAOImpl;
import org.ssu.edu.teachua.db.repository.impl.UserDAOImpl;

public class UserService {
	static final String SQL_FIND_USER_BY_EMAIL_AND_PASSWORD = "select * from users where email = ? and password = ?;";
    static final String SQL_FIND_USER_BY_EMAIL = "select * from users where email = ?;";

    
    public static List<User> getUsersByEmailAndPassword (String email,String password) throws DBException, EntityException{
        return new UserDAOImpl().findElementsBySQlRequest(DBManager.getInstance().getConnection(),SQL_FIND_USER_BY_EMAIL_AND_PASSWORD,false,email,password);
    }

    public static List<User> getUsersByEmail (String email) throws DBException, EntityException{
        return new UserDAOImpl().findElementsBySQlRequest(DBManager.getInstance().getConnection(),SQL_FIND_USER_BY_EMAIL,true,email);
    }

}
