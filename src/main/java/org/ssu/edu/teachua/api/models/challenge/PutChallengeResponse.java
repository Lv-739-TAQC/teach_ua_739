package org.ssu.edu.teachua.api.models.challenge;

import lombok.Data;

@Data
public class PutChallengeResponse {
    public int id;
    public String name;
    public String title;
    public String description;
    public String registrationLink;
    public String picture;
    public int sortNumber;
    public boolean isActive;
}
