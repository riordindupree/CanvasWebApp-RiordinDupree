package com.example.springboot.rest_client_canvas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;

import jakarta.annotation.PostConstruct;

/**
 * Configures Canvas page based on .env file
 * 
 * SpringBoot4RestClientConfig
 */

@Configuration 
@ImportHttpServices(group = "external-api", types = {CourseClient.class, AnnouncementClient.class}) 
public class SpringBoot4RestClientConfig {
    
    // get environment variable for canvas
    @Value("${CANVAS_BASE_URL}")
    private String baseUrlString;
    
    @Value("${CANVAS_API_TOKEN}")
    private String apiTokenString;

    // throws an error if either URL or Token is null
    @PostConstruct
    public void validateConfig() {
        if (baseUrlString == null || baseUrlString.isBlank()) {
            throw new IllegalStateException("Missing CANVAS_BASE_URL. Set it before starting the app.");
        }
        if (apiTokenString == null || apiTokenString.isBlank()) {
            throw new IllegalStateException("Missing CANVAS_API_TOKEN. Set it before starting the app.");
        }
    }

    // Get external API values from remote system
    @Bean
    RestClientHttpServiceGroupConfigurer groupConfigure() {
        if (apiTokenString == null || apiTokenString.isBlank()) {
            throw new IllegalStateException("Missing CANVAS_API_TOKEN. Set it before starting the app.");
        }
        
        return groups -> groups.filterByName("external-api")
            .forEachClient((group, builder) -> { builder
                .baseUrl(baseUrlString)
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Authorization", "Bearer " + apiTokenString);
            });
    }
}

