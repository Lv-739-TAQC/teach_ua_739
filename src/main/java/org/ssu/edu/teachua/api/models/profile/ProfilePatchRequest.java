package org.ssu.edu.teachua.api.models.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfilePatchRequest {
    private String oldPassword;
    private String newPassword;
    private String newPasswordVerify;
}
