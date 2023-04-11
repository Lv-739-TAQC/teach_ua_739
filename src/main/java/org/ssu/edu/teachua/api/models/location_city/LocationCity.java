package org.ssu.edu.teachua.api.models.location_city;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class LocationCity {
    private Integer id;
    private String name;
    private Double latitude;
    private Double longitude;
}