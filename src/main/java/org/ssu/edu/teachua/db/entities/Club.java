package org.ssu.edu.teachua.db.entities;

import lombok.Data;
import org.ssu.edu.teachua.db.annotation.Column;
import org.ssu.edu.teachua.db.annotation.ManyToMany;
import org.ssu.edu.teachua.db.annotation.ManyToOne;
import org.ssu.edu.teachua.db.annotation.TableDB;

import java.math.BigInteger;
import java.util.Set;

@TableDB(name = "clubs")
@Data
public class Club extends Entity {

    @Column(name = "age_from")
    private Integer ageFrom;

    @Column(name = "age_to")
    private Integer ageTo;

    @Column(name = "center_external_id")
    private BigInteger centerExternalId;

    @Column(name = "club_external_id")
    private BigInteger clubsExternalId;

    @Column(name = "contacts")
    private String contacts;

    @Column(name = "description")
    private String description;

    @Column(name = "is_approved")
    private Boolean isApproved;

    @Column(name = "is_online")
    private Boolean isOnline;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "url_background")
    private String urlBackground;

    @Column(name = "url_logo")
    private String urlLogo;

    @Column(name = "url_web")
    private String urlWeb;

    @Column(name = "work_time")
    private String workTime;

    @Column(name = "center_id")
    private BigInteger centerId;

    @Column(name = "user_id")
    private BigInteger userId;

    @Column(name = "feedback_count")
    private BigInteger feedbackCount;

    @ManyToOne(foreignTable = "users", foreignColumnDB = "user_id")
    private User userOwner;

    @ManyToMany(foreignTable ="categories", tableForManyToMany = "club_category",
            mainColumnDB = "club_id", foreignColumnDB = "category_id")
    private Set<Category> category;

}
