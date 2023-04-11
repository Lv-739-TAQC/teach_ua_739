package org.ssu.edu.teachua.api.models.role;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Role {
    private Integer id;
    private String name;
    private ArrayList<String> users;
}
