package org.ssu.edu.teachua.api.models.registration;

import lombok.Data;

@Data
public class RegistrationResponse {
    private int id;
    private String email;
    private String roleName;
}
