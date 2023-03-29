package org.ssu.edu.teachua.api.models.club;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClubRequest {
    public int id;
    public int ageFrom;
    public int ageTo;
    public String name;
    public String description;
    public String urlWeb;
    public String urlLogo;
    public String urlBackground;
    public String workTime;
    public double rating;
    public int feedbackCount;
    public boolean isOnline;
    public boolean isApproved;
    public String contacts;
    public int clubExternalId;
    public int centerExternalId;
}
