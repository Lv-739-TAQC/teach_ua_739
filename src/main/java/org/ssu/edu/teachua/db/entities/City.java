package org.ssu.edu.teachua.db.entities;

import lombok.Data;
import org.ssu.edu.teachua.db.annotation.Column;
import org.ssu.edu.teachua.db.annotation.TableDB;

@TableDB(name = "cities")
@Data
public class City extends Entity {

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "name")
    private String name;
}
