package org.ssu.edu.teachua.api.models.url_gallery;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.club.ClubResponse;


@Data
@AllArgsConstructor
public class UrlGallery {
    private Integer id;
    private ClubResponse club;
    private String urlGallery;
    private String url;
}
