package org.ssu.edu.teachua.api.models.challenge;

import lombok.Data;

import java.util.ArrayList;

@Data
public class GetChallengeResponse {

    private int id;
    private String name;
    private String title;
    private String description;
    private String picture;
    private int sortNumber;
    private boolean isActive;
    private ArrayList<GetTaskInChallenge> tasks;
    private User user;
    private String registrationLink;
}
