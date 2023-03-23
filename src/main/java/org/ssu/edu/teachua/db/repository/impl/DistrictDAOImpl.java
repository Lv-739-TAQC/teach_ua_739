package org.ssu.edu.teachua.db.repository.impl;

import org.ssu.edu.teachua.db.entities.District;

import java.util.Map;
import java.util.TreeMap;

public class DistrictDAOImpl extends AbstractDAOImpl {
    private static final Map<String, AbstractDAOImpl> entitiesDaoImpl;

    static {
        entitiesDaoImpl = new TreeMap<>();
        entitiesDaoImpl.put("cities", new CityDAOImpl());
    }

    public DistrictDAOImpl() {
        super(District.class, entitiesDaoImpl);
    }
}
