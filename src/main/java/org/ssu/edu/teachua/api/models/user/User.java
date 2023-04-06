package org.ssu.edu.teachua.api.models.user;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String urlLogo;
    private Object provider;
    private Object providerId;
    private Boolean status;
    private Object verificationCode;
}
