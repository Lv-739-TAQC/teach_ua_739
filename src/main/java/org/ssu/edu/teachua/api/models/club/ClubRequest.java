package org.ssu.edu.teachua.api.models.club;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.location.Location;
import org.ssu.edu.teachua.api.models.url_gallery.UrlGallery;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ClubRequest {
    private int id;
    private String name;
    private String description;
    private int centerId;
    private ArrayList<String> categoriesName;
    private ArrayList<Location> locations;
    private int ageFrom;
    private int ageTo;
    private String urlBackground;
    private String urlLogo;
    private ArrayList<UrlGallery> urlGallery;
    private boolean isOnline;
    private String contacts;
    private boolean isApproved;
    private int userId;
    private int clubExternalId;
    private int centerExternalId;

}
