package com.example.springboot;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

/**
 * Global exception handler for the UI.
 * 
 * CanvasExceptionHandler
 */

@ControllerAdvice
public class CanvasExceptionHandler {

    @ExceptionHandler(CanvasApiException.class)
    public String handleCanvasApiException(CanvasApiException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    @ExceptionHandler(ResourceAccessException.class)
    public String handleResourceAccessException(ResourceAccessException ex, Model model) {
        model.addAttribute("errorMessage", "Canvas is unavailable right now. Please check your network connection.");
        return "error";
    }

    @ExceptionHandler(RestClientResponseException.class)
    public String handleRestClientResponseException(RestClientResponseException ex, Model model) {
        model.addAttribute("errorMessage",
            "Canvas returned an error: " + ex.getStatusCode() + " " + ex.getStatusText());
        return "error";
    }

    @ExceptionHandler(IllegalStateException.class)
    public String handleIllegalStateException(IllegalStateException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }
}