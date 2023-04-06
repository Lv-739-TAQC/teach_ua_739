package org.ssu.edu.teachua.api.models.club;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.category.Category;
import org.ssu.edu.teachua.api.models.center.Center;
import org.ssu.edu.teachua.api.models.location.Location;
import org.ssu.edu.teachua.api.models.user.User;

import java.util.List;

@Data
public class ClubResponse {
    private Integer id;
    private Integer ageFrom;
    private Integer ageTo;
    private String name;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private String urlBackground;
    private List<String> urlGallery;
    private String workTime;
    private List<Category> categories;
    private User user;
    private Center center;
    private Double rating;
    private List<Location> locations;
    private Boolean isApproved;
    private Boolean isOnline;
}
