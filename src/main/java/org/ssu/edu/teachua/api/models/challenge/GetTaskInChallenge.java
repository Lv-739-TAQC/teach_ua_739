package org.ssu.edu.teachua.api.models.challenge;

import lombok.Data;

@Data
public class GetTaskInChallenge {
    private int id;
    private String name;
    private String headerText;
    private String picture;
    private String startDate;
}
