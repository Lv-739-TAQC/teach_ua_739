package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.Task;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.DBManager;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.TaskDAOImpl;

import java.util.List;

public class TaskService {

    static final String SQL_FIND_TASK_BY_NAME = "SELECT * FROM tasks WHERE name = ?;";

    public static Task getTaskById(Integer id) throws DBException, EntityException {
        return new TaskDAOImpl().findElementById(DBManager.getInstance().getConnection(), id, true);
    }

    public static List<Task> getTasksByName(String name) throws DBException, EntityException {
        return new TaskDAOImpl().findElementsBySQlRequest(
                DBManager.getInstance().getConnection(), SQL_FIND_TASK_BY_NAME, true, name
        );
    }
}
