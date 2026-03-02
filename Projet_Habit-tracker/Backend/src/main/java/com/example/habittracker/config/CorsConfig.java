package com.example.habittracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Ici je configure CORS pour que mon frontend puisse appeler mon backend
@Configuration
public class CorsConfig {

    // Je cree une config MVC personnalisee
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            // Cette methode sert a dire quelles origines ont le droit d'appeler l'API
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // j'autorise toutes mes routes
                        .allowedOrigins(
                                "http://localhost:5500",   // mon frontend en local
                                "http://127.0.0.1:5500"    // meme frontend avec autre ecriture
                        )
                        .allowedMethods(
                                "GET", "POST", "PUT", "DELETE", "OPTIONS"
                        ) // methodes HTTP autorisees
                        .allowedHeaders("*"); // j'accepte tous les headers pour simplifier
            }
        };
    }
}
