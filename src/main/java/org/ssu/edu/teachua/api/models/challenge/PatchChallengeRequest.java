package org.ssu.edu.teachua.api.models.challenge;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatchChallengeRequest {
    public String name;
    public int sortNumber;
    public String title;
}
