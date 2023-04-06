package org.ssu.edu.teachua.api.models.category;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    private Integer id;
    private Integer sortby;
    private String name;
    private String description;
    private String urlLogo;
    private String backgroundColor;
    private String tagBackgroundColor;
    private String tagTextColor;
}

