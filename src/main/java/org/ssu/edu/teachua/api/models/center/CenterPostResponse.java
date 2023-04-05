package org.ssu.edu.teachua.api.models.center;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CenterPostResponse {
    private int id;
    private int userId;
    private String name;
    private String email;
    private String phones;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private String contacts;
    private ArrayList<String> locations;
}
