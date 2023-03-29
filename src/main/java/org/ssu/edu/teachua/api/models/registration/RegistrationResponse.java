package org.ssu.edu.teachua.api.models.registration;

import lombok.Data;

@Data
public class RegistrationResponse {
    public int id;
    public String email;
    public String roleName;
}
