package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.Challenges;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.DBManager;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.ChallengesDAOImpl;

import java.util.List;

public class ChallengesService {

    static final String SQL_FIND_CHALLENGE_BY_NAME = "SELECT * FROM challenges WHERE name = ?;";

    public static Challenges getChallengeById(Integer id) throws DBException, EntityException {
        return new ChallengesDAOImpl().findElementById(DBManager.getInstance().getConnection(), id, true);
    }

    public static List<Challenges> getChallengesByName(String name) throws DBException, EntityException {
        return new ChallengesDAOImpl().findElementsBySQlRequest(
                DBManager.getInstance().getConnection(), SQL_FIND_CHALLENGE_BY_NAME, true, name
        );
    }
}
