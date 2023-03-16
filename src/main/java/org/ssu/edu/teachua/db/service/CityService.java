package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.City;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.DBManager;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.CityDAOImpl;

import java.util.List;

public class CityService extends BaseService {

    static final String SQL_FIND_CITY_BY_NAME = "SELECT * FROM cities WHERE name = ?;";

    public List<City> getCities() throws DBException, EntityException {
        return new CityDAOImpl().findAll(DBManager.getInstance().getConnection(), false);
    }

    public List<City> getCitiesByName(String name) throws DBException, EntityException {
        return new CityDAOImpl().findElementsBySQlRequest(
                DBManager.getInstance().getConnection(), SQL_FIND_CITY_BY_NAME, true, name
        );
    }
}
