package org.ssu.edu.teachua.api.models.task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskPutRequest {
    private String name;
    private String headerText;
    private String description;
    private String picture;
    private String startDate;
    private int challengeId;
}


