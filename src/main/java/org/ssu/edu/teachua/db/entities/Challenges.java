package org.ssu.edu.teachua.db.entities;


import lombok.Data;
import org.ssu.edu.teachua.db.annotation.Column;
import org.ssu.edu.teachua.db.annotation.ManyToOne;
import org.ssu.edu.teachua.db.annotation.TableDB;

import java.math.BigInteger;

@TableDB(name = "challenges")
@Data
public class Challenges extends Entity {

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "name")
    private String name;

    @Column(name = "picture")
    private String picture;

    @Column(name = "registration_link")
    private String registrationLink;

    @Column(name = "sort_number")
    private BigInteger sortNumber;

    @Column(name = "title")
    private String title;

    @Column(name = "user_id")
    private BigInteger userId;

    @ManyToOne(foreignTable = "users", foreignColumnDB = "user_id")
    private User user;
}
