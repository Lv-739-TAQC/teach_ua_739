package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.Category;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.CategoryDAOImpl;

import java.util.List;

public class CategoryService extends BaseService {

    static final String SQL_FIND_CATEGORY_BY_NAME = "SELECT * FROM categories WHERE name = ?;";

    public CategoryService(String url, String username, String password) throws DBException {
        super(url, username, password);
    }

    public Category getCategoryById(Integer id) throws DBException, EntityException {
        return new CategoryDAOImpl().findElementById(con, id, true);
    }

    public List<Category> getCategoryByName(String name) throws DBException, EntityException {
        return new CategoryDAOImpl().findElementsBySQlRequest(
                con, SQL_FIND_CATEGORY_BY_NAME, true, name
        );
    }
}

