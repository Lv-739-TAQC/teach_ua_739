package org.ssu.edu.teachua.db.repository.impl;

import org.ssu.edu.teachua.db.entities.Club;

import java.util.Map;
import java.util.TreeMap;

public class ClubsCategoryDAOImpl extends AbstractDAOImpl<Club> {
    private static final Map<String, AbstractDAOImpl> entitiesDaoImpl;

    static {
        entitiesDaoImpl = new TreeMap<>();
        entitiesDaoImpl.put("categories", new CategoryDAOImpl());
    }

    public ClubsCategoryDAOImpl() {
        super(Club.class, entitiesDaoImpl);
    }
}
