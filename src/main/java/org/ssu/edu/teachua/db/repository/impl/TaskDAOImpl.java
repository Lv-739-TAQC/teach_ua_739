package org.ssu.edu.teachua.db.repository.impl;

import org.ssu.edu.teachua.db.entities.Task;

import java.util.Map;
import java.util.TreeMap;

public class TaskDAOImpl extends AbstractDAOImpl<Task> {

    private static final Map<String, AbstractDAOImpl> entitiesDaoImpl;

    static {
        entitiesDaoImpl = new TreeMap<>();
        entitiesDaoImpl.put("challenges", new RoleDAOImpl());
    }

    public TaskDAOImpl() {
        super(Task.class, entitiesDaoImpl);
    }
}
