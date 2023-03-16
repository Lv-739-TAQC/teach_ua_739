package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.Center;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.DBManager;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.CenterDAOImpl;

import java.util.List;

public class CenterService {

    static final String SQL_FIND_CENTER_BY_NAME = "SELECT * FROM centers WHERE name = ?;";

    public static Center getCenterById(Integer id) throws DBException, EntityException {
        return new CenterDAOImpl().findElementById(DBManager.getInstance().getConnection(), id, true);
    }

    public static List<Center> getCentersByName(String name) throws DBException, EntityException {
        return new CenterDAOImpl().findElementsBySQlRequest(
                DBManager.getInstance().getConnection(), SQL_FIND_CENTER_BY_NAME, true, name
        );
    }
}
