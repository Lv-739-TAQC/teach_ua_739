package org.ssu.edu.teachua.db.service;

import org.ssu.edu.teachua.db.entities.Challenges;
import org.ssu.edu.teachua.db.entities.Role;
import org.ssu.edu.teachua.db.entities.User;
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
    }
}
