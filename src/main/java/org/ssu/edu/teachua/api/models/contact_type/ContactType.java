package org.ssu.edu.teachua.api.models.contact_type;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactType {
    private int id;
    private String name;
    private String urlLogo;
}
