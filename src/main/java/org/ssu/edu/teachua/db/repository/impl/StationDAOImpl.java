package org.ssu.edu.teachua.db.repository.impl;

import org.ssu.edu.teachua.db.entities.Location;
import org.ssu.edu.teachua.db.entities.Station;

import java.util.Map;
import java.util.TreeMap;

public class StationDAOImpl extends AbstractDAOImpl {
    private static final Map<String, AbstractDAOImpl> entitiesDaoImpl;

    static {
        entitiesDaoImpl = new TreeMap<>();
        entitiesDaoImpl.put("cities", new CityDAOImpl());
        entitiesDaoImpl.put("districts", new DistrictDAOImpl());
    }

    public StationDAOImpl() {
        super(Station.class, entitiesDaoImpl);
    }
}
