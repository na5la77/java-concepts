package org.example.jobportal.models;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
public class ExceptionResponse {
    private final LocalDateTime timestamp;
    private final String code;
    private final Map<String,String> message;

    public ExceptionResponse(HttpStatus code, Map<String,String> message) {
        this.timestamp = LocalDateTime.now();
        this.code = code.getReasonPhrase();
        this.message = message;
    }
}


