package org.ssu.edu.teachua.api.models.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String roleName;
    private String urlLogo;
    private boolean status;
}
