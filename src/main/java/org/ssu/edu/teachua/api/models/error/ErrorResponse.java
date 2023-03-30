package org.ssu.edu.teachua.api.models.error;

import lombok.Data;

@Data
public class ErrorResponse {

    public int status;
    public String message;
}
