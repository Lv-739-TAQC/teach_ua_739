package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.Club;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.DBManager;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.ClubDAOImpl;

import java.util.List;

public class ClubService {

    static final String SQL_FIND_CLUB_BY_NAME = "SELECT * FROM clubs WHERE name = ?;";

    public static List<Club> getClubsByName(String name) throws DBException, EntityException {
        return new ClubDAOImpl().findElementsBySQlRequest(
                DBManager.getInstance().getConnection(), SQL_FIND_CLUB_BY_NAME, true, name
        );
    }
}
