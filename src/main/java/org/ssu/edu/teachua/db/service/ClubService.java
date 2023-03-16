package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.Club;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.DBManager;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.ClubDAOImpl;

import java.util.List;

public class ClubService extends BaseService {

    static final String SQL_FIND_CLUB_BY_NAME = "SELECT * FROM clubs WHERE name = ?;";

    public ClubService(String url, String username, String password) throws DBException {
        super(url, username, password);
    }

    public Club getClubsById(Integer id) throws DBException, EntityException {
        return new ClubDAOImpl().findElementById(con, id, true);
    }

    public List<Club> getClubsByName(String name) throws DBException, EntityException {
        return new ClubDAOImpl().findElementsBySQlRequest(con, SQL_FIND_CLUB_BY_NAME, true, name);
    }
}
