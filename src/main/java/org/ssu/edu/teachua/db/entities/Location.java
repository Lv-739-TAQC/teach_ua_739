package org.ssu.edu.teachua.db.entities;

import lombok.Data;
import org.ssu.edu.teachua.db.annotation.Column;
import org.ssu.edu.teachua.db.annotation.ManyToOne;
import org.ssu.edu.teachua.db.annotation.TableDB;

import java.math.BigInteger;

@TableDB(name = "locations")
@Data
public class Location extends Entity {

    @Column(name = "address")
    private String address;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "name")
    private String name;

    @Column(name = "center_id")
    private BigInteger centerID;

    @Column(name = "city_id")
    private BigInteger cityID;

    @Column(name = "district_id")
    private BigInteger districtID;

    @Column(name = "station_id")
    private BigInteger stationID;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(foreignTable = "stations", foreignColumnDB = "station_id")
    private Station station;

    @ManyToOne(foreignTable = "clubs", foreignColumnDB = "club_id")
    private Club club;

    @ManyToOne(foreignTable = "centers", foreignColumnDB = "center_id")
    private Center center;

    @ManyToOne(foreignTable = "cities", foreignColumnDB = "city_id")
    private City city;

    @ManyToOne(foreignTable = "districts", foreignColumnDB = "district_id")
    private District district;

}
