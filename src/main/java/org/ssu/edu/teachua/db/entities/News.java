package org.ssu.edu.teachua.db.entities;

import lombok.Data;
import org.ssu.edu.teachua.db.annotation.Column;
import org.ssu.edu.teachua.db.annotation.ManyToOne;
import org.ssu.edu.teachua.db.annotation.TableDB;

@TableDB(name = "news")
@Data
public class News extends Entity {
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "url_title_logo")
    private String urlTitleLogo;
    @ManyToOne(foreignTable = "users", foreignColumnDB = "user_id")
    private User user;
}
