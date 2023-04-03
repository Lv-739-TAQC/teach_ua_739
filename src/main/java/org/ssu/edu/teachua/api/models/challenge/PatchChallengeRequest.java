package org.ssu.edu.teachua.api.models.challenge;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatchChallengeRequest {
    private String name;
    private int sortNumber;
    private String title;
}
