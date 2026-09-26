package com.example.springboot.rest_client_canvas.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines an Announcement record
 * 
 * @param id : number to indicate announcement
 * @param title : title of announcement
 * @param message : message contents
 * @param postedAt : time post was posted
 * @param htmlUrl : URL for canvas web UI
 * @param contextCode : defines course announcement is associated with
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
