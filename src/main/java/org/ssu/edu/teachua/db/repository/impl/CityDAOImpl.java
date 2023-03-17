package org.ssu.edu.teachua.db.repository.impl;

import org.ssu.edu.teachua.db.entities.City;

import java.util.Map;
import java.util.TreeMap;

public class CityDAOImpl extends AbstractDAOImpl<City> {

    private static final Map<String, AbstractDAOImpl> entitiesDaoImpl;

    static {
        entitiesDaoImpl = new TreeMap<>();
    }

    public CityDAOImpl() {
        super(City.class, entitiesDaoImpl);
    }
}
