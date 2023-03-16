package org.ssu.edu.teachua.db.repository.impl;

import org.ssu.edu.teachua.db.entities.Location;

import java.util.Map;
import java.util.TreeMap;

public class LocationDAOImpl extends AbstractDAOImpl<Location> {
    private static final Map<String, AbstractDAOImpl> entitiesDaoImpl;

    static {
        entitiesDaoImpl = new TreeMap<>();
        entitiesDaoImpl.put("stations", new StationDAOImpl());
        entitiesDaoImpl.put("clubs", new ClubDAOImpl());
        entitiesDaoImpl.put("centers", new CenterDAOImpl());
        entitiesDaoImpl.put("cities", new CityDAOImpl());
        entitiesDaoImpl.put("districts", new DistrictDAOImpl());
    }

    public LocationDAOImpl() {
        super(Location.class, entitiesDaoImpl);
    }
}
