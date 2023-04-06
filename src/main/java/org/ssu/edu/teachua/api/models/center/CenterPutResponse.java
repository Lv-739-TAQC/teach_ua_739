package org.ssu.edu.teachua.api.models.center;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CenterPutResponse {
    private Integer id;
    private String name;
    private ArrayList<String> locations;
    private String description;
    private String urlWeb;
    private String urlBackgroundPicture;
    private String urlLogo;
    private ArrayList<String> clubsId;
    private Integer userId;
    private String contacts;
    private Integer centerExternalId;
}
