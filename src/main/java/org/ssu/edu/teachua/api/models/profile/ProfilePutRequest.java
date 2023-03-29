package org.ssu.edu.teachua.api.models.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfilePutRequest {
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String roleName;
    public String urlLogo;
    public boolean status;
}
