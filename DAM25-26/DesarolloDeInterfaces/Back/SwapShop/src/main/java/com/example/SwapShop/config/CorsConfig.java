package com.example.SwapShop.config;  // Cambia esto si tu paquete es diferente

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Permite todas las rutas y subrutas
                .allowedOrigins(
                        "https://repo-clase.onrender.com",  // Tu frontend en Render
                        "http://localhost:4200",  // Localhost HTTP
                        "https://localhost",  // Localhost HTTPS
                        "capacitor://localhost",  // Para apps Capacitor
                        "ionic://localhost"  // Para apps Ionic
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")  // Agregué PATCH por si lo necesitas
                .allowedHeaders("*")  // Permite todos los headers (o lista específicos: "Content-Type", "Authorization")
                .exposedHeaders("Authorization", "Content-Type")  // Opcional: expone headers si los necesitas en el frontend
                .allowCredentials(true)  // Permite cookies/sesiones; cámbialo a false si no lo usas
                .maxAge(3600);  // Cache de preflight por 1 hora para optimizar
    }
}