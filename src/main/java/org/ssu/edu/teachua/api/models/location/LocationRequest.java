package org.ssu.edu.teachua.api.models.location;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationRequest {
    public int id;
    public String name;
    public String address;
    public int cityId;
    public int districtId;
    public int stationId;
    public String cityName;
    public String districtName;
    public String stationName;
    public String coordinates;
    public int longitude;
    public int latitude;
    public int centerId;
    public int clubId;
    public String phone;
}
