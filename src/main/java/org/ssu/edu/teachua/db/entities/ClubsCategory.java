package org.ssu.edu.teachua.db.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.ssu.edu.teachua.db.annotation.Column;
import org.ssu.edu.teachua.db.annotation.TableDB;

import java.math.BigInteger;

@TableDB(name = "club_category")
@Data
@Setter
@Getter
public class ClubsCategory extends Entity {

    @Column(name = "club_id")
    public BigInteger clubId;

    @Column(name = "category_id")
    public BigInteger categoryId;

}
