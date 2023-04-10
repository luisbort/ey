package com.ey.controllers.globalapi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Data
public class ApiMessage {

    @JsonIgnore
    private HttpStatus status;

    private String message;

    public ApiMessage() {
        super();
    }

    public ApiMessage(final HttpStatus status, final String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public ApiMessage(final String message) {
        super();
        this.message = message;
    }

}
