package com.example.SwapShop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*")
                .allowedOrigins(
                        "http://swapshop-f96d.onrender.com/",
                        "https://localhost/",
                        "http://localhost/",
                        "capacitor://localhost",
                        "ionic://localhost"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("")
                .allowCredentials(true);
    }
}

