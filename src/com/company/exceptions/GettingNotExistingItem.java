package com.company.exceptions;

public class GettingNotExistingItem extends Exception {
    private String message;

    public String getMessage() {
        return message;
    }

    public GettingNotExistingItem(String message) {
        super(message);
        this.message = message;
    }
}
