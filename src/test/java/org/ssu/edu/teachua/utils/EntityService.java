package org.ssu.edu.teachua.utils;

import org.ssu.edu.teachua.db.entities.Location;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.CenterService;
import org.ssu.edu.teachua.db.service.ClubService;
import org.ssu.edu.teachua.db.service.LocationService;
import org.ssu.edu.teachua.db.service.TaskService;

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

    public LocationService getLocationService() {
        LocationService locationService = null;
        try {
            locationService = new LocationService(dbUrl, dbName, dbPassword);
        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
        return locationService;
    }
}
