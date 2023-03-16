package org.ssu.edu.teachua.db.repository.impl;

import org.ssu.edu.teachua.db.entities.Challenges;

import java.util.Map;
import java.util.TreeMap;

public class ChallengesDAOImpl extends AbstractDAOImpl<Challenges> {

    private static final Map<String, AbstractDAOImpl> entitiesDaoImpl;

    static {
        entitiesDaoImpl = new TreeMap<>();
        entitiesDaoImpl.put("users", new UserDAOImpl());
    }

    public ChallengesDAOImpl() {
        super(Challenges.class, entitiesDaoImpl);
    }
}
