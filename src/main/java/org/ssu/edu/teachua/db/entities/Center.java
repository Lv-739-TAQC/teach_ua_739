package org.ssu.edu.teachua.db.entities;

import lombok.Data;
import org.ssu.edu.teachua.db.annotation.Column;
import org.ssu.edu.teachua.db.annotation.ManyToOne;
import org.ssu.edu.teachua.db.annotation.TableDB;

import java.math.BigInteger;

@TableDB(name = "centers")
@Data
public class Center extends Entity {

    @Column(name = "center_external_id")
    private BigInteger centerExternalId;

    @Column(name = "contacts")
    private String contacts;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "url_background_picture")
    private String urlBackgroundPicture;

    @Column(name = "url_logo")
    private String urlLogo;

    @Column(name = "url_web")
    private String urlWeb;

    @Column(name = "user_id")
    private BigInteger userId;

    @Column(name = "club_count")
    private BigInteger clubCount;

    @Column(name = "rating")
    private Double rating;

    @ManyToOne(foreignTable = "users", foreignColumnDB = "user_id")
    private User user;
}
