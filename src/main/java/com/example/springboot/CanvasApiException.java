package com.example.springboot;

/**
 * Defines canvas related exceptions to be used in the application.
 * 
 * CanvasApiException
 */

public class CanvasApiException extends RuntimeException {
    public CanvasApiException(String message) {
        super(message);
    }

    public CanvasApiException(String message, Throwable cause) {
        super(message, cause);
    }
}