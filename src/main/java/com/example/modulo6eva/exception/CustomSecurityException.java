package com.example.modulo6eva.exception;

public class CustomSecurityException extends RuntimeException {
    public CustomSecurityException(String message) {
        super(message);
    }

    public CustomSecurityException(String message, Throwable cause) {
        super(message, cause);
    }
}