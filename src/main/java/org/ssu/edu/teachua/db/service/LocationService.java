package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.Location;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.LocationDAOImpl;

import java.util.List;

public class LocationService extends BaseService {
    static final String SQL_FIND_LOCATION_BY_NAME = "SELECT * FROM locations WHERE name = ?;";

    public LocationService(String url, String username, String password) throws DBException {
        super(url, username, password);
    }

    public List<Location> getLocationByName(String name) throws DBException, EntityException {
        return new LocationDAOImpl().findElementsBySQlRequest(
                connection, SQL_FIND_LOCATION_BY_NAME, true, name
        );
    }
}