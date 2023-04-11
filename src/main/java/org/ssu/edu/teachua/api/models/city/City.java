package org.ssu.edu.teachua.api.models.city;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class City {
    private Integer id;
    private String name;
    private Double latitude;
    private Double longitude;
}
