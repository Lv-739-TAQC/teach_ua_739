package org.ssu.edu.teachua.api.models.challenge;

import lombok.Data;

import java.util.ArrayList;

@Data
public class GetChallengeResponse {

    public int id;
    public String name;
    public String title;
    public String description;
    public String picture;
    public int sortNumber;
    public boolean isActive;
    public ArrayList<GetTaskInChallenge> tasks;
    public GetUser user;
    public String registrationLink;
}

class GetTaskInChallenge{
    public int id;
    public String name;
    public String headerText;
    public String picture;
    public String startDate;
}

class GetUser{
    public int id;
    public String firstName;
    public String lastName;
    public String urlLogo;
}
