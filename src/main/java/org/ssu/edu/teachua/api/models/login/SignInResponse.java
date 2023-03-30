package org.ssu.edu.teachua.api.models.login;

import lombok.Data;

@Data
public class SignInResponse {
    private int id;
    private String email;
    private String roleName;
    private String accessToken;
    private String refreshToken;
}
