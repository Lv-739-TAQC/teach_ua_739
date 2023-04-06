package org.ssu.edu.teachua.api.models.location;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.ssu.edu.teachua.api.models.location_city.LocationCity;


@Data
@AllArgsConstructor
public class Location {
    private Integer id;
    private String name;
    private String address;
    private String cityName;
    private String districtName;
    private String stationName;
    private LocationCity locationCity;
    private Integer cityId;
    private Integer districtId;
    private Integer stationId;
    private Integer clubId;
    private Object coordinates;
    private Double longitude;
    private Double latitude;
    private String phone;
}
