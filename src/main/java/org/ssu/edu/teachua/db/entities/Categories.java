package org.ssu.edu.teachua.db.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.ssu.edu.teachua.db.annotation.Column;
import org.ssu.edu.teachua.db.annotation.TableDB;

import java.math.BigInteger;

@TableDB(name = "categories")
@Data
@Setter
@Getter
public class Categories extends Entity {

    @Column(name = "id")
    public BigInteger id;

    @Column(name = "background_color")
    public String backgroundColor;

    @Column(name = "description")
    public String description;

    @Column(name = "name")
    public String name;

    @Column(name = "sortby")
    public Integer sortBy;

    @Column(name = "tag_background_color")
    public String tagBackgroundColor;

    @Column(name = "tag_text_color")
    public String tagTextColor;

    @Column(name = "url_logo")
    public String urlLogo;

}

