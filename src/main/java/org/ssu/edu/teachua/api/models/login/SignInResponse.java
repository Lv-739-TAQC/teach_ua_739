package org.ssu.edu.teachua.api.models.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SignInResponse {
    private int id;
    private String email;
    private String roleName;
    private String accessToken;
    private String refreshToken;
}
