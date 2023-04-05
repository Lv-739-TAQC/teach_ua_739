package org.ssu.edu.teachua.api.models.task;

import lombok.Data;

import java.util.List;

@Data
public class TaskResponse {
    private int id;
    private String name;
    private String headerText;
    private String description;
    private String picture;
    private List<Integer> startDate;
    private int challengeId;

    public String getStartDate() {
        return String.format("%s-%02d-%02d", startDate.get(0), startDate.get(1),startDate.get(2));
    }
}

