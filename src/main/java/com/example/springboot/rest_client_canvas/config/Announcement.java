package com.example.springboot.rest_client_canvas.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines an Announcement record
 * 
 * @param id
 * @param title
 * @param message
 * @param postedAt
 * @param htmlUrl
 * @param contextCode
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Announcement(
    Long id,
    String title,
    String message,
    @JsonProperty("posted_at") String postedAt,
    @JsonProperty("html_url") String htmlUrl,
    @JsonProperty("context_code") String contextCode
) {}
