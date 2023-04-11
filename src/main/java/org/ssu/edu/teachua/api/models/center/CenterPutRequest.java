package org.ssu.edu.teachua.api.models.center;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.location.Location;

import java.util.List;

@Data
@AllArgsConstructor
public class CenterPutRequest {
    private String name;
    private List<Location> locations;
    private String description;
    private String contacts;
    private List<Integer> clubsId;
}
