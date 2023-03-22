package org.ssu.edu.teachua.db.service;

import io.qameta.allure.Step;
import org.ssu.edu.teachua.db.entities.News;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.NewsDAOImpl;


public class NewsService extends BaseService {
    static final String SQL_FIND_CHALLENGE_BY_URL_TITLE_LOGO = "SELECT * FROM news WHERE url_title_logo LIKE ? ORDER BY ID DESC LIMIT 1;";

    public NewsService(String url, String username, String password) throws DBException {
        super(url, username, password);
    }
    @Step("From database get news by id: '{id}'")
    public News getNewsById(Integer id) throws DBException, EntityException {
        return new NewsDAOImpl().findElementById(connection, id, true);
    }
    @Step("From database get news by url title logo: '{urlTitleLogo}'")
    public News getNewsByURLTitleLogo(String urlTitleLogo) throws DBException, EntityException {
        return new NewsDAOImpl().findElementsBySQlRequest(connection, SQL_FIND_CHALLENGE_BY_URL_TITLE_LOGO, true, "/upload/news/" + urlTitleLogo).get(0);
    }
}
