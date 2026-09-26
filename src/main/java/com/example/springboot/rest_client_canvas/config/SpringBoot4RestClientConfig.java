package com.example.springboot.rest_client_canvas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration 
@ImportHttpServices(group = "external-api", types = {CourseClient.class, AnnouncementClient.class}) 
public class SpringBoot4RestClientConfig {
    
    // get environment variable for canvas
    @Value("${CANVAS_BASE_URL}")
    private String baseUrlString;
    
    @Value("${CANVAS_API_TOKEN}")
    private String apiTokenString;

    // Get external API values from remote system
    @Bean
    RestClientHttpServiceGroupConfigurer groupConfigure() {
        return groups -> groups.filterByName("external-api")
            .forEachClient((group, builder) -> { builder
                .baseUrl(baseUrlString)
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Authorization", "Bearer " + apiTokenString);
            });
    }
}

