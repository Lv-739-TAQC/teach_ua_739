package org.ssu.edu.teachua.api.models.profile;

import lombok.Data;

@Data
public class ProfileResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String roleName;
    private String urlLogo;
    private boolean status;
}
