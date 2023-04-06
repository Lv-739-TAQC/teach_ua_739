package org.ssu.edu.teachua.db.service;

import io.qameta.allure.Step;
import org.ssu.edu.teachua.db.entities.District;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.DistrictDAOImpl;

import java.util.List;

public class DistrictService extends BaseService {
    static final String SQL_FIND_DISTRICT_BY_NAME = "SELECT * FROM districts WHERE name = ?;";

    public DistrictService(String url, String username, String password) throws DBException {
        super(url, username, password);
    }

    @Step("From database get districts by name: '{name}'")
    public List<District> getDistrictByName(String name) throws DBException, EntityException {
        return new DistrictDAOImpl().findElementsBySQlRequest(
                connection, SQL_FIND_DISTRICT_BY_NAME, true, name
        );
    }
}
