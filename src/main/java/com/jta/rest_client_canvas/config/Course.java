package com.jta.rest_client_canvas.config;

/**
 * Defines a Course record
 * 
 * Course
 * @param id : Id attached to course
 * @param name : Name for course
 * @param course_code : Code for course
 */

public record Course(
    Long id, 
    String name, 
    String courseCode
 ){}