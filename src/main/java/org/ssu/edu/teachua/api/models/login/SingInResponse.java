package org.ssu.edu.teachua.api.models.login;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SingInResponse {
    public int id;
    public String email;
    public String roleName;
    public String accessToken;
    public String refreshToken;
}
