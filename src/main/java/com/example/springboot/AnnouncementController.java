package com.example.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springboot.rest_client_canvas.config.Announcement;
import com.example.springboot.rest_client_canvas.config.AnnouncementClient;
import com.example.springboot.rest_client_canvas.config.Course;
import com.example.springboot.rest_client_canvas.config.CourseClient;

/**
 * 
 * AnnouncementController
 */

@Controller
public class AnnouncementController {

    private final CourseClient courseClient;
    private final AnnouncementClient announcementClient;

    public AnnouncementController(CourseClient courseClient, AnnouncementClient announcementClient) {
        this.courseClient = courseClient;
        this.announcementClient = announcementClient;
    }

    @GetMapping("/")
    public String index(@RequestParam(required = false) List<Long> courseIds, Model model) {
        List<Course> courses = courseClient.getAllCourses(1, 100).stream()
            .filter(c -> c != null && c.name() != null)
            .toList();

        Map<Long, String> courseNameMap = courses.stream()
            .collect(Collectors.toMap(Course::id, Course::name));

        List<AnnouncementView> announcementViews = new ArrayList<>();

        if (courseIds != null && !courseIds.isEmpty()) {
            for (Long selectedCourseId : courseIds) {
                List<Announcement> announcements = announcementClient
                    .getAnnouncementsForCourse(selectedCourseId, true, 1, 10);

                for (Announcement announcement : announcements) {
                    if (announcement != null && announcement.title() != null) {
                        announcementViews.add(new AnnouncementView(
                            selectedCourseId,
                            courseNameMap.getOrDefault(selectedCourseId, "Unknown Course"),
                            announcement.postedAt(),
                            announcement.message()
                        ));
                    }
                }
            }
        }

        model.addAttribute("courses", courses);
        model.addAttribute("courseIds", courseIds);
        model.addAttribute("announcementViews", announcementViews);

        return "index";
    }
}