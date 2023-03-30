package org.ssu.edu.teachua.api.models.challenge;

import lombok.Data;

@Data
public class PutChallengeResponse {
    private int id;
    private String name;
    private String title;
    private String description;
    private String registrationLink;
    private String picture;
    private int sortNumber;
    private boolean isActive;
}
