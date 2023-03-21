package org.ssu.edu.teachua.db.service;

import io.qameta.allure.Step;
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

    @Step("From database get category by id: '{id}'")
    public Category getCategoryById(Integer id) throws DBException, EntityException {
        return new CategoryDAOImpl().findElementById(connection, id, true);
    }

    @Step("From database get category by name: '{name}'")
    public List<Category> getCategoryByName(String name) throws DBException, EntityException {
        return new CategoryDAOImpl().findElementsBySQlRequest(
                connection, SQL_FIND_CATEGORY_BY_NAME, true, name
        );
    }
}

