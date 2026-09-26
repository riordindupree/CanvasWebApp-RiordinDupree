package com.example.springboot;

public record AnnouncementView(
    Long courseId,
    String courseName,
    String postedAt,
    String message
) {}