package org.ssu.edu.teachua.api.models.challenge;

import lombok.Data;

@Data
public class PatchChallengeResponse {
    public String name;
    public int sortNumber;
    public String title;
}
