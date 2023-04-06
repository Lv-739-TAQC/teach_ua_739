package org.ssu.edu.teachua.api.models.club;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.category.Category;
import org.ssu.edu.teachua.api.models.center.Center;
import org.ssu.edu.teachua.api.models.location.Location;
import org.ssu.edu.teachua.api.models.user.User;

import java.math.BigInteger;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ClubResponse {
    private BigInteger id;
    private Integer ageFrom;
    private Integer ageTo;
    private String name;
    private String description;
    private Object urlWeb;
    private Object urlLogo;
    private Object urlBackground;
    private Object urlGallery;
    private Object workTime;
    private ArrayList<Category> categories;
    private User user;
    private Center center;
    private Double rating;
    private ArrayList<Location> locations;
    private Object isApproved;
    private Boolean isOnline;
}
