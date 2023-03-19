package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.Center;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.CenterDAOImpl;

import java.util.List;

public class CenterService extends BaseService {

    static final String SQL_FIND_CENTER_BY_NAME = "SELECT * FROM centers WHERE name = ?;";
    static final String SQL_FIND_CENTER_BY_NAME_ASC = "SELECT * FROM centers ORDER BY name ASC LIMIT 6;";
    static final String SQL_FIND_CENTER_BY_NAME_DESC = "SELECT * FROM centers ORDER BY name DESC LIMIT 6;";


    public CenterService(String url, String username, String password) throws DBException {
        super(url, username, password);
    }

    public Center getCenterById(Integer id) throws DBException, EntityException {
        return new CenterDAOImpl().findElementById(connection, id, true);
    }

    public List<Center> getCentersByName(String name) throws DBException, EntityException {
        return new CenterDAOImpl().findElementsBySQlRequest(
                connection, SQL_FIND_CENTER_BY_NAME, true, name
        );
    }

    public List<Center> getCentresSortedByNameAsc(boolean isAsc) throws DBException, EntityException{
        return new CenterDAOImpl().findElementsBySQlRequest(
                connection, SQL_FIND_CENTER_BY_NAME_ASC, true
        );
    }

    public List<Center> getCentresSortedByNameDesc(boolean isDesc) throws DBException, EntityException{
        return new CenterDAOImpl().findElementsBySQlRequest(
                connection, SQL_FIND_CENTER_BY_NAME_DESC, true
        );
    }
}
