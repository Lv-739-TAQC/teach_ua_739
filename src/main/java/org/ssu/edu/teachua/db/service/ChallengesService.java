package org.ssu.edu.teachua.db.service;

import io.qameta.allure.Step;
import org.ssu.edu.teachua.db.entities.Challenges;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.ChallengesDAOImpl;

import java.util.List;

public class ChallengesService extends BaseService {

    static final String SQL_FIND_CHALLENGE_BY_NAME = "SELECT * FROM challenges WHERE name = ?;";

    public ChallengesService(String url, String username, String password) throws DBException {
        super(url, username, password);
    }

    @Step("From database get challenges by id: '{id}'")
    public Challenges getChallengeById(Integer id) throws DBException, EntityException {
        return new ChallengesDAOImpl().findElementById(connection, id, true);
    }

    @Step("From database get challenges by name: '{name}'")
    public List<Challenges> getChallengesByName(String name) throws DBException, EntityException {
        return new ChallengesDAOImpl().findElementsBySQlRequest(
                connection, SQL_FIND_CHALLENGE_BY_NAME, true, name
        );
    }
}
