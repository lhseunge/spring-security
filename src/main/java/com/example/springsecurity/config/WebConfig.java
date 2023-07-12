package com.example.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/pass/lunch")
                .allowedOrigins("http://192.168.0.36:8001")
                .allowedMethods("GET", "POST")
                .allowCredentials(true);
    }
}
