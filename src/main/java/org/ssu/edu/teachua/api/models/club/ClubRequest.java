package org.ssu.edu.teachua.api.models.club;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.location.LocationRequest;
import org.ssu.edu.teachua.api.models.url_gallery.UrlGalleryRequest;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ClubRequest {
    public int id;
    public String name;
    public String description;
    public int centerId;
    public ArrayList<String> categoriesName;
    public ArrayList<LocationRequest> locations;
    public int ageFrom;
    public int ageTo;
    public String urlBackground;
    public String urlLogo;
    public ArrayList<UrlGalleryRequest> urlGallery;
    public boolean isOnline;
    public String contacts;
    public boolean isApproved;
    public int userId;
    public int clubExternalId;
    public int centerExternalId;
}
