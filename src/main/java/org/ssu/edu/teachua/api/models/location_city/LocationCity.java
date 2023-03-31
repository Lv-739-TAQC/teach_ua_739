package org.ssu.edu.teachua.api.models.location_city;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationCity {
    private int id;
    private String name;
    private int latitude;
    private int longitude;
}
