package org.ssu.edu.teachua.db.entities;

import org.ssu.edu.teachua.db.annotation.Column;
import org.ssu.edu.teachua.db.annotation.ManyToOne;
import org.ssu.edu.teachua.db.annotation.TableDB;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Date;

@TableDB(name = "tasks")
@Data
public class Task extends Entity {

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "picture")
    private String picturePath;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "challenge_id")
    private BigInteger challengeId;

    @Column(name = "header_text")
    private String headerText;

    @ManyToOne(foreignTable = "challenges", foreignColumnDB = "challenge_id")
    private Challenges challenges;
}