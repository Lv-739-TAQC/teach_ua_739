package org.ssu.edu.teachua.db.entities;

import lombok.Data;
import org.ssu.edu.teachua.db.annotation.Column;
import org.ssu.edu.teachua.db.annotation.ManyToOne;
import org.ssu.edu.teachua.db.annotation.TableDB;

import java.math.BigInteger;

@TableDB(name = "stations")
@Data
public class Station extends Entity {
    @Column(name = "name")
    private String name;

    @Column(name = "city_id")
    private BigInteger cityID;

    @Column(name = "district_id")
    private BigInteger districtID;

    @ManyToOne(foreignTable = "cities", foreignColumnDB = "city_id")
    private City city;

    @ManyToOne(foreignTable = "districts", foreignColumnDB = "district_id")
    private District district;

}
