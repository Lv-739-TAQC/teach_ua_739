package org.ssu.edu.teachua.api.models.challenge;

import lombok.Data;

import java.util.ArrayList;

@Data
public class DeleteChallengeResponse {
    private int id;
    private String name;
    private ArrayList<DeleteTaskInChallenge> tasks;
}
