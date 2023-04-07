package org.ssu.edu.teachua.api.models.club;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ssu.edu.teachua.api.models.location.Location;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubRequest {
    private List<String> categoriesName;
    private String name;
    private Integer ageFrom;
    private Integer ageTo;
    private Boolean isOnline;
    private String description;
    private String userId;
    private List<Location> locations;
    private String contacts;
}
