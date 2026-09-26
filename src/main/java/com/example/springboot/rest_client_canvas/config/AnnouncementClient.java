package com.example.springboot.rest_client_canvas.config;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

/**
 * Defines API contract for Announcement.
 * Note:
 *  - spring boot automatically generates implementation.
 * 
 * AnnouncementClient
 */

@HttpExchange("/api/v1")
public interface AnnouncementClient {

    @GetExchange("/courses/{courseId}/discussion_topics")
    List<Announcement> getAnnouncementsForCourse(
        @PathVariable("courseId") Long courseId,
        @RequestParam("only_announcements") boolean onlyAnnouncements,
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int perPage
    );
}
