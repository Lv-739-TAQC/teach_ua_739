package org.ssu.edu.teachua.api.models.profile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfilePatchRequest {
    public String oldPassword;
    public String newPassword;
    public String newPasswordVerify;
}
