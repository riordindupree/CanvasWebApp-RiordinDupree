package com.example.springboot.rest_client_canvas.config;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Course> listCourses(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "100") int perPage
    ) {
        return courseClient.getAllCourses(page, perPage).stream()
            .filter(course -> course != null && course.name() != null)
            .toList();
    }


    @GetMapping("/{id}")
    public Course courseDetails(@PathVariable Long id) {
        // Finds id from courses from Canvas
        return courseClient.getCourseById(id);
    }
}
    