package org.ssu.edu.teachua.api.models.category;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Category {
    private int id;
    private int sortby;
    private String name;
    private String description;
    private String urlLogo;
    private String backgroundColor;
    private String tagBackgroundColor;
    private String tagTextColor;
    private ArrayList<String> clubs;
}
