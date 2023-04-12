package org.ssu.edu.teachua.api.models.user;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class User {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String urlLogo;
    private String provider;
    private String providerId;
    private Boolean status;
    private String verificationCode;
}
