package org.ssu.edu.teachua.api.models.challenge;

import lombok.Data;

import java.math.BigInteger;
import java.util.ArrayList;

@Data
public class GetChallengeResponse {
    private BigInteger id;
    private String name;
    private String title;
    private String description;
    private String picture;
    private BigInteger sortNumber;
    private Boolean isActive;
    private ArrayList<GetTaskInChallenge> tasks;
    private User user;
    private String registrationLink;
}
