package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.Station;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.StationDAOImpl;

import java.util.List;

public class StationService extends BaseService {
    static final String SQL_FIND_STATION_BY_NAME = "SELECT * FROM stations WHERE name = ?;";

    public StationService(String url, String username, String password) throws DBException {
        super(url, username, password);
    }

    public List<Station> getStationByName(String name) throws DBException, EntityException {
        return new StationDAOImpl().findElementsBySQlRequest(
                connection, SQL_FIND_STATION_BY_NAME, true, name
        );
    }
}
