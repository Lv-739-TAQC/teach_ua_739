package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.District;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.DBManager;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.DistrictDAOImpl;

import java.util.List;

public class DistrictService {
    static final String SQL_FIND_DISTRICT_BY_NAME = "SELECT * FROM districts WHERE name = ?;";

    public static List<District> getDistrictByName(String name) throws DBException, EntityException {
        return new DistrictDAOImpl().findElementsBySQlRequest(
                DBManager.getInstance().getConnection(), SQL_FIND_DISTRICT_BY_NAME, true, name
        );
    }
}
