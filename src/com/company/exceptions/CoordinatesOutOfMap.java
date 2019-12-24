package com.company.exceptions;

public class CoordinatesOutOfMap extends RuntimeException {
    private String message;

    public String getMessage() {
        return message;
    }

    public CoordinatesOutOfMap(String message) {
        super(message);
        this.message = message;
    }
}
