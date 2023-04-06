package org.ssu.edu.teachua.api.models.station;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.city.City;
import org.ssu.edu.teachua.api.models.district.District;

@Data
@AllArgsConstructor
public class Station {
    private int id;
    private String name;
    private City city;
    private District district;
}
