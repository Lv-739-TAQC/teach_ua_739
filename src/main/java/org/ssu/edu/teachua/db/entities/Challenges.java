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
    private boolean isActive;

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
    private Integer userId;


    public String getDescription() {
        return description;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public String getRegistrationLink() {
        return registrationLink;
    }

    public BigInteger getSortNumber() {
        return sortNumber;
    }

    public String getTitle() {
        return title;
    }

    public Integer getUserId() {
        return userId;
    }


    @ManyToOne(foreignTable = "users", foreignColumnDB = "user_id")
    private User user;
}
