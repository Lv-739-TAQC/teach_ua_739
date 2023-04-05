package org.ssu.edu.teachua.api.models.challenge;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class PostChallengeRequest {
    private String name;
    private String title;
    private String description;
    private String registrationLink;
    private String picture;
    private BigInteger sortNumber;
}
