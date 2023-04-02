package org.ssu.edu.teachua.api.models.center;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.user.User;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Center {
    private int id;
    private String name;
    private String contacts;
    private String urlBackgroundPicture;
    private String description;
    private String urlWeb;
    private String urlLogo;
    private ArrayList<String> locations;
    private ArrayList<String> clubs;
    private User user;
    private int centerExternalId;
    private int rating;
    private int clubCount;
    private String email;
    private String phones;
    private String socialLinks;
}
