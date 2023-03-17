package org.ssu.edu.teachua.db.service;

import java.util.List;

import org.ssu.edu.teachua.db.entities.Role;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.RoleDAOImpl;

public class RoleService extends BaseService {
    public RoleService(String url, String username, String password) throws DBException {
        super(url, username, password);
    }

    public List<Role> getRolls() throws DBException, EntityException {
        return new RoleDAOImpl().findAll(connection, false);
    }
}
