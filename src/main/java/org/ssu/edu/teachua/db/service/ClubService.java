package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.Club;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.ClubDAOImpl;

import java.util.List;

public class ClubService extends BaseService {

    static final String SQL_FIND_CLUB_BY_NAME = "SELECT * FROM clubs WHERE name = ?;";
    static final String SQL_FIND_CLUB_BY_CITY = "SELECT * FROM clubs as cl JOIN locations l ON cl.id = l.club_id JOIN cities ct ON l.city_id = ct.id WHERE ct.name = ?;";
    static final String SQL_FIND_CLUB_NAME_BY_PREFIX = "SELECT * FROM clubs WHERE name like ?;";
    static final String SQL_FIND_CLUB_NAME_AND_RATING_SORTED_BY_RATING = "SELECT name, rating FROM clubs WHERE id IN (SELECT DISTINCT club_category.club_id FROM club_category) ORDER BY rating ?, id;";

    public ClubService(String url, String username, String password) throws DBException {
        super(url, username, password);
    }

    public Club getClubsById(Integer id) throws DBException, EntityException {
        return new ClubDAOImpl().findElementById(connection, id, true);
    }

    public List<Club> getClubsByName(String name) throws DBException, EntityException {
        return new ClubDAOImpl().findElementsBySQlRequest(connection, SQL_FIND_CLUB_BY_NAME, true, name);
    }

    public List<Club> getNameOfClubByCity(String location) throws DBException, EntityException {
        return new ClubDAOImpl().findElementsBySQlRequest(connection, SQL_FIND_CLUB_BY_CITY, true, location);
    }

    public List<Club> getNameOfClubByPrefix(String name) throws DBException, EntityException {
        return new ClubDAOImpl().findElementsBySQlRequest(connection, SQL_FIND_CLUB_NAME_BY_PREFIX, true, name);
    }

    public List<Club> getNameAndRatingOfClubSortedByRating(String sortOrder) throws DBException, EntityException {
        return new ClubDAOImpl().findElementsBySQlRequest(connection, SQL_FIND_CLUB_NAME_AND_RATING_SORTED_BY_RATING, true, sortOrder);
    }
}
