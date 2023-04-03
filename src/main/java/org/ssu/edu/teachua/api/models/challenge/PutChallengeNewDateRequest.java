package org.ssu.edu.teachua.api.models.challenge;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PutChallengeNewDateRequest {
    private String startDate;
}
