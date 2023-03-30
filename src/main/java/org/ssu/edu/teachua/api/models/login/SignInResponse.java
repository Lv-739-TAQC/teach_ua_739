package org.ssu.edu.teachua.api.models.login;

import lombok.Data;

@Data
public class SignInResponse {
    public int id;
    public String email;
    public String roleName;
    public String accessToken;
    public String refreshToken;
}
