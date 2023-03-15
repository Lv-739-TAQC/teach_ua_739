package org.ssu.edu.teachua.db.service;

import java.sql.SQLException;
import java.util.List;

import org.ssu.edu.teachua.db.entities.Role;
import org.ssu.edu.teachua.db.entities.User;
import org.ssu.edu.teachua.db.repository.DBException;
import org.ssu.edu.teachua.db.repository.EntityException;

public class MainTestConnection {
	public static void main (String[] args) throws DBException, SQLException, EntityException {
		for (Role role : new RoleService().getRolls()) {
			System.out.println(role.getId() + " " + role.getName());
		}
		
		System.out.println("//////////////////////////////////");
		
		for (User user : new UserService().getUsersByEmail("admin@gmail.com")) {
			System.out.println(user.getEmail() + " " + user.getPassword() + " " + user.getRole().getName());
		}
	}
}