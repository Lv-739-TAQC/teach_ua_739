package org.ssu.edu.teachua.api.models.district;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.city.City;

@Data
@AllArgsConstructor
public class District {
    private int id;
    private String name;
    private City city;
}
