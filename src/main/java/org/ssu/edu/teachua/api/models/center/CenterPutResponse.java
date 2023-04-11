package org.ssu.edu.teachua.api.models.center;

import lombok.Data;
import org.ssu.edu.teachua.api.models.location.LocationResponse;

import java.util.List;

@Data
public class CenterPutResponse {
    private Integer id;
    private String name;
    private List<LocationResponse> locations;
    private String description;
    private String urlWeb;
    private String urlBackgroundPicture;
    private String urlLogo;
    private String clubsId;
    private Object userId;
    private String contacts;
    private Object centerExternalId;
}
