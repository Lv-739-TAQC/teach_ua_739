package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.Station;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.DBManager;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.StationDAOImpl;

import java.util.List;

public class StationService {
    static final String SQL_FIND_STATION_BY_NAME = "SELECT * FROM stations WHERE name = ?;";

    public static List<Station> getStationByName(String name) throws DBException, EntityException {
        return new StationDAOImpl().findElementsBySQlRequest(
                DBManager.getInstance().getConnection(), SQL_FIND_STATION_BY_NAME, true, name
        );
    }
}
