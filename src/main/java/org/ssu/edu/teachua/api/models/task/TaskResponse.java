package org.ssu.edu.teachua.api.models.task;

import lombok.Data;

import java.math.BigInteger;

@Data
public class TaskResponse {
    private BigInteger id;
    private String name;
    private String headerText;
    private String description;
    private String picture;
    private String startDate;
    private BigInteger challengeId;
}

