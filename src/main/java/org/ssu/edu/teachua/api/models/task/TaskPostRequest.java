package org.ssu.edu.teachua.api.models.task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskPostRequest {
    public String name;
    public String headerText;
    public String description;
    public String picture;
    public String startDate;
}
