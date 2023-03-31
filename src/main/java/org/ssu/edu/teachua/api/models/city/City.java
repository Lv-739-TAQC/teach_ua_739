package org.ssu.edu.teachua.api.models.city;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class City {
    private int id;
    private String name;
    private int latitude;
    private int longitude;
}
