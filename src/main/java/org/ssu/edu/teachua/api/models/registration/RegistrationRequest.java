package org.ssu.edu.teachua.api.models.registration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationRequest {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public String roleName;
}
