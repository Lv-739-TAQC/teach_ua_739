package org.ssu.edu.teachua.api.models.club;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubRequest {

    private List<String> categoriesName;
    private String name;
    private int ageFrom;
    private int ageTo;
    private boolean isOnline;
    private List<String> contacts;
    private String description;
    private List<String> locations;
    private Integer userId;
}
