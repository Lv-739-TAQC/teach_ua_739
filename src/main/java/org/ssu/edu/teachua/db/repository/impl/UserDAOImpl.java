package org.ssu.edu.teachua.db.repository.impl;

import java.util.Map;
import java.util.TreeMap;

import org.ssu.edu.teachua.db.entities.Role;
import org.ssu.edu.teachua.db.entities.User;

public class UserDAOImpl extends AbstractDAOImpl<User> {

    private static final Map<String, AbstractDAOImpl> entitiesDaoImpl;

    static {
        entitiesDaoImpl = new TreeMap<>();
        entitiesDaoImpl.put("roles", new RoleDAOImpl());
    }

    public UserDAOImpl() {
        super(User.class, entitiesDaoImpl);
    }
}
