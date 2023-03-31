package org.ssu.edu.teachua.api.models.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.center.Center;
import org.ssu.edu.teachua.api.models.city.City;
import org.ssu.edu.teachua.api.models.district.District;
import org.ssu.edu.teachua.api.models.location_city.LocationCity;
import org.ssu.edu.teachua.api.models.station.Station;


@Data
@AllArgsConstructor
public class Location {
    private int id;
    private String name;
    private String address;
    private int cityId;
    private int districtId;
    private int stationId;
    private District district;
    private Station station;
    private City city;
    private LocationCity locationCity;
    private String club;
    private Center center;
    private String cityName;
    private String districtName;
    private String stationName;
    private String coordinates;
    private int longitude;
    private int latitude;
    private int centerId;
    private int clubId;
    private String phone;
}
