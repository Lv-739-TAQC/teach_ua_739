package org.ssu.edu.teachua.api.models.feedback;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.user.User;

import java.util.Date;

@Data
@AllArgsConstructor
public class Feedback {
    private Integer id;
    private Double rate;
    private Date date;
    private String text;
    private User user;
    private String club;
}
