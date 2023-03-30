package org.ssu.edu.teachua.api.models.task;

import lombok.Data;

@Data
public class TaskResponse {
    private int id;
    private String name;
    private String headerText;
    private String description;
    private String picture;
    private String startDate;
    private int challengeId;
}

