package org.example.jobportal.models;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ExceptionResponse {
    private final LocalDateTime timestamp;
    private final String code;
    private final String message;

    public ExceptionResponse(HttpStatus code, String message) {
        this.timestamp = LocalDateTime.now();
        this.code = code.getReasonPhrase();
        this.message = message;
    }
}


