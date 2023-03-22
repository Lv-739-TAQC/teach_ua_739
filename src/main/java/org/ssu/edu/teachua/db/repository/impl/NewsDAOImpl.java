package org.ssu.edu.teachua.db.repository.impl;

import org.ssu.edu.teachua.db.entities.News;

import java.util.Map;
import java.util.TreeMap;

public class NewsDAOImpl extends AbstractDAOImpl<News> {

    private static final Map<String, AbstractDAOImpl> entitiesDaoImpl;

    static {
        entitiesDaoImpl = new TreeMap<>();
        entitiesDaoImpl.put("users", new UserDAOImpl());
    }

    public NewsDAOImpl() {
        super(News.class, entitiesDaoImpl);
    }
}