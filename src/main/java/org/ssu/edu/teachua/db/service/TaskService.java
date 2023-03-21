package org.ssu.edu.teachua.db.service;

import io.qameta.allure.Step;
import org.ssu.edu.teachua.db.entities.Task;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.repository.impl.TaskDAOImpl;

import java.util.List;

public class TaskService extends BaseService {

    static final String SQL_FIND_TASK_BY_NAME = "SELECT * FROM tasks WHERE name = ?;";
    static final String SQL_FIND_TASK_BY_DESCRIPTION = "SELECT * FROM tasks WHERE description = ?;";

    public TaskService(String url, String username, String password) throws DBException {
        super(url, username, password);
    }

    @Step("From database get tasks by id: '{id}'")
    public Task getTaskById(Integer id) {
        Task task = null;
        try {
            task = new TaskDAOImpl().findElementById(connection, id, true);
        } catch (DBException | EntityException e) {
            System.out.println(e.getMessage());
        }
        return task;
    }

    @Step("From database get tasks by name: '{name}'")
    public List<Task> getTasksByName(String name) {
        List<Task> taskList = null;
        try {
            taskList = new TaskDAOImpl().findElementsBySQlRequest(
                    connection, SQL_FIND_TASK_BY_NAME, true, name
            );
        } catch (DBException | EntityException e) {
            System.out.println(e.getMessage());
        }
        return taskList;
    }

    @Step("From database get tasks by description: '{description}'")
    public List<Task> getTasksByDescription(String description) {
        List<Task> taskList = null;
        try {
            taskList = new TaskDAOImpl().findElementsBySQlRequest(
                    connection, SQL_FIND_TASK_BY_DESCRIPTION, true, description
            );
        } catch (DBException | EntityException e) {
            System.out.println(e.getMessage());
        }
        return taskList;
    }
}
