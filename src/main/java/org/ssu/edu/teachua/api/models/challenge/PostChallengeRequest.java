package org.ssu.edu.teachua.api.models.challenge;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostChallengeRequest {
    public String name;
    public String title;
    public String description;
    public String registrationLink;
    public String picture;
    public int sortNumber;
}
