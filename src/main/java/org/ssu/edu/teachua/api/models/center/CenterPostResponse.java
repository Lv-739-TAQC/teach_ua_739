package org.ssu.edu.teachua.api.models.center;

import lombok.Data;
import org.ssu.edu.teachua.api.models.location.LocationResponse;

import java.util.List;

@Data
public class CenterPostResponse {
    private Integer id;
    private Integer userId;
    private String name;
    private String email;
    private String phones;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private String contacts;
    private List<LocationResponse> locations;
}
