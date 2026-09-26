package com.example.springboot.rest_client_canvas.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines a Course record
 * 
 * Course
 * @param id : Id attached to course
 * @param name : Name for course
 * @param course_code : Code for course
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Course(
    Long id,
    String name,
    @JsonProperty("course_code") String courseCode
) {}