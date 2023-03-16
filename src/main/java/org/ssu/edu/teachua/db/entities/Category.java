package org.ssu.edu.teachua.db.entities;

import lombok.Data;

import org.ssu.edu.teachua.db.annotation.Column;
import org.ssu.edu.teachua.db.annotation.ManyToMany;
import org.ssu.edu.teachua.db.annotation.TableDB;

import java.util.Set;

@TableDB(name = "categories")
@Data
public class Category extends Entity {

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

    @ManyToMany(foreignTable ="clubs", tableForManyToMany = "club_category",
            mainColumnDB = "category_id", foreignColumnDB = "club_id")
    private Set<Club> club;
}

