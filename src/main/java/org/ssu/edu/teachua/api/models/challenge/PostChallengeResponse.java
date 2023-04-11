package org.ssu.edu.teachua.api.models.challenge;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PostChallengeResponse {
    private Integer id;
    private String name;
    private String title;
    private String description;
    private String registrationLink;
    private String picture;
    private BigInteger sortNumber;
    private Boolean isActive;
    private User user;
}
