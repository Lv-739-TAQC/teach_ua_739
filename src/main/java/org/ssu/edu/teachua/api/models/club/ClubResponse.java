package org.ssu.edu.teachua.api.models.club;

import java.util.ArrayList;

public class ClubResponse {
    public class Club{
        public int id;
        public int ageFrom;
        public int ageTo;
        public String name;
        public String description;
        public String urlWeb;
        public String urlLogo;
        public String urlBackground;
        public ArrayList<String> urlGallery;
        public String workTime;
        public int rating;
        public int feedbackCount;
        public boolean isOnline;
        public ArrayList<LocationResponse> locations;
        public ArrayList<FeedbackResponse> feedbacks;
        public ArrayList<CategoryResponse> categories;
        public User user;
        public Center center;
        public boolean isApproved;
        public String contacts;
        public int clubExternalId;
        public int centerExternalId;
    }
}
