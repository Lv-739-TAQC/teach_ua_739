package org.ssu.edu.teachua.db.repository.impl;

import org.ssu.edu.teachua.db.entities.City;

import java.util.Map;
import java.util.TreeMap;

public class CitiesDAOImpl extends AbstractDAOImpl<City> {

    private static final Map<String, AbstractDAOImpl> entitiesDaoImpl;

    static {
        entitiesDaoImpl = new TreeMap<>();
    }

    public CitiesDAOImpl() {
        super(City.class, entitiesDaoImpl);
    }
}
