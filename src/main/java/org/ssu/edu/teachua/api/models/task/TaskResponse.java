package org.ssu.edu.teachua.api.models.task;

import lombok.Data;

@Data
public class TaskResponse {
    public String name;
    public String headerText;
    public String description;
    public String picture;
    public String startDate;
    public Integer challengeId;
}

