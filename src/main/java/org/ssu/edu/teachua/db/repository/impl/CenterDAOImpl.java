package org.ssu.edu.teachua.db.repository.impl;


import org.ssu.edu.teachua.db.entities.Center;

import java.util.Map;
import java.util.TreeMap;

public class CenterDAOImpl extends AbstractDAOImpl<Center> {

    private static final Map<String, AbstractDAOImpl> entitiesDaoImpl;

    static {
        entitiesDaoImpl = new TreeMap<>();
        entitiesDaoImpl.put("users", new UserDAOImpl());
    }

    public CenterDAOImpl() {
        super(Center.class, entitiesDaoImpl);
    }

}
