package org.ssu.edu.teachua.api.models.center;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ssu.edu.teachua.api.models.location.Location;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CenterRequest {
    private String name;
    private List<Location> locations;
    private String description;
    private String userId;
    private String contacts;
    private List<Integer> clubsId;
}
