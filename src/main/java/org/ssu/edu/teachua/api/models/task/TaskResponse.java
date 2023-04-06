package org.ssu.edu.teachua.api.models.task;

import lombok.Data;

import java.util.List;

import java.math.BigInteger;

@Data
public class TaskResponse {
    private BigInteger id;
    private String name;
    private String headerText;
    private String description;
    private String picture;
    private BigInteger challengeId;
    private List<Integer> startDate;

    public String getStartDate() {
        return String.format("%s-%02d-%02d", startDate.get(0), startDate.get(1),startDate.get(2));
    }
}

