package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.Category;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.DBManager;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.CategoryDAOImpl;


import java.util.List;

public class CategoryService {
    static final String SQL_FIND_CATEGORY_BY_NAME = "SELECT * FROM categories WHERE name = ?;";

    public static Category getCategoryById(Integer id) throws DBException, EntityException {
        return new CategoryDAOImpl().findElementById(DBManager.getInstance().getConnection(), id, true);
    }

    public static List<Category> getCategoryByName(String name) throws DBException, EntityException {
        return new CategoryDAOImpl().findElementsBySQlRequest(
                DBManager.getInstance().getConnection(), SQL_FIND_CATEGORY_BY_NAME, true, name
        );
    }
}

