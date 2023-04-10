package org.ssu.edu.teachua.api.models.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.role.Role;

@Data
public class User {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String urlLogo;
    private Role role;
    private String provider;
    private String providerId;
    private boolean status;
    private String verificationCode;
}
