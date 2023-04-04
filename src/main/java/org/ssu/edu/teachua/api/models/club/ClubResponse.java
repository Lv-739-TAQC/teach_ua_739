package org.ssu.edu.teachua.api.models.club;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.category.Category;
import org.ssu.edu.teachua.api.models.center.Center;
import org.ssu.edu.teachua.api.models.feedback.Feedback;
import org.ssu.edu.teachua.api.models.location.Location;
import org.ssu.edu.teachua.api.models.user.User;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ClubResponse {
        private int id;
        private int ageFrom;
        private int ageTo;
        private String name;
        private String description;
        private String urlWeb;
        private String urlLogo;
        private String urlBackground;
        private ArrayList<String> urlGallery;
        private String workTime;
        private int rating;
        private int feedbackCount;
        private boolean isOnline;
        private ArrayList<Location> locations;
        private ArrayList<Feedback> feedbacks;
        private ArrayList<Category> categories;
        private User user;
        private Center center;
        private boolean isApproved;
        private String contacts;
        private int clubExternalId;
        private int centerExternalId;
}
