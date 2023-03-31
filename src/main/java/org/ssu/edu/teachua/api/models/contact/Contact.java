package org.ssu.edu.teachua.api.models.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ssu.edu.teachua.api.models.contact_type.ContactType;

@Data
@AllArgsConstructor
public class Contact {
    private ContactType contactType;
    private String contactData;
}
