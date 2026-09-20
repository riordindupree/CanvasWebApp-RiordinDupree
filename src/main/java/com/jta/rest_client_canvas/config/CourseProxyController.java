package com.jta.rest_client_canvas.config;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Program takes courses, and displays them at /api/proxy/users
 * 
 * CourseProxyController
 */

@RestController
@RequestMapping("/api/proxy/courses")
public class CourseProxyController {
    private final CourseClient courseClient;

    public CourseProxyController(CourseClient courseClient) {
        this.courseClient = courseClient;
    }

    @GetMapping 
    public List<Course> listCourses() {
        // Finds courses from Canvas
        return courseClient.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course courseDetails(@PathVariable Long id) {
        // Finds id from courses from Canvas
        return courseClient.getCourseById(id);
    }
}
