package org.ssu.edu.teachua.api.models.club;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.location.Location;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ClubRequest {
    private ArrayList<String> categoriesName;
    private String name;
    private Integer ageFrom;
    private Integer ageTo;
    private Object urlLogo;
    private Object urlBackground;
    private Boolean isOnline;
    private String description;
    private String userId;
    private ArrayList<Location> locations;
    private String contacts;
    private Integer centerId;
}
