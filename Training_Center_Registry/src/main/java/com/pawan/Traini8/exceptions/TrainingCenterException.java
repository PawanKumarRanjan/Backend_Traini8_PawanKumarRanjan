package com.pawan.Traini8.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TrainingCenterException extends RuntimeException {

    public TrainingCenterException(String message) {
        super(message);
    }

    public TrainingCenterException(String message, Throwable cause) {
        super(message, cause);
    }
}