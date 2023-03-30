package org.ssu.edu.teachua.api.models.challenge;

import lombok.Data;

@Data
public class GetChallengesResponse {
    private int id;
    private String name;
    private int sortNumber;
    private String title;
}
