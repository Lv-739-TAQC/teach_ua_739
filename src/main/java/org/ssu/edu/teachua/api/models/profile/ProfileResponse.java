package org.ssu.edu.teachua.api.models.profile;

import lombok.Data;

@Data
public class ProfileResponse {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String roleName;
    public String urlLogo;
    public boolean status;
}
