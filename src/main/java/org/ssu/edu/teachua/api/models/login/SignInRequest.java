package org.ssu.edu.teachua.api.models.login;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInRequest {
    public String email;
    public String password;
}
