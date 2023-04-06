package org.ssu.edu.teachua.db.service;

import io.qameta.allure.Step;
import org.ssu.edu.teachua.db.entities.Club;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.ClubDAOImpl;

import java.util.List;

public class ClubService extends BaseService {

    static final String SQL_FIND_CLUB_BY_NAME = "SELECT * FROM clubs WHERE name = ?;";
    static final String SQL_FIND_CLUB_BY_CITY = "SELECT * FROM clubs as cl JOIN locations l ON cl.id = l.club_id JOIN cities ct ON l.city_id = ct.id WHERE ct.name = ? LIMIT 2;";
    static final String SQL_FIND_CLUB_BY_PREFIX = "SELECT * FROM clubs WHERE name like ?;";
    static final String SQL_FIND_CLUB_SORTED_BY_RATING_ASC = "SELECT * FROM clubs WHERE id IN (SELECT DISTINCT club_category.club_id FROM club_category) ORDER BY rating ASC, id LIMIT 6;";
    static final String SQL_FIND_CLUB_SORTED_BY_RATING_DESC = "SELECT * FROM clubs WHERE id IN (SELECT DISTINCT club_category.club_id FROM club_category) ORDER BY rating DESC, id LIMIT 6;";

    public ClubService(String url, String username, String password) throws DBException {
        super(url, username, password);
    }

    @Step("From database get clubs by id: '{id}'")
    public Club getClubsById(Integer id) throws DBException, EntityException {
        return new ClubDAOImpl().findElementById(connection, id, true);
    }

    @Step("From database get clubs by name: '{name}'")

    public List<Club> getClubsByName(String name) {
        List<Club> clubs = null;
        try {
            clubs = new ClubDAOImpl().findElementsBySQlRequest(connection, SQL_FIND_CLUB_BY_NAME, true, name);
        } catch (DBException | EntityException e) {
            System.out.println(e.getMessage());
        }
        return clubs;
    }

    @Step("From database get clubs which are located in city: '{city}'")
    public List<Club> getClubsByCity(String city) throws DBException, EntityException {
        return new ClubDAOImpl().findElementsBySQlRequest(connection, SQL_FIND_CLUB_BY_CITY, true, city);
    }

    @Step("From database get clubs which name contains: '{name}'")
    public List<Club> getClubsByPrefix(String name) throws DBException, EntityException {
        return new ClubDAOImpl().findElementsBySQlRequest(connection, SQL_FIND_CLUB_BY_PREFIX, true, name);
    }

    @Step("From database get clubs sorted by rating in ascending order")
    public List<Club> getClubsSortedByRatingASC() throws DBException, EntityException {
        return new ClubDAOImpl().findElementsBySQlRequest(connection, SQL_FIND_CLUB_SORTED_BY_RATING_ASC, true);
    }

    @Step("From database get clubs sorted by rating in descending order")
    public List<Club> getClubsSortedByRatingDESC() throws DBException, EntityException {
        return new ClubDAOImpl().findElementsBySQlRequest(connection, SQL_FIND_CLUB_SORTED_BY_RATING_DESC, true);
    }
}
