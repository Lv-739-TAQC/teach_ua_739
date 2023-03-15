package org.ssu.edu.teachua.db.entities;

import org.ssu.edu.teachua.db.annotation.Column;
import org.ssu.edu.teachua.db.annotation.ManyToOne;
import org.ssu.edu.teachua.db.annotation.TableDB;

import lombok.Data;

@TableDB(name = "users")
@Data
public class User extends Entity{

    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "provider")
    private String provider;
    @Column(name = "provider_id")
    private String providerId;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "url_logo")
    private String urlLogo;
    @Column(name = "verification_code")
    private String verification_code;
    @Column(name = "role_id")
    private Integer roleID;
    
    @ManyToOne(foreignTable ="roles", foreignColumnDB ="role_id")
    private Role role;
    
    
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Role getRole() {
		return role;
	}
    
 }
