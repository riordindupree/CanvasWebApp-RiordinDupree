package com.jta.rest_client_canvas.config;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * Defines API contract for Course.
 * Note:
 *  - spring boot automatically generates implementation.
 * 
 * CourseClient
 */

@HttpExchange("/api/v1/courses")
public interface CourseClient {
    
    @GetExchange
    List<Course> getAllCourses();

    @GetExchange("/{id}")
    Course getCourseById(@PathVariable("id") Long id);
}