package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.*;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;

public class MainTestConnection {
    public static void main(String[] args) throws DBException, EntityException {

        /*
         * Testing methods correctness (SQL-quires)
         * */

        System.out.println("\nGetting all roles : ");
        for (Role role : (new RoleService()).getRolls()) {
            System.out.println(role.getId() + " | " + role.getName());
        }

        System.out.println("\nGetting user by username : ");
        for (User user : (new UserService()).getUsersByEmail("admin@gmail.com")) {
            System.out.println(user.getEmail() + " | " + user.getRole().getName());
        }

        System.out.println("\nGet challenge by id : ");
        Challenges challenges = (new ChallengesService()).getChallengeById(623);
        System.out.println(challenges.getId() + " | " + challenges.getName());

        System.out.println("\nGetting all possible challenges by name : " +
                (new ChallengesService()).getChallengesByName("Ukrainian").size()
        );

        System.out.println("\nGet task by id : ");
        Task task = (new TaskService()).getTaskById(700);
        System.out.println(task.getId() + " | " + task.getName());

        System.out.println("\nGet tasks by name : ");
        for (Task eachTask : (new TaskService()).getTasksByName("string")) {
            System.out.println(eachTask.getId() + " | " + eachTask.getName());
        }

        System.out.println("\nGet centers by name : ");
        for (Center eachCenter : (new CenterService()).getCentersByName("Java center")) {
            System.out.println(eachCenter.getUserId() + " | " + eachCenter.getName());
        }
    }
}
