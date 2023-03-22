package org.ssu.edu.teachua.utils;

import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.*;

public class EntityService {

    private final TestValueProvider dbValueProvider = new TestValueProvider();
    private final String dbUrl = dbValueProvider.getDbUrl(),
            dbName = dbValueProvider.getDbUserName(),
            dbPassword = dbValueProvider.getUDbUserPassword();

    public TaskService getTaskService() {
        TaskService taskService = null;
        try {
            taskService = new TaskService(dbUrl, dbName, dbPassword);
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
        return taskService;
    }

    public CenterService getCenterService() {
        CenterService centerService = null;
        try {
            centerService = new CenterService(dbUrl, dbName, dbPassword);
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
        return centerService;
    }

    public ClubService getClubService() {
        ClubService clubService = null;
        try {
            clubService = new ClubService(dbUrl, dbName, dbPassword);
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
        return clubService;
    }
    public ChallengesService getChallengeService() {
        ChallengesService challengesService = null;
        try {
            challengesService = new ChallengesService(dbUrl, dbName, dbPassword);
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
        return challengesService;
    }
    public NewsService getNewsService() {
        NewsService newsService = null;
        try {
            newsService = new NewsService(dbUrl, dbName, dbPassword);
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
        return newsService;
    }
}
