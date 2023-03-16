package org.ssu.edu.teachua.db.repository.impl;

import org.ssu.edu.teachua.db.entities.Location;

import java.util.Map;
import java.util.TreeMap;

public class LocationDAOImpl extends AbstractDAOImpl<Location> {
    private static final Map<String, AbstractDAOImpl> entitiesDaoImpl;

    static {
        entitiesDaoImpl = new TreeMap<>();
        entitiesDaoImpl.put("locations", new LocationDAOImpl());
    }

    public LocationDAOImpl() {
        super(Location.class, entitiesDaoImpl);
    }
}
