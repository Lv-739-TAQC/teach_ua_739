package org.ssu.edu.teachua.db.repository.impl;

import org.ssu.edu.teachua.db.entities.Category;

import java.util.Map;
import java.util.TreeMap;

public class CategoryDAOImpl extends AbstractDAOImpl<Category> {

    private static final Map<String, AbstractDAOImpl> entitiesDaoImpl;

    static {
        entitiesDaoImpl = new TreeMap<>();
        entitiesDaoImpl.put("clubs", new ClubsCategoryDAOImpl());
    }

    public CategoryDAOImpl() {
        super(Category.class, entitiesDaoImpl);
    }
}

