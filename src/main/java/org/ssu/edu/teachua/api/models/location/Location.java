package org.ssu.edu.teachua.api.models.location;

import lombok.AllArgsConstructor;
import lombok.Data;




@Data
@AllArgsConstructor
public class Location {
    private Integer id;
    private String name;
    private String address;
    private String cityName;
    private String districtName;
    private String stationName;
    private String coordinates;
    private String phone;
}
