package org.ssu.edu.teachua.db.entities;

import lombok.Data;
import org.ssu.edu.teachua.db.annotation.Column;
import org.ssu.edu.teachua.db.annotation.TableDB;

import java.math.BigInteger;

@TableDB(name = "club_category")
@Data
public class ClubsCategory extends Entity {

    @Column(name = "club_id")
    public BigInteger clubId;

    @Column(name = "category_id")
    public BigInteger categoryId;

}
