package org.ssu.edu.teachua.api.models.challenge;

import lombok.Data;

import java.util.ArrayList;

@Data
public class DeleteChallengeResponse {
    public int id;
    public String name;
    public ArrayList<DeleteTaskInChallenge> tasks;
}
class DeleteTaskInChallenge{
    public int id;
    public String name;

}
