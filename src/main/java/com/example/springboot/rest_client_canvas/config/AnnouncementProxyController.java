package com.example.springboot.rest_client_canvas.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Program takes announcments, and displays them at /api/proxy/announcements
 * 
 * AnnouncementProxyController
 */

@RestController
@RequestMapping("/api/proxy")
public class AnnouncementProxyController {

    private final AnnouncementClient announcementClient;

    public AnnouncementProxyController(AnnouncementClient announcementClient) {
        this.announcementClient = announcementClient;
    }

    /**
     * Function returns announcements relevant to a selected course.
     * @param courseIds : Ids for a course
     * @return array list of announcements for a selected course
     */
    @GetMapping("/announcements")
    public List<Announcement> getAnnouncementsForSelectedCourses(
        @RequestParam("courseIds") List<Long> courseIds
    ) {
        List<Announcement> announcements = new ArrayList<>();

        for (Long courseId : courseIds) {
            announcements.addAll(
                announcementClient.getAnnouncementsForCourse(courseId, true, 1, 10)
                    .stream()
                    .filter(a -> a != null && a.title() != null)
                    .toList()
            );
        }

        return announcements;
    }
}