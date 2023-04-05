package org.ssu.edu.teachua.api.models.club;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.location.Location;
import org.ssu.edu.teachua.api.models.url_gallery.UrlGallery;

import java.math.BigInteger;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ClubRequest {
    private ArrayList<String> categoriesName;
    private String name;
    private int ageFrom;
    private int ageTo;
    private boolean isOnline;
    private ArrayList<String> contacts;
    private String description;
    private ArrayList<String> locations;
    private BigInteger userId;
}
