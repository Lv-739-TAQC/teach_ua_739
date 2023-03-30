package org.ssu.edu.teachua.api.models.club;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClubRequest {
    public int id;
    public String name;
    public String description;
    public int centerId;
    public String categoriesName;
    public int ageFrom;
    public int ageTo;
    public String urlBackground;
    public String urlLogo;
    public boolean isOnline;
    public String contacts;
    public boolean isApproved;
    public int userId;
    public int clubExternalId;
    public int centerExternalId;

    public ClubRequest(int id) {
    }
}
