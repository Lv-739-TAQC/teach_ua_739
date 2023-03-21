package org.ssu.edu.teachua.db.service;

import io.qameta.allure.Step;
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

    @Step("From database get centers by id: '{id}'")
    public Center getCenterById(Integer id) {
        Center center = null;
        try {
            center = new CenterDAOImpl().findElementById(connection, id, true);
        } catch (DBException | EntityException e) {
            System.out.println(e.getMessage());
        }
        return center;
    }

    @Step("From database get centers by name: '{name}'")
    public List<Center> getCentersByName(String name) {
        List<Center> centerList = null;
        try {
            centerList = new CenterDAOImpl().findElementsBySQlRequest(
                    connection, SQL_FIND_CENTER_BY_NAME, true, name
            );
        } catch (DBException | EntityException e) {
            System.out.println(e.getMessage());
        }
        return centerList;
    }

    @Step("From database get centers sorted by rating in ascending order")
    public List<Center> getCentresSortedByNameAsc(boolean isAsc) throws DBException, EntityException{
        return new CenterDAOImpl().findElementsBySQlRequest(
                connection, SQL_FIND_CENTER_BY_NAME_ASC, true
        );
    }

    @Step("From database get centers sorted by rating in descending order")
    public List<Center> getCentresSortedByNameDesc(boolean isDesc) throws DBException, EntityException{
        return new CenterDAOImpl().findElementsBySQlRequest(
                connection, SQL_FIND_CENTER_BY_NAME_DESC, true
        );
    }
}
