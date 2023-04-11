package org.ssu.edu.teachua.api.models.center;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.location.Location;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Center {
    private Integer id;
    private String name;
    private Object urlBackgroundPicture;
    private Object email;
    private Object phones;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private Object socialLinks;
    private Object user;
    private ArrayList<Location> locations;
    private Object contacts;
}
