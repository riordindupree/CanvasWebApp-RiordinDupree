package com.example.springboot;

/**
 * Class defines record for Announcements table.
 * 
 * AnnouncementView
 * @param courseId : Id for course
 * @param courseName : name for course
 * @param postedAt : time announcement was posted
 * @param message : message of a given announcement
 */

public record AnnouncementView(
    Long courseId,
    String courseName,
    String postedAt,
    String message
) {}