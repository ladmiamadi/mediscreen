package com.ladmia.patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundPatientException extends RuntimeException{
    public NotFoundPatientException(String s) {
        super(s);
    }
}
