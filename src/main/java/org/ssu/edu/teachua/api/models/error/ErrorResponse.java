package org.ssu.edu.teachua.api.models.error;

import lombok.Data;

@Data
public class ErrorResponse {

    private int status;
    private String message;
}
