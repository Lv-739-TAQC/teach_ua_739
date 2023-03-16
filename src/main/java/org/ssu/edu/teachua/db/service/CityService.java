package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.City;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.DBManager;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.CityDAOImpl;

import java.util.List;

public class CityService extends BaseService {

    static final String SQL_FIND_CITY_BY_NAME = "SELECT * FROM cities WHERE name = ?;";

    public CityService(String url, String username, String password) throws DBException {
        super(url, username, password);
    }

    public City getCities(Integer id) throws DBException, EntityException {
        return new CityDAOImpl().findElementById(con, id, true);
    }

    public List<City> getCitiesByName(String name) throws DBException, EntityException {
        return new CityDAOImpl().findElementsBySQlRequest(
                con, SQL_FIND_CITY_BY_NAME, true, name
        );
    }
}
