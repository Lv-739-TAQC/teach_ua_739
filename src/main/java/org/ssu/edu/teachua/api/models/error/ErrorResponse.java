package org.ssu.edu.teachua.api.models.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ErrorResponse {

    private int status;
    private String message;
}
