package org.ssu.edu.teachua.db.entities;

import lombok.Data;
import org.ssu.edu.teachua.db.annotation.Column;
import org.ssu.edu.teachua.db.annotation.ManyToOne;
import org.ssu.edu.teachua.db.annotation.TableDB;

import java.math.BigInteger;

@TableDB(name = "districts")
@Data
public class District extends Entity {

    @Column(name = "name")
    private String name;

    @Column(name = "city_id")
    private BigInteger cityID;

    @ManyToOne(foreignTable = "cities", foreignColumnDB = "city_id")
    private City city;
}
