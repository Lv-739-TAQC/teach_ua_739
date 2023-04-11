package org.ssu.edu.teachua.api.models.location;

import lombok.Data;

@Data
public class LocationResponse {
    private Integer id;
    private String name;
    private String address;
    private Integer cityId;
    private Integer districtId;
    private Integer stationId;
    private String cityName;
    private String districtName;
    private String stationName;
    private Object coordinates;
    private Double longitude;
    private Double latitude;
    private Integer centerId;
    private Object clubId;
    private String phone;
}
