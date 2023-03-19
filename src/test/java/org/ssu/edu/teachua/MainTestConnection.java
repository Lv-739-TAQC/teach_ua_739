package org.ssu.edu.teachua;

import org.ssu.edu.teachua.db.entities.Location;
import org.ssu.edu.teachua.db.entities.Role;
import org.ssu.edu.teachua.db.entities.User;
import org.ssu.edu.teachua.db.entities.*;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;
import org.ssu.edu.teachua.db.service.*;
import org.ssu.edu.teachua.utils.TestValueProvider;

public class MainTestConnection {

    public static void main(String[] args) throws DBException, EntityException {

        /*
         * Testing methods correctness (SQL-quires)
         * */

        TestValueProvider valueProvider = new TestValueProvider();

        String url = valueProvider.getDbUrl();
        String username = valueProvider.getDbUserName();
        String password = valueProvider.getUDbUserPassword();

        // Users and Roles :
        System.out.println("\nGetting all roles : ");
        for (Role role : new RoleService(url, username, password).getRolls()) {
            System.out.println(role.getId() + " | " + role.getName());
        }

        System.out.println("\nGetting user by username : ");
        for (User user : (new UserService(url, username, password)).getUsersByEmail("admin@gmail.com")) {
            System.out.println(user.getEmail() + " | " + user.getRole().getName());
        }

        // Challenges :
        System.out.println("\nGet challenge by id : ");
        Challenges challenges = (new ChallengesService(url, username, password)).getChallengeById(623);
        System.out.println(challenges.getId() + " | " + challenges.getName());

        System.out.println("\nGetting all possible challenges by name : " +
                (new ChallengesService(url, username, password)).getChallengesByName("Ukrainian").size()
        );

        // Tasks :
        System.out.println("\nGet task by id : ");
        Task task = (new TaskService(url, username, password)).getTaskById(700);
        System.out.println(task.getId() + " | " + task.getName());

        System.out.println("\nGet tasks by name : ");
        for (Task eachTask : (new TaskService(url, username, password)).getTasksByName("string")) {
            System.out.println(eachTask.getId() + " | " + eachTask.getName());
        }

        // Centers :
        System.out.println("\nGet center by id : ");
        Center center = (new CenterService(url, username, password)).getCenterById(29);
        System.out.println(center.getId() + " | " + center.getName());

        System.out.println("\nGet centers by name : ");
        for (Center eachCenter : (new CenterService(url, username, password)).getCentersByName("Java center")) {
            System.out.println(eachCenter.getUserId() + " | " + eachCenter.getName());
        }

        System.out.println("\nGet centers by  asc: ");
        for (Center centers : (new CenterService(url, username, password)).getCentresSortedByNameAsc(true)) {
            System.out.println(centers.getId()+ " | " + centers.getName());
        }

        // Locations :
        System.out.println("\nGet locations by name : ");
        for (Location eachLocation : (new LocationService(url, username, password)).getLocationByName("First")) {
            System.out.println(eachLocation.getId() + " | " + eachLocation.getName());
        }

        //Clubs
        System.out.println("\nGet club by id : ");
        Club club = (new ClubService(url, username, password)).getClubsById(47);
        System.out.println(club.getId() + " | " + club.getName());

        System.out.println("\nGet club by name : ");
        for (Club eachClub : (new ClubService(url, username, password)).getClubsByName("Курс «IT-Start»")) {
            System.out.println(eachClub.getId() + " | " + eachClub.getName());
        }
    }
}