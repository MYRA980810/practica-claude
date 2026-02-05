package com.example.rest.web.springboot.crud_spring_web_jpa.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
